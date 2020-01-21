package mw.library.lending.patron.model.hold;

import mw.library.lending.patron.model.BookFixture;
import mw.library.lending.patron.model.PatronFixture;
import org.assertj.core.api.Fail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PatronCancelingHoldTest {
    @DisplayName("patron should be able to cancel his holds")
    @Test void shouldBeAbleToCancelHold()
     throws Exception {
      // given
      var bookOnHold= BookFixture.bookOnHold();
      var regularPatronWithHold= PatronFixture.regularPatronWithHold(bookOnHold);
      // when 
      //regularPatronWithHold
      // then

      Fail.fail("Write your test");

      }

      @DisplayName("patron cannot cancel a hold which does not exist")
      @Test void shouldntBeAbleToCancelNotExistsHold()
       throws Exception {
        // given
        // when 
        // then

        Fail.fail("Write your test");

        }

        @DisplayName("atron cannot cancel a hold which was done by someone else")
        @Test void shouldntCancelSomeonesHold()
         throws Exception {
          // given
          // when 
          // then

          Fail.fail("Write your test");

          }
}
