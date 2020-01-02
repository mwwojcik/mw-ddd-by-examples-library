package mw.library.catalogue;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

@NoArgsConstructor
@Getter
@EqualsAndHashCode(of="isbn")
public class ISBN {
    private String isbn;

    public ISBN(String isbn) {
        if (isbn == null || isbn.isEmpty()) {
            throw new IllegalArgumentException("ISBN cannot be empty!");
        }
        this.isbn = isbn;
    }


}
