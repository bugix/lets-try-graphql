package ch.catnip.graphql.repository;

import ch.catnip.graphql.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> { }
