package mw.library.lending.patron.model;

import mw.library.lending.book.model.BookFixture;
import org.assertj.core.api.Assertions;
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
      var bookHoldCanceleds = regularPatronWithHold.cancelHold(bookOnHold);

      // then
      Assertions.assertThat(bookHoldCanceleds.isRight());


      }

      @DisplayName("patron cannot cancel a hold which does not exist")
      @Test void shouldntBeAbleToCancelNotExistsHold()
       throws Exception {
        // given
        var bookOnHold = BookFixture.bookOnHold();

        var patron=PatronFixture.regularPatron();
        // when 
        var bookHoldCanceleds = patron.cancelHold(bookOnHold);
        // then

        Assertions.assertThat(bookHoldCanceleds.isLeft());

        }

        @DisplayName("patron cannot cancel a hold which was done by someone else")
        @Test void shouldntCancelSomeonesHold()
         throws Exception {
          // given
          var bookOnHold = BookFixture.bookOnHold();
          var patron=PatronFixture.regularPatron();
          var differentPatron= PatronFixture.regularPatronWithHold(bookOnHold);
          // when 
          var result = patron.cancelHold(bookOnHold);
          // then
          Assertions.assertThat(result.isLeft());

          }
}
