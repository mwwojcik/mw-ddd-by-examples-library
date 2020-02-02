package mw.library.lending.patron.model.hold;

import mw.library.lending.patron.model.BookFixture;
import mw.library.lending.patron.model.PatronEvent;
import mw.library.lending.patron.model.PatronFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RegularPatronRequestingRestrictedBooksTest {
    //    'a regular patron cannot place on hold restricted book'
    @DisplayName("a regular patron cannot place on hold restricted book")
    @Test
    void regularPatronCannotPlaceOnHoldRestrictedBook()
            throws Exception {
        // given
        var patron = PatronFixture.regularPatron();
        var availableBook = BookFixture.restrictedAvailableBook();
        // when 
        var result = patron.placeOnHold(availableBook);
        // then
        assertThat(result.isLeft()).isEqualTo(true);
        var left = result.getLeft();
        assertThat(left.getReason()).isEqualTo("Regular patrons cannot hold restricted books");

    }

}
