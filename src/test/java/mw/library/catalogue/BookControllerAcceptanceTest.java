package mw.library.catalogue;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


abstract class BookControllerAcceptanceTest {
    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper=new ObjectMapper();

    protected abstract CatalogueFacade getFacade();

    void acceptance()
            throws Exception {

        // given inventory with two books added
        // "Domain-Driven Design" - Eric Evans, "Implementing Domain Driven Desing" - Vaughn Vernon
        getFacade().saveNew(new Book(BooksFixture.DDD_ISBN_STR, "Eric Evans", "Domain-Driven Design"));
        getFacade().saveNew(new Book(BooksFixture.DDD_ISBN_STR_01, "Vaughn Vernon", "Implementing Domain Driven Desing"));

        // when -> I go api/books
        // then -> I can see two books'
        mockMvc.perform(MockMvcRequestBuilders.get("/api/books"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath(
                        "$", Matchers.is(Matchers.hasSize(2))
                        )
                )
                .andExpect(MockMvcResultMatchers.jsonPath(
                        "$[0].bookISBN.isbn", Matchers.is(Matchers.equalTo(BooksFixture.DDD_ISBN_STR))
                        )
                ) ;



        //when -> I post api/books wit data:"Analysis Patterns"-Martin Fowler'
        //then -> Book should be added

        // when -> I go api/books
        // then -> I can see 3 books

        //when -> I get /api/books/ISBN
        //then -> I can see requested book details

        //when -> I delete /api/books with Fowler's book ISBN
        //then -> Last added book should be deleted

        //when -> I go api/books
        //then -> I can see two books

        //when -> I get /api/books/instance/ISBN
        //then -> I get requested book instance data

        //when -> I post /api/books/instance/ID
        //then -> I can see requested book instance details

        //when -> I delete  /api/books/instance/ID
        //then -> Instance should be succesfully deleted

        //when -> I post on /api/books/instance/ISBN
        //then -> new book instance should be added
    }
}
