package mw.library.lending.patron.application.checkout;

import lombok.Value;
import mw.library.catalogue.BookId;
import mw.library.lending.librarybranch.model.LibraryBranchId;
import mw.library.lending.patron.model.CheckOutDuration;
import mw.library.lending.patron.model.PatronId;

import java.time.Instant;

@Value
public class CheckOutBookCommand {
  Instant timestamp;
  PatronId patronId;
  LibraryBranchId libraryId;
  BookId bookId;
  Integer noOfDays;

  public static CheckOutBookCommand of(
      PatronId patronId, LibraryBranchId branchId, BookId bookId, int noOfDays) {
    return new CheckOutBookCommand(Instant.now(), patronId, branchId, bookId, noOfDays);
  }

  CheckOutDuration checkOutDuration() {
    return CheckOutDuration.forNoOfDays(noOfDays);
  }
}
