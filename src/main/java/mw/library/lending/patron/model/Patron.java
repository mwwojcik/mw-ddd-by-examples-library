package mw.library.lending.patron.model;

import io.vavr.control.Either;
import lombok.EqualsAndHashCode;
import mw.library.lending.book.model.AvailableBook;

import java.util.List;

@EqualsAndHashCode(of = "patron")
public class Patron {
    private PatronInformation patron;

    private List<PlacingOnHoldPolicy> placingOnHoldPolicies;

    private OverdueCheckouts overdueCheckouts;

    private PatronHolds patronHolds;

//TODO

    public Either<PatronEvent.BookHoldFailed, PatronEvent.BookPlacedOnHoldEvents> placeOnHold(AvailableBook book) {
        return placeOnHold(book, HoldDuration.openEnded());
    }

    public Either<PatronEvent.BookHoldFailed, PatronEvent.BookPlacedOnHoldEvents>
    placeOnHold(AvailableBook aBook, HoldDuration holdDuration) {
        //todo
        return null;
    }
}
