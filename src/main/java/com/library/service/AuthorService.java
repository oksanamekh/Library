package com.library.service;

import com.library.entity.Author;
import com.library.model.request.AuthorRequest;

public interface AuthorService extends CrudService<Author, Integer> {

    Author findAuthorByBookId(Integer bookId);

    void save(AuthorRequest authorRequest);
}
