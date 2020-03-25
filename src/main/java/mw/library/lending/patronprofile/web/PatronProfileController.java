package mw.library.lending.patronprofile.web;

import io.vavr.control.Option;
import io.vavr.control.Try;
import lombok.AllArgsConstructor;
import lombok.Value;
import mw.library.catalogue.BookId;
import mw.library.commons.commands.Result;
import mw.library.lending.librarybranch.model.LibraryBranchId;
import mw.library.lending.patron.application.checkout.CheckOutBookCommand;
import mw.library.lending.patron.application.checkout.CheckingOutBookOnHold;
import mw.library.lending.patron.application.hold.CancelingHold;
import mw.library.lending.patron.application.hold.PlaceOnHoldCommand;
import mw.library.lending.patron.application.hold.PlacingOnHold;
import mw.library.lending.patron.model.PatronId;
import mw.library.lending.patronprofile.model.PatronProfiles;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Collection;
import java.util.UUID;

@RestController
class PatronProfileController {

  private PlacingOnHold placingOnHold;
  private CancelingHold cancelingHold;
  private PatronProfiles patronProfiles;

  private CheckingOutBookOnHold checkingOutBookOnHold;

  /** ******* HOLDS ************* */
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

  /** ********** CHECKOUTS ***************** */
  @GetMapping("/profiles/{patronId}/checkouts")
  public ResponseEntity<Collection<CheckOut>> findCheckouts(
      @PathVariable(name = "patronId") UUID patronId) {
    return null;
  }

  @GetMapping("/profiles/{patronId}/checkouts/{bookId}")
  public ResponseEntity<CheckOut> findCheckout(
      @PathVariable(name = "bookId") UUID bookId, @PathVariable(name = "patronId") UUID patronId) {
    return null;
  }

  @PostMapping("/profiles/{patronId}/checkouts")
  public ResponseEntity checkOut(
      @PathVariable(name = "patronId") UUID patronId,
      @RequestBody CheckOutRequest checkOutRequest) {

    var result = checkingOutBookOnHold.checkOut(
            CheckOutBookCommand.of(
                    new PatronId(patronId),
                    new LibraryBranchId(checkOutRequest.getLibraryBranchId()),
                    new BookId(checkOutRequest.getBookId()),
                    checkOutRequest.getNumberOfDays()
            )
    );

    return result.map(success->ResponseEntity.ok().build())
            .getOrElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
  }
}

@Value
class Hold {
  UUID bookId;
  Instant till;
}

class CheckOut {
  UUID bookId;
  Instant till;
}

@Value
@AllArgsConstructor
class PlaceHoldRequest {
  UUID bookId;
  UUID libraryBranchId;
  Integer numberOfDays;
}

@Value
@AllArgsConstructor
class CheckOutRequest {
  UUID bookId;
  UUID libraryBranchId;
  Integer numberOfDays;
}
