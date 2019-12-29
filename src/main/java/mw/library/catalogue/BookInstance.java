package mw.library.catalogue;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public
class BookInstance {
    @NonNull
    ISBN bookISBN;
    @NonNull
    BookId bookId;
    @NonNull
    BookType bookType;

    static BookInstance of(Book book,BookType type) {
        return new BookInstance(book.getBookISBN(),new BookId(UUID.randomUUID()),type);
    }
}

@Value
class BookId {
    @NonNull
    UUID bookId;
}
