package mw.dvd.movies.infrastructure;

import mw.dvd.movies.MoviesRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

class MoviesRepositoryMongo implements MoviesRepository, Repository<Movie, UUID> {

}
