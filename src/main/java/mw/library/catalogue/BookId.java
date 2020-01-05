package mw.library.catalogue;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BookId {
    @NonNull
    UUID bookId;
}
