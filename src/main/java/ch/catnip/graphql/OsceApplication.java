package ch.catnip.graphql;

import ch.catnip.graphql.domain.Author;
import ch.catnip.graphql.domain.Book;
import ch.catnip.graphql.repository.AuthorRepository;
import ch.catnip.graphql.repository.BookRepository;
import ch.catnip.graphql.resolver.BookResolver;
import ch.catnip.graphql.resolver.Mutation;
import ch.catnip.graphql.resolver.Query;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OsceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OsceApplication.class, args);
	}

    @Bean
    public BookResolver authorResolver(AuthorRepository authorRepository) {
        return new BookResolver(authorRepository);
    }

    @Bean
    public Query query(AuthorRepository authorRepository, BookRepository bookRepository) {
        return new Query(authorRepository, bookRepository);
    }

    @Bean
    public Mutation mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
        return new Mutation(authorRepository, bookRepository);
    }

    @Bean
    public CommandLineRunner demo(AuthorRepository authorRepository, BookRepository bookRepository) {
        return (args) -> {
            Author author = new Author(null, "Herbert", "Schildt");
            authorRepository.save(author);

            bookRepository.save(new Book(null, "Java: A Beginner's Guide, Sixth Edition", "0071809252", 728, author));
        };
    }

}
