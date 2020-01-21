package mw.library.lending.book.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;
import mw.library.lending.librarybranch.model.LibraryBranchId;
import mw.library.lending.patron.model.PatronId;

import java.time.Instant;


@Value
@AllArgsConstructor
@EqualsAndHashCode(of="bookInformation")
public class BookOnHold  implements Book {
    BookInformation bookInformation;
    LibraryBranchId libraryBranchId;
    PatronId byPatron;
    Instant holdTill;
}
