package mw.dvd;

import mw.dvd.movies.MoviesConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@EnableAutoConfiguration(exclude = MongoAutoConfiguration.class)
public class DvdApplication {

	public static void main(String[] args) {

		new SpringApplicationBuilder().parent(DvdApplication.class)
				.child(MoviesConfiguration.class)
				.web(WebApplicationType.SERVLET).run(args);
	}

}
