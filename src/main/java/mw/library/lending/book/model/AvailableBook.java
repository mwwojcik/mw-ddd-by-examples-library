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
public class AvailableBook implements Book{

    BookInformation bookInformation;
    LibraryBranchId libraryBranchId;

    public AvailableBook(BookType bookType,
                         BookId bookId,
                         LibraryBranchId libraryBranchId) {
        this.bookInformation = new BookInformation(bookId, bookType);
        this.libraryBranchId = libraryBranchId;
    }

    public boolean isRestricted() {
        return bookInformation.getBookType().equals(BookType.Restricted);
    }

    //EVENT Handler
    public BookOnHold handle(PatronEvent.BookPlacedOnHold bookPlaceOnHold){
        return new BookOnHold(
                bookInformation,
                new LibraryBranchId(bookPlaceOnHold.getLibraryBranchId()),
                new PatronId(bookPlaceOnHold.getPatronId()),
                bookPlaceOnHold.getHoldTill()
        );
    }


    public BookId getBookId() {
        return bookInformation.getBookId();
    }

    public LibraryBranchId getLibraryBranch() {
        return libraryBranchId;
    }
}
