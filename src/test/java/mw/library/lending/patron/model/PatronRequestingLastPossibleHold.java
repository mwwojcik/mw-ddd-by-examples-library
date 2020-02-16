package mw.library.lending.patron.model;

import mw.library.lending.book.model.BookFixture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PatronRequestingLastPossibleHold {
    @DisplayName("should announce that a regular patron places his last possible hold (4th)")
    @Test void shouldPlaceLastPossibleHold()
     throws Exception {
      // given
        var actualNumberOfHolds = 4;
        var patronWithFourHolds= PatronFixture.regularPatronWithHolds(actualNumberOfHolds);
        var availableBook= BookFixture.circulatingAvailableBook();
        // when 
        var result = patronWithFourHolds.placeOnHold(availableBook, HoldDuration.closeEnded(3));
        // then
        Assertions.assertThat(result.isRight());

        var bookPlacedOnHoldEvents = result.get();
        Assertions.assertThat(bookPlacedOnHoldEvents.getMaximumNumberOfHoldsReached().isDefined()).isEqualTo(true);

    }

}
