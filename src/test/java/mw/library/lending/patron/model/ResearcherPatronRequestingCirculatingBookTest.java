package mw.library.lending.patron.model;

import mw.library.lending.patron.model.BookFixture;
import mw.library.lending.patron.model.PatronFixture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResearcherPatronRequestingCirculatingBookTest {
    @DisplayName("a researcher patron can hold any number of circulating books")
    @Test
    void researcherPatronCanHoldAnyNumberOfCirculatingBooks()
            throws Exception {
        // given
        var patron = PatronFixture.researcherPatronWithHolds(10);
        var book = BookFixture.circulatingAvailableBook();
        // when 
        var result = patron.placeOnHold(book);
        // then
        Assertions.assertThat(result.isRight()).isEqualTo(true);
    }
}
