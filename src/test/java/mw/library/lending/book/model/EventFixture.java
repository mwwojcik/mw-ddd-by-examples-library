package mw.library.lending.book.model;

import mw.library.catalogue.BookId;
import mw.library.lending.librarybranch.model.LibraryBranchId;
import mw.library.lending.patron.model.PatronEvent;
import mw.library.lending.patron.model.PatronId;

import java.time.Instant;

class EventFixture {
    public static PatronEvent.BookPlacedOnHold publishPlacedOnHoldEvent(PatronId byPatron,
                                                                        AvailableBook availableBook,
                                                                        LibraryBranchId libraryBranchId,
                                                                        Instant from,
                                                                        Instant till) {
        return new PatronEvent.BookPlacedOnHold(Instant.now(),
                byPatron.getPatronId(),
                availableBook.getBookId().getBookId(),
                availableBook.getBookInformation().getBookType(),
                libraryBranchId.getLibraryBranchId(),
                from,
                till);
    }

    public static PatronEvent.BookHoldCanceled publishCancellingHoldEvent(PatronId patronId, BookId bookId, LibraryBranchId libraryBranchId) {
        return new PatronEvent.BookHoldCanceled(Instant.now(),
                patronId.getPatronId(),
                bookId.getBookId(),
                libraryBranchId.getLibraryBranchId()
        );
    }
}
