package mw.library.lending.patron.model.hold;

import mw.library.lending.patron.model.BookFixture;
import mw.library.lending.patron.model.CheckOutDuration;
import mw.library.lending.patron.model.PatronFixture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PatronCheckingOutBookTest {
    @DisplayName("patron cannot check out book which is not placed on hold")
    @Test
    void patronCantCheckNotHoldedBook()
            throws Exception {
        // given
        var book = BookFixture.bookOnHold();
        var patron = PatronFixture.regularPatron();
        // when 
        var result = patron.checkOut(book, CheckOutDuration.forNoOfDays(10));
        // then
        Assertions.assertThat(result.isLeft()).isEqualTo(true);
        var left = result.getLeft();
        Assertions.assertThat(left.getReason()).contains("book is not on hold");

    }

    //
    @DisplayName("patron can check out book which was placed on hold by him")
    @Test
    void patronCanCheckOutBookHoldedByHim()
            throws Exception {
        // given
        var hold = BookFixture.bookOnHold();
        var patron = PatronFixture.regularPatronWithHold(hold);
        // when 
        var result = patron.checkOut(hold, CheckOutDuration.forNoOfDays(1));
        // then
        Assertions.assertThat(result.isRight()).isEqualTo(true);
    }

    //
    @DisplayName("patron can checkout up to 60 days")
    @Test
    void patronCanCheckOutTo60Days()
            throws Exception {
        // given
        var hold = BookFixture.bookOnHold();
        var patron = PatronFixture.regularPatronWithHold(hold);
        // when 
        for (int i = 1; i < CheckOutDuration.maxDuration().getNoOfDays().getDays(); i++) {
            // then
            var result = patron.checkOut(hold, CheckOutDuration.forNoOfDays(i));
            Assertions.assertThat(result.isRight()).isEqualTo(true);
        }
    }

    @DisplayName("patron cannot checkout up to more than 60 days")
    @Test
    void patronCantCheckOutToMoreThan60Days()
            throws Exception {
        // given
        var hold = BookFixture.bookOnHold();
        var patron = PatronFixture.regularPatronWithHold(hold);
        // when 
        // then
        Assertions
                .assertThatIllegalArgumentException()
                .isThrownBy(
                        () -> patron.checkOut(hold, CheckOutDuration.forNoOfDays(61)))
                .withMessageContaining("Cannot checkout for more than");
    }

    @DisplayName("patron cannot checkout for 0 or less")
    @Test
    void patronCannotCheckOutFor0orLess()
            throws Exception {
        // given
        // given
        var hold = BookFixture.bookOnHold();
        var patron = PatronFixture.regularPatronWithHold(hold);
        // when 
        Assertions
                .assertThatIllegalArgumentException()
                .isThrownBy(() -> patron.checkOut(hold, CheckOutDuration.forNoOfDays(-5)))
                .withMessageContaining("Cannot use negative integers");
    }
}
