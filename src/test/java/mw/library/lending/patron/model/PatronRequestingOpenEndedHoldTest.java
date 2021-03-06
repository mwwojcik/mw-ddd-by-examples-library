package mw.library.lending.patron.model;

import org.assertj.core.api.Assertions;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static mw.library.lending.book.model.BookFixture.*;

class PatronRequestingOpenEndedHoldTest {

    @DisplayName("researcher patron can request open ended hold")
    @Test void researcherPatronRequestOpenEndedHold()
     throws Exception {
      // given
        Instant from=Instant.MIN;
        var aBook= circulatingAvailableBook();
        var patronId= PatronFixture.anyPatronId();
        var researcherPatron= PatronFixture.researcherPatronWithPolicy(patronId, PlacingOnHoldPolicy.onlyResearcherPatronsCanPlaceOpenEndedHolds);
      // when 
        var result=researcherPatron.placeOnHold(aBook, HoldDuration.openEnded(from));
      // then
        Assertions.assertThat(result.isRight());
    }

    @DisplayName("regular patron cannot request a open ended hold")
      @Test void regularPatronRequestOpenEndedHold()
       throws Exception {
        // given
        Instant from =Instant.MIN;
        var aBook=circulatingAvailableBook();
        var patronId=PatronFixture.anyPatronId();
        var regularPatron=PatronFixture.regularPatronWithPolicy(patronId,PlacingOnHoldPolicy.onlyResearcherPatronsCanPlaceOpenEndedHolds);
        // when 
        var result=regularPatron.placeOnHold(aBook,HoldDuration.openEnded(from));
        // then
        Assertions.assertThat(result.isLeft());

        }
}