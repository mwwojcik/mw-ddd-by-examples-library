package mw.library.catalogue.remote;

import mw.library.catalogue.infrastructure.CatalogueConfiguration;
import mw.library.catalogue.standalone.LibraryManagementStandaloneApp;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({CatalogueConfiguration.class,CatalogueDBTestConfiguration.class})
public class LibraryManagementRemoteTestApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .parent(LibraryManagementRemoteTestApp.class)
                .web(WebApplicationType.SERVLET).run(args);
    }
}