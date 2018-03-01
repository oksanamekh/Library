package com.library.repository;

import com.library.entity.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer> {

    Author findAuthorByBookId(Integer bookId);

}
