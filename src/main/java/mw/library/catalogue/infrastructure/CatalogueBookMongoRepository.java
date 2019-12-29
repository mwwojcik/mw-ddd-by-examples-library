package mw.library.catalogue.infrastructure;

import mw.library.catalogue.Book;
import mw.library.catalogue.ISBN;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

interface CatalogueBookMongoRepository extends MongoRepository<Book, ISBN> {
}
