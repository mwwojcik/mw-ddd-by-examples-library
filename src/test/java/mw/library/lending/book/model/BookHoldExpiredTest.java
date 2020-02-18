package mw.library.lending.book.model;

import mw.library.lending.patron.model.PatronEvent;
import mw.library.lending.patron.model.PatronFixture;
import org.assertj.core.api.Fail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BookHoldExpiredTest {
    @DisplayName("should make book available when hold expired")
    @Test
    void shouldMakeBookAvailableAfterHoldExpiration()
            throws Exception {
        // given
        var bookOnHold = BookFixture.bookOnHold();
        var patron = PatronFixture.anyPatronId();
        // when 
        var bookHoldExpiredEvent = EventFixture.publishHoldExpiredEvent(patron, bookOnHold.getBookId(), bookOnHold.getLibraryBranchId());
        // then
        var result = bookOnHold.handle(bookHoldExpiredEvent);

        Assertions.assertEquals(result.getBookId(),bookOnHold.getBookId());
        Assertions.assertEquals(result.getLibraryBranchId(),bookOnHold.getLibraryBranchId());
    }
}
