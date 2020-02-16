package mw.library.lending.book.model;

import mw.library.lending.patron.model.PatronFixture;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Fail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;

class BookPlacingOnHoldTest {
    //    def 'should place on hold book which is marked as available in the system'() {
    @DisplayName("should place on hold book which is marked as available in the system")
    @Test
    void shouldPlaceOnHoldAvailableBook()
            throws Exception {
        // given
        var availableBook = BookFixture.circulatingAvailableBook();
        var patron = PatronFixture.anyPatronId();
        var branch = BookFixture.anyBranchId();
        var now = Instant.now();
        var oneHourLater = now.plusSeconds(36000);

        var bookPlacedOnHoldEvent =
                EventFixture.publishPlacedOnHoldEvent(patron, availableBook, branch, now, oneHourLater);
        // when 
        var result = availableBook.handle(bookPlacedOnHoldEvent);
        // then

        Assertions.assertThat(result.getBookInformation().getBookId()).isEqualTo(availableBook.getBookId());


    }

}
