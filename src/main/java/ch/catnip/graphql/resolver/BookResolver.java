package ch.catnip.graphql.resolver;

import ch.catnip.graphql.domain.Author;
import ch.catnip.graphql.domain.Book;
import ch.catnip.graphql.repository.AuthorRepository;

import java.util.Optional;

public class BookResolver {

    private AuthorRepository authorRepository;

    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Optional<Author> getAuthor(Book book) {
        return authorRepository.findById(book.getAuthor().getId());
    }
}
