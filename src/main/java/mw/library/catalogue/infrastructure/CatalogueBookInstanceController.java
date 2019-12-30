package mw.library.catalogue.infrastructure;

import lombok.AllArgsConstructor;
import mw.library.catalogue.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/books/instances")
@AllArgsConstructor
class CatalogueBookInstanceController {

    private CatalogueFacade facade;

    @GetMapping("/{isbn}")
    List<Book> findAllBookInstances(@PathVariable("isbn") String isbn) {
        return null;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<?> createBookInstance(@RequestBody BookInstance bookInstance) {
        var saved = facade.saveNew(bookInstance);
        return ResponseEntity.created(
                URI.create(String.format("/api/books/instances/%s", saved.getBookISBN().getIsbn()))
        ).build();
    }

    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable("bookId") BookId isbn) {
        facade.deleteInstanceBy(isbn);
    }
}
