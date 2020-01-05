package mw.library.catalogue.infrastructure;

import mw.library.catalogue.BookId;
import mw.library.catalogue.BookInstance;
import mw.library.catalogue.ISBN;
import org.springframework.data.mongodb.repository.MongoRepository;

interface CatalogueBookInstMongoRepository extends MongoRepository<BookInstance, BookId> {
}
