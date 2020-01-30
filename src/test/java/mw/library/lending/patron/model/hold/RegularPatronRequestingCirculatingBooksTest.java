package mw.library.lending.patron.model.hold;

import mw.library.lending.patron.model.BookFixture;
import mw.library.lending.patron.model.HoldDuration;
import mw.library.lending.patron.model.PatronFixture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;

class RegularPatronRequestingCirculatingBooksTest {

    @DisplayName("a regular patron cannot place on hold more than 5 books")
    @Test
    void regularPatronCannotPlaceOnHoldMoreThan5Books()
            throws Exception {
        // given
        var patron = PatronFixture.regularPatronWithHolds(5);
        var availableBook = BookFixture.circulatingAvailableBook();
        // when 
        var result = patron.placeOnHold(availableBook, HoldDuration.openEnded(Instant.now()));
        // then
        Assertions.assertThat(result.isLeft()).isEqualTo(true);

    }

    @DisplayName("a regular patron can place on hold book when he did not place on hold more than 4 books")
    @Test
    void regularPatronCanPlaceOnHoldWhenHas4Books()
            throws Exception {
        // given
        var patron = PatronFixture.regularPatronWithHolds(4);
        var book = BookFixture.circulatingAvailableBook();
        // when 
        var result = patron.placeOnHold(book, HoldDuration.closeEnded(3));
        // then

        Assertions.assertThat(result.isRight()).isEqualTo(true);
        Assertions.assertThat(result.get().getMaximumNumberOfHoldsReached()).isNotEmpty();

    }
}
