package mw.library.catalogue.infrastructure;

import lombok.AllArgsConstructor;
import mw.library.catalogue.Book;
import mw.library.catalogue.CatalogueFacade;
import mw.library.catalogue.ISBN;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
class CatalogueBookController {

    private CatalogueFacade facade;

    @GetMapping
    List<Book> findAllBooks() {
        return facade.findAllBooks();
    }

    @GetMapping("/{isbn}")
    ResponseEntity<Book> findBook(@PathVariable("isbn") String isbn) {
        var finded = facade.findBy(new ISBN(isbn));
        return finded.map(
                t ->
                        ResponseEntity.status(HttpStatus.FOUND).body(t)

        ).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<?> createBook(@RequestBody Book book) {
        var saved = facade.saveNew(book);
        return ResponseEntity.created(
                URI.create(String.format("/api/books/%s", saved.getBookISBN().getIsbn()))
        ).build();
    }

    @DeleteMapping("/{isbn}")
    public void deleteBook(@PathVariable("isbn") String isbn) {
        facade.deleteBy(isbn);
    }
}
