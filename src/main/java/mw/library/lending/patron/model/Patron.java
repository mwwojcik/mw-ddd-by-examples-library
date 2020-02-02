package mw.library.lending.patron.model;

import io.vavr.collection.List;
import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import mw.library.commons.events.EitherResult;
import mw.library.lending.book.model.AvailableBook;
import mw.library.lending.book.model.BookOnHold;
import mw.library.lending.librarybranch.model.LibraryBranchId;

import static mw.library.commons.events.EitherResult.announceFailure;
import static mw.library.commons.events.EitherResult.announceSuccess;
import static mw.library.lending.patron.model.PatronEvent.BookPlacedOnHoldEvents.events;
import static mw.library.lending.patron.model.PatronHolds.MAX_NUMBER_OF_HOLDS;

@EqualsAndHashCode(of = "patron")
@AllArgsConstructor
public class Patron {
    private PatronInformation patron;

    private List<PlacingOnHoldPolicy> placingOnHoldPolicies;

    private OverdueCheckouts overdueCheckouts;

    private PatronHolds patronHolds;

    public Either<PatronEvent.BookHoldFailed, PatronEvent.BookPlacedOnHoldEvents> placeOnHold(AvailableBook book) {
        return placeOnHold(book, HoldDuration.openEnded());
    }

    public Either<PatronEvent.BookHoldFailed, PatronEvent.BookPlacedOnHoldEvents>
    placeOnHold(AvailableBook aBook, HoldDuration holdDuration) {
        Option<Rejection> rejection = patronCanHold(aBook, holdDuration);
        if (rejection.isEmpty()) {
            PatronEvent.BookPlacedOnHold bookPlacedOnHold = PatronEvent.BookPlacedOnHold.bookPlacedOnHoldNow
                    (aBook.getBookId(), aBook.type(), aBook.getLibraryBranch(), patron.getPatronId(), holdDuration);
            if (patronHolds.maximumHoldsAfterHolding(aBook)) {
                return announceSuccess(events(bookPlacedOnHold, MaximumNumberOfHoldsReached.now(patron, MAX_NUMBER_OF_HOLDS)));
            }
            return announceSuccess(events(bookPlacedOnHold));
        }
        return EitherResult.announceFailure(PatronEvent.BookHoldFailed.now(rejection.get(), aBook.getBookId(), aBook.getLibraryBranch(), patron));
    }

    public Either<PatronEvent.BookHoldCancelingFailed, PatronEvent.BookHoldCanceled> cancelHold(BookOnHold book) {
        if (patronHolds.a(book)) {
            announceSuccess(PatronEvent.BookHoldCanceled.holdCancelNow(book.getBookInformation().getBookId(),
                    patron.getPatronId(),
                    book.getLibraryBranchId()
            ));
        }
        return EitherResult.announceFailure(
                PatronEvent.BookHoldCancelingFailed.holdCancelingFailedNow(
                        book.getBookInformation().getBookId(),
                        book.getLibraryBranchId(),
                        patron.getPatronId()
                )
        );
    }

    public Either<PatronEvent.BookCheckingOutFailed, PatronEvent.BookCheckedOut> checkOut(BookOnHold book, CheckOutDuration duration) {
        if (patronHolds.a(book)) {
         return announceSuccess(PatronEvent.BookCheckedOut.now(patron.getPatronId(),book.getBookInformation().getBookId(),book.getLibraryBranchId()));
        }
        return announceFailure(PatronEvent.BookCheckingOutFailed.now(patron.getPatronId(),book.getBookInformation().getBookId(),book.getLibraryBranchId()
                ,Rejection.withReason("book is not on hold by patron")));
    }

    /**
     * Private methods
     */

    private Option<Rejection> patronCanHold(AvailableBook aBook, HoldDuration holdDuration) {
        return placingOnHoldPolicies
                .toStream()
                .map(policy -> policy.apply(aBook, this, holdDuration))
                .find(Either::isLeft)
                .map(Either::getLeft)
                ;

    }


    boolean isRegular() {
        return patron.isRegular();
    }

    public int overdueCheckoutsAt(LibraryBranchId libraryBranchId) {
        return overdueCheckouts.countAt(libraryBranchId);
    }

    public int numberOfHolds() {
        return patronHolds.count();
    }
}
