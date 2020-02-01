package mw.library.lending.patron.model;

import mw.library.catalogue.BookId;
import mw.library.catalogue.BookType;
import mw.library.lending.book.model.AvailableBook;
import mw.library.lending.book.model.BookInformation;
import mw.library.lending.book.model.BookOnHold;
import mw.library.lending.librarybranch.model.LibraryBranchId;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static mw.library.lending.patron.model.PatronFixture.anyPatronId;

public class BookFixture {
    public static AvailableBook circulatingAvailableBook() {
        return circulatingAvailableBookAt(anyBranchId());
    }

    public static LibraryBranchId anyBranchId() {
        return new LibraryBranchId(UUID.randomUUID());
    }

    public static AvailableBook circulatingAvailableBookAt(LibraryBranchId libraryBranchId) {
        return new AvailableBook(new BookInformation(anyBookId(), BookType.Typical), libraryBranchId);
    }

    private static BookId anyBookId() {
        return new BookId(UUID.randomUUID());
    }

    static Set<Hold> booksOnHold(int numberOfHolds) {
        return IntStream
                .rangeClosed(1, numberOfHolds)
                .mapToObj(i -> new Hold(anyBookId(), anyBranchId()))
                .collect(Collectors.toSet());
    }

    static Map<LibraryBranchId, Set<BookId>> overdueCheckoutsAtBranch(int numberOfCheckouts, LibraryBranchId branchId) {
        var bookIdSet = IntStream
                .rangeClosed(1, numberOfCheckouts)
                .mapToObj(i -> anyBookId())
                .collect(Collectors.toSet());
        var checkouts = new HashMap<LibraryBranchId, Set<BookId>>();
        checkouts.put(branchId, bookIdSet);
        return checkouts;
    }

    public static BookOnHold bookOnHold() {
        return new BookOnHold(anyBookInformation(), anyBranchId(), anyPatronId(), Instant.now());
    }

    private static BookInformation anyBookInformation() {
        return new BookInformation(anyBookId(), BookType.Typical);
    }
}
