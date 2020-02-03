package mw.library.lending.patronprofile.model;

import lombok.Value;
import mw.library.catalogue.BookId;

import java.util.List;
import java.util.Optional;

@Value
public class PatronProfile {
    List<Hold> currentHolds;
    List<Checkout> currentCheckouts;

    public Optional<Hold> findHold(BookId bookId) {
        return getCurrentHolds()
                .stream()
                .filter(hold -> hold.getBook().equals(bookId))
                .findFirst();
    }

    public Optional<Checkout> findCheckout(BookId bookId) {
        return getCurrentCheckouts()
                .stream()
                .filter(checkout -> checkout.getBook().equals(bookId))
                .findFirst();
    }
}
