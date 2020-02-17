package mw.library.lending.book.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;
import mw.library.catalogue.BookId;
import mw.library.lending.librarybranch.model.LibraryBranchId;
import mw.library.lending.patron.model.PatronEvent;
import mw.library.lending.patron.model.PatronId;

import java.time.Instant;


@Value
@AllArgsConstructor
@EqualsAndHashCode(of = "bookInformation")
public class BookOnHold implements Book {
    BookInformation bookInformation;
    LibraryBranchId libraryBranchId;
    PatronId byPatron;
    Instant holdTill;

    public AvailableBook handle(PatronEvent.BookReturned bookReturned) {
        return new AvailableBook(bookInformation, libraryBranchId);
    }

    public AvailableBook handle(PatronEvent.BookHoldExpired bookHoldExpired) {
        return new AvailableBook(bookInformation, new LibraryBranchId(bookHoldExpired.getLibraryBranchId()));
    }

    public AvailableBook handle(PatronEvent.BookHoldCanceled bookHoldCanceled) {
        return new AvailableBook(bookInformation, new LibraryBranchId(bookHoldCanceled.getLibraryBranchId()));
    }

    public CheckedOutBook handle(PatronEvent.BookCheckedOut bookCheckedOut) {
        return new CheckedOutBook(bookInformation.getBookId(),
                bookInformation.getBookType(),
                libraryBranchId,
                byPatron);
    }

    public BookId getBookId() {
        return bookInformation.getBookId();
    }

    public boolean by(PatronId patronId) {
        return byPatron.equals(patronId);
    }
}
