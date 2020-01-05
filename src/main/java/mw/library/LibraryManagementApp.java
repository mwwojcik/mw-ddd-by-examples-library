package mw.library;

import mw.library.catalogue.infrastructure.CatalogueConfiguration;
import mw.library.catalogue.infrastructure.CatalogueDBConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({CatalogueConfiguration.class,CatalogueDBConfiguration.class})
public class LibraryManagementApp {
	public static void main(String[] args) {
		new SpringApplicationBuilder()
				.parent(LibraryManagementApp.class)
				.web(WebApplicationType.SERVLET).run(args);
	}

}
