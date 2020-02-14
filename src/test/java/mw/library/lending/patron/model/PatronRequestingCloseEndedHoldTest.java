package mw.library.lending.patron.model;

import mw.library.lending.patron.model.BookFixture;
import mw.library.lending.patron.model.HoldDuration;
import mw.library.lending.patron.model.PatronFixture;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Fail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static mw.library.lending.patron.model.PlacingOnHoldPolicy.onlyResearcherPatronsCanPlaceOpenEndedHolds;
import static org.assertj.core.api.Assertions.catchThrowable;

// def 'any patron can request close ended hold'() {
//def 'patron cannot hold a book for 0 or negative amount of days'() {
class PatronRequestingCloseEndedHoldTest {

    @DisplayName("any patron can request close ended hold")
    @Test
    void anyPatronCanRequestCloseEndedHold()
            throws Exception {
        // given
        var patronId = PatronFixture.anyPatronId();
        var aBook = BookFixture.circulatingAvailableBook();
        var patrons = List.of(PatronFixture.regularPatronWithPolicy(patronId, onlyResearcherPatronsCanPlaceOpenEndedHolds)
                , PatronFixture.researcherPatronWithPolicy(patronId, onlyResearcherPatronsCanPlaceOpenEndedHolds)
        );
        // when 
        for (var patron :
                patrons) {
            var res = patron.placeOnHold(aBook, HoldDuration.closeEnded(3));
            // then
            Assertions.assertThat(res.isRight());
        }
    }

    @DisplayName("amount of holding days shouldn't be 0 or negative")
    @Test
    void amountOfDaysSholdntBeNegative()
            throws Exception {
        // given
        // given
        var patronId = PatronFixture.anyPatronId();
        var aBook = BookFixture.circulatingAvailableBook();
        var patron = PatronFixture.regularPatronWithPolicy(patronId, onlyResearcherPatronsCanPlaceOpenEndedHolds);
        // when 
        Throwable thrown = catchThrowable(() -> {
            patron.placeOnHold(aBook, HoldDuration.closeEnded(-2));
        });

        Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class);



    }
}
