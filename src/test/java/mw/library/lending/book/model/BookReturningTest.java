package mw.library.lending.book.model;

import mw.library.lending.patron.model.PatronEvent;
import mw.library.lending.patron.model.PatronFixture;
import org.assertj.core.api.Fail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BookReturningTest {
    @DisplayName("should return book which is marked as placed on hold in the system")
    @Test void shouldReturnHold()
     throws Exception {
      // given
        var bookOnHold = BookFixture.bookOnHold();
        var patron = PatronFixture.anyPatronId();
        var event = EventFixture.publishBookIsReturned(
                bookOnHold.getBookId(),
                bookOnHold.getBookInformation().getBookType(),
                patron,
                bookOnHold.getLibraryBranchId());
        // when 
        var result = bookOnHold.handle(event);
        // then
        Assertions.assertEquals(bookOnHold.getBookId(),result.getBookId());
        Assertions.assertEquals(bookOnHold.getLibraryBranchId(),result.getLibraryBranchId());
      }

@DisplayName("should return book which is marked as checkedOut in the system")
@Test void shoulReturnCheckedOutBook()
 throws Exception {
  // given
    var checkedOutBook = BookFixture.bookCheckedOut();
    var event = EventFixture.publishBookIsReturned(
            checkedOutBook.getBookInformation().getBookId(),
            checkedOutBook.getBookInformation().getBookType(),
            checkedOutBook.getByPatron(),
            checkedOutBook.getCheckedOutAt());
    // when 
    var result = checkedOutBook.handle(event);
    // then
    Assertions.assertEquals(result.getBookInformation().getBookId(),checkedOutBook.getBookInformation().getBookId());
    Assertions.assertEquals(result.getLibraryBranchId(),checkedOutBook.getCheckedOutAt());
  }
}
