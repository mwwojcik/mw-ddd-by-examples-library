package mw.library.lending.patronprofile.web;

import io.vavr.control.Option;
import lombok.AllArgsConstructor;
import lombok.Value;
import mw.library.catalogue.BookId;
import mw.library.lending.librarybranch.model.LibraryBranchId;
import mw.library.lending.patron.application.hold.PlaceOnHoldCommand;
import mw.library.lending.patron.application.hold.PlacingOnHold;
import mw.library.lending.patron.model.Hold;
import mw.library.lending.patron.model.PatronId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
class PatronProfileController {

  private PlacingOnHold placingOnHold;

  @GetMapping("/profiles/{patronId}/holds/{bookId}")
  private ResponseEntity<Hold> findHold(
      @PathVariable(name = "patronId") UUID patronId, @PathVariable(name = "bookId") UUID bookId) {
    return null;
  }

  @GetMapping("/profiles/{patronId}/holds")
  public ResponseEntity<Collection<Hold>> findHolds(
      @PathVariable(name = "patronId") UUID patronId) {
    return null;
  }

  @PostMapping("/profiles/{patronId}/holds")
  public ResponseEntity placeHold(
      @PathVariable UUID patronId, @RequestBody PlaceHoldRequest placeHoldRequest) {
    var results =
        placingOnHold.placeOnHold(
            PlaceOnHoldCommand.of(
                new PatronId(patronId),
                new LibraryBranchId(placeHoldRequest.getLibraryBranchId()),
                new BookId(placeHoldRequest.getBookId()),
                Option.of(placeHoldRequest.getNumberOfDays())));

    return results
        .map(success -> ResponseEntity.ok().build())
        .getOrElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
  }

  @DeleteMapping("/profiles/{patronId}/holds/{bookId}")
  private ResponseEntity<Hold> cancelHold(
      @PathVariable(name = "patronId") UUID patronId, @PathVariable(name = "bookId") UUID bookId) {

    return null;
  }
}

@Value
@AllArgsConstructor
class PlaceHoldRequest {
  UUID bookId;
  UUID libraryBranchId;
  Integer numberOfDays;
}
