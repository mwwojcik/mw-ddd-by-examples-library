package mw.library.lending.book.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BookCheckingOutTest {
    @DisplayName("should check out book which is marked as placed on hold in the system")
    @Test
    void shouldCheckOutHoldedBook()
            throws Exception {
        // given
        var bookOnHold = BookFixture.bookOnHold();
        var event = EventFixture.publishCheckOutEvent(bookOnHold.getBookId(),
                bookOnHold.getByPatron(),
                bookOnHold.getLibraryBranchId());
        // when 
        var result = bookOnHold.handle(event);
        // then

        Assertions.assertEquals(result.getBookInformation().getBookId(), bookOnHold.getBookId());
        Assertions.assertEquals(result.getCheckedOutAt(), bookOnHold.getLibraryBranchId());
        Assertions.assertEquals(result.getByPatron(), bookOnHold.getByPatron());
    }

}
