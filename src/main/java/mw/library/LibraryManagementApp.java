package mw.library;

import mw.library.catalogue.infrastructure.CatalogueConfiguration;
import mw.library.lending.infrastructure.LendingConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({CatalogueConfiguration.class, LibraryDBConfiguration.class, LendingConfiguration.class})
public class LibraryManagementApp {
	public static void main(String[] args) {
		new SpringApplicationBuilder()
				.parent(LibraryManagementApp.class)
				.web(WebApplicationType.SERVLET).run(args);
	}

}
