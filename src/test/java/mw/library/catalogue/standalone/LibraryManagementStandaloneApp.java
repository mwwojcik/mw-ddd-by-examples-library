package mw.library.catalogue.standalone;

import mw.library.catalogue.infrastructure.CatalogueConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({CatalogueConfiguration.class})
public class LibraryManagementStandaloneApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .parent(LibraryManagementStandaloneApp.class)
                .web(WebApplicationType.SERVLET).run(args);
    }
}
