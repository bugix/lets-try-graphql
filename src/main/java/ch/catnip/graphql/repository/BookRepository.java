package ch.catnip.graphql.repository;

import ch.catnip.graphql.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> { }
