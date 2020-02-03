package mw.library.lending.dailysheet.model;

import lombok.Value;
import mw.library.catalogue.BookId;
import mw.library.lending.librarybranch.model.LibraryBranchId;
import mw.library.lending.patron.model.PatronEvent;
import mw.library.lending.patron.model.PatronId;

@Value
class ExpiredHold {
    BookId heldBook;
    PatronId patronId;
    LibraryBranchId library;

    PatronEvent.BookHoldExpired toEvent(){
        return PatronEvent.BookHoldExpired.now(patronId, heldBook, library);
    }
}
