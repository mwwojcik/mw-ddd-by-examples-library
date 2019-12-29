package mw.library.catalogue;

import lombok.Value;

@Value
public class ISBN {
    private String isbn;

    public ISBN(String isbn) {
        if (isbn == null || isbn.isEmpty()) {
            throw new IllegalArgumentException("ISBN cannot be empty!");
        }
        this.isbn = isbn;
    }


}
