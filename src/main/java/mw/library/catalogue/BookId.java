package mw.library.catalogue;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of="bookId")
public class BookId {
    @NonNull
    UUID bookId;
}
