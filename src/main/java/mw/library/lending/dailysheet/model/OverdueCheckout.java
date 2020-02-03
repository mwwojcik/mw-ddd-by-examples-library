package mw.library.lending.dailysheet.model;

import lombok.Value;
import mw.library.catalogue.BookId;
import mw.library.lending.librarybranch.model.LibraryBranchId;
import mw.library.lending.patron.model.PatronEvent;
import mw.library.lending.patron.model.PatronId;

@Value
class OverdueCheckout {
   BookId checkedOutBook;
   PatronId patronId;
   LibraryBranchId library;

   PatronEvent.OverdueCheckoutRegistered toEvent(){
       return PatronEvent.OverdueCheckoutRegistered.now(patronId, checkedOutBook, library);
   }
}
