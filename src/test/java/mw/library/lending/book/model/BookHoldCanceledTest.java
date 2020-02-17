package mw.library.lending.book.model;

import mw.library.lending.librarybranch.model.LibraryBranchId;
import mw.library.lending.patron.model.PatronEvent;
import mw.library.lending.patron.model.PatronFixture;
import mw.library.lending.patron.model.PatronId;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Fail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BookHoldCanceledTest {
    //    def 'should make book available when hold canceled'
    @DisplayName("should make book available when hold canceled")
    @Test void shouldMakeBookAvailableWhenHoldCanceled()
     throws Exception {
      // given
        var bookOnHold = BookFixture.bookOnHold();
        var patron = PatronFixture.anyPatronId();
        var branchId = BookFixture.anyBranchId();
        // when 
        var bookHoldCanceledEvent = EventFixture.publishCancellingHoldEvent(patron, bookOnHold.getBookId(), branchId);
        var result = bookOnHold.handle(bookHoldCanceledEvent);
        // then
        Assertions.assertThat(result.getBookId()).isEqualTo(bookOnHold.getBookId());
        Assertions.assertThat(result.getLibraryBranchId()).isEqualTo(branchId);

      }
}
