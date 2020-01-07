package mw.library.lending.patronprofile.model;

import lombok.Value;
import mw.library.catalogue.BookId;

import java.time.Instant;

@Value
public class Hold {
    private final BookId book;
    private final Instant till;
}
