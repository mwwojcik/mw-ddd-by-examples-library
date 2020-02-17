package mw.library.lending.book.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;
import mw.library.catalogue.BookId;
import mw.library.catalogue.BookType;
import mw.library.lending.librarybranch.model.LibraryBranchId;
import mw.library.lending.patron.model.PatronEvent;
import mw.library.lending.patron.model.PatronId;

@Value
@AllArgsConstructor
@EqualsAndHashCode(of = "bookInformation")
public class CheckedOutBook {
    BookInformation bookInformation;
    LibraryBranchId checkedOutAt;
    PatronId byPatron;

    public CheckedOutBook(BookId bookId, BookType type, LibraryBranchId checkedOutAt, PatronId patronId) {
        this.bookInformation = new BookInformation(bookId,type);
        this.checkedOutAt = checkedOutAt;
        this.byPatron=patronId;
    }

    public AvailableBook handle(PatronEvent.BookReturned bookReturnedByPatron) {
        return new AvailableBook(bookInformation, new LibraryBranchId(bookReturnedByPatron.getLibraryBranchId()));
    }
}
