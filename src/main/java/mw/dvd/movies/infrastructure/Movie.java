package mw.dvd.movies.infrastructure;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
class Movie {
    private UUID id;
    private String title;
    private String director;
}
