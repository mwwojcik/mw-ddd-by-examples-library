package mw.library.lending.patron.application.hold;

import lombok.Value;
import mw.library.catalogue.BookId;
import mw.library.lending.librarybranch.model.LibraryBranchId;
import mw.library.lending.patron.model.HoldDuration;
import mw.library.lending.patron.model.NumberOfDays;
import mw.library.lending.patron.model.PatronId;

import java.time.Instant;
import java.util.Optional;

@Value
public
class PlaceOnHoldCommand {
  Instant timeStamp;
  PatronId patronId;
  LibraryBranchId libraryId;
  BookId bookId;
  Optional<Integer> noOfDays;

  public static PlaceOnHoldCommand closeEnded(
      PatronId patronId, LibraryBranchId libraryBranchId, BookId bookId, int forDays) {
    return new PlaceOnHoldCommand(
        Instant.now(), patronId, libraryBranchId, bookId, Optional.of(forDays));
  }

  public static PlaceOnHoldCommand openEnded(
      PatronId patronId, LibraryBranchId libraryBranchId, BookId bookId) {
    return new PlaceOnHoldCommand(Instant.now(), patronId, libraryBranchId, bookId, Optional.empty());
  }

  public static PlaceOnHoldCommand of(
      PatronId patronId, LibraryBranchId libraryBranchId, BookId bookId, Optional noOfDays) {
    return new PlaceOnHoldCommand(Instant.now(), patronId, libraryBranchId, bookId, noOfDays);
  }

  private HoldDuration getHoldDuration() {
    return noOfDays
        .map(NumberOfDays::of)
        .map(HoldDuration::closeEnded)
        .orElseGet(HoldDuration::openEnded);
  }
}
