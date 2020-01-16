package mw.library.lending.book.model;

import lombok.Value;
import mw.library.catalogue.BookId;
import mw.library.catalogue.BookType;

@Value
public class BookInformation {
    BookId bookId;
    BookType bookType;
}
