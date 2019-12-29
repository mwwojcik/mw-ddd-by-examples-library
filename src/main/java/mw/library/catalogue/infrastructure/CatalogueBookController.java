package mw.library.catalogue.infrastructure;

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
class CatalogueBookController {

    private CatalogueFacade facade;

    public CatalogueBookController(CatalogueFacade facade) {
        this.facade = facade;
    }

    @GetMapping
    List<Book> findAllBooks() {
        return facade.findAllBooks();
    }

    @GetMapping("/{isbn}")
    ResponseEntity<Book> findBook(@PathVariable("isbn") String isbn) {
        var finded = facade.findBy(new ISBN(isbn));
        return finded.map(
                t->
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
/*
@RestController
@RequestMapping("/api/tweets")
public class TweetController {

	private TweetRepo repo;

	public TweetController(TweetRepo repo) {
		this.repo = repo;
		repo.saveAll(Stream.generate(() -> new Tweet("message" + UUID
			.randomUUID(), "author" + UUID.randomUUID())).limit(100)
			.collect(Collectors.toList()));
	}

	@GetMapping
	public Collection<Tweet> findAllTweets() {
		return repo.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Tweet> findTweet(@PathVariable("id") String uuid) {
		return repo.findById(UUID.fromString(uuid))
			.map(t -> ResponseEntity.status(HttpStatus.OK).body(t))
			.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping(params = "msg")
	public Collection<Tweet> findByMessage(@RequestParam("msg") String msg) {
		return repo.findByMessage(msg);
	}

	@GetMapping("/empty")
	public Optional<String> returnEmptyOptional() {
		return Optional.empty();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createTweet(@RequestBody Tweet tweet) {
	public ResponseEntity<?> createTweet(@RequestBody Tweet tweet) {
		Tweet savedTweet = repo.save(tweet);
		return ResponseEntity.created(URI.create(String
			.format("/api/tweets/%s", savedTweet.getId()
				.toString()))).build();
	}

	@PutMapping("/{id}")
	public void replace(@PathVariable("id") String uuid,
			    @RequestBody Tweet tweet) {
		tweet.setId(UUID.fromString(uuid));
		repo.save(tweet);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String uuid) {
		repo.deleteById(UUID.fromString(uuid));
	}

	@PatchMapping("/{id}")
	public void patch(@PathVariable("id") String uuid,
			  @RequestBody Tweet patch) {
		repo.findById(UUID.fromString(uuid)).ifPresent(t -> {
			String messageFromPatch = patch.getMessage();
			if (messageFromPatch != null) {
				t.setMessage(patch.getMessage());
			}
			String authorFromPatch = patch.getAuthor();
			if (authorFromPatch != null) {
				t.setAuthor(authorFromPatch);
			}
			repo.save(t);
		});
	}

	@GetMapping(params = {"page"})
	public Page<Tweet> findTweetPage(Pageable pageable) {
		return repo.findAll(pageable);
	}

	@PostMapping("/exception")
	public void throwEx() {
		throw new RuntimeException("This method throws " +
			"exception");
	}
}


* */