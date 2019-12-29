package mw.library.catalogue;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Value
@EqualsAndHashCode(of = "bookIsbn")
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Book {
    private ISBN bookISBN;
    private Author author;
    private Title title;

    Book(String isbn, String author, String title) {
        this(new ISBN(isbn), new Author(author), new Title(title));
    }

}

@Value
class Author {

    private String author;

    public Author(String author) {

        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Book author cannot be empty!");
        }
        this.author = author;
    }
}

@Value
class Title {

    private String title;

    public Title(String title) {

        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Book title cannot be empty!");
        }

        this.title = title;
    }
}
