package mw.library.lending.patron.model;

import mw.library.catalogue.BookId;
import mw.library.catalogue.BookType;
import mw.library.lending.book.model.AvailableBook;
import mw.library.lending.book.model.BookInformation;
import mw.library.lending.librarybranch.model.LibraryBranchId;

import java.util.UUID;

class BookFixture {
    public static AvailableBook circulatingAvailableBook() {
        return circulatingAvailableBookAt(anyBranchId());
    }

    private static LibraryBranchId anyBranchId() {
        return new LibraryBranchId(UUID.randomUUID());
    }

    public static AvailableBook circulatingAvailableBookAt(LibraryBranchId libraryBranchId) {
        return new AvailableBook(new BookInformation(anyBookId(), BookType.Typical), libraryBranchId);
    }

    private static BookId anyBookId() {
        return new BookId(UUID.randomUUID());
    }

}
