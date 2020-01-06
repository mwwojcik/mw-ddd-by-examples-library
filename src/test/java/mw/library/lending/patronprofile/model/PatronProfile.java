package mw.library.lending.patronprofile.model;

import lombok.Value;
import mw.library.catalogue.BookId;

import java.util.Optional;

@Value
public class PatronProfile {
    HoldsView holdsView;
    CheckoutsView currentCheckout;

    public Optional<Hold> findHold(BookId bookId) {
        return holdsView.getCurrentHolds()
                .stream()
                .filter(hold-> hold.getBook().equals(bookId))
                .findFirst();
      }

      public Optional<Checkout> findCheckout(BookId bookId) {
        return currentCheckout.getCurrentCheckouts()
                .stream()
                .filter(checkout->checkout.getBook().equals(bookId))
                .findFirst();
    }
}
