package mw.library.lending.book.model;

import mw.library.catalogue.BookId;
import mw.library.catalogue.BookType;

interface Book {
    BookInformation getBookInformation();
    default BookId bookId(){return getBookInformation().getBookId();}
    default BookType type(){return getBookInformation().getBookType();}
}
