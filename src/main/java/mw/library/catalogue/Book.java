package mw.library.catalogue;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@EqualsAndHashCode(of = "bookIsbn")
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Getter
public class Book {
    private ISBN bookISBN =null ;
    private Author author = null;
    private Title title =null ;
    Book(String isbn, String author, String title) {
        this(new ISBN(isbn), new Author(author), new Title(title));
    }
}

@NoArgsConstructor
@Getter
class Author {

    private String author = null;

    public Author(String author) {
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Book author cannot be empty!");
        }
        this.author = author;
    }
}

@NoArgsConstructor
@Getter
class Title {
    private String title;
    public Title(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Book title cannot be empty!");
        }
        this.title = title;
    }
}
