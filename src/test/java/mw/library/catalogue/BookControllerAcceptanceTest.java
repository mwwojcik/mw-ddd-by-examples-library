package mw.library.catalogue;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


abstract class BookControllerAcceptanceTest {
    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    protected abstract CatalogueFacade getFacade();

    void acceptance()
            throws Exception {

        // given inventory with two books added
        // "Domain-Driven Design" - Eric Evans, "Implementing Domain Driven Desing" - Vaughn Vernon
        var evans=getFacade().saveNew(new Book(BooksFixture.DDD_ISBN_STR, "Eric Evans", "Domain-Driven Design"));
        var vernon=getFacade().saveNew(new Book(BooksFixture.DDD_ISBN_STR_01, "Vaughn Vernon", "Implementing Domain Driven Desing"));

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
                );


        var fowler = new Book(BooksFixture.DDD_ISBN_STR_03, "Martin Fowler", "Analysis Patterns");
        var fowler_json = objectMapper.writeValueAsString(fowler);

        System.out.println(fowler_json);
        //when -> I post api/books wit data:"Analysis Patterns"-Martin Fowler'
        mockMvc.perform(MockMvcRequestBuilders.post("/api/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(fowler_json))
                //then -> Book should be added
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());


        // when -> I go api/books
        mockMvc.perform(MockMvcRequestBuilders.get("/api/books/"))
        // then -> I can see 3 books
        .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$",Matchers.hasSize(3)));

        //when -> I get /api/books/ISBN
        mockMvc.perform(MockMvcRequestBuilders.get("/api/books/{isbn}",BooksFixture.DDD_ISBN_STR_03))
        //then -> I can see requested book details
        .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.bookISBN.isbn",Matchers.equalTo(BooksFixture.DDD_ISBN_STR_03)));

        //when -> I delete /api/books with Fowler's book ISBN
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/books/{isbn}",BooksFixture.DDD_ISBN_STR_03))
        //then -> Last added book should be deleted
        .andExpect(MockMvcResultMatchers.status().isNoContent());

        //when -> I go api/books
        mockMvc.perform(MockMvcRequestBuilders.get("/api/books"))
        //then -> I can see two books
        .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$",Matchers.hasSize(2)));

        //when -> I add instance detail
        var evansInst = BookInstance.of(evans,BookType.Typical);
        var evansInstJSON=objectMapper.writeValueAsString(evansInst);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/books/instances")
                .contentType(MediaType.APPLICATION_JSON)
                .content(evansInstJSON)
                )
                //then -> One instance should be added
                .andExpect(MockMvcResultMatchers.status().isCreated());

        //when -> I get /api/books/instance/ISBN
        mockMvc.perform(MockMvcRequestBuilders.get("/api/books/instances/{isbn}",BooksFixture.DDD_ISBN_STR))
        //then -> I get requested book instance data
        .andExpect(MockMvcResultMatchers.jsonPath("$",Matchers.is(Matchers.hasSize(1))));

        //when -> I post /api/books/instance/ID
        //then -> I can see requested book instance details

        //when -> I delete  /api/books/instance/ID
        //then -> Instance should be succesfully deleted

        //when -> I post on /api/books/instance/ISBN
        //then -> new book instance should be added
    }
}
