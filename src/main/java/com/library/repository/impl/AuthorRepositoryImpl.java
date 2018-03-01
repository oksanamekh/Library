package com.library.repository.impl;

import com.library.entity.Author;
import com.library.repository.AuthorRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

@Repository
public class AuthorRepositoryImpl extends CrudRepositoryImpl<Author, Integer>
        implements AuthorRepository {

    @Override
    public Author findAuthorByBookId(Integer bookId) {
        String sqlQuery = "SELECT a FROM Author a JOIN a.ownBooks b WHERE b.id = ?1";
        TypedQuery<Author> query = getEntityManager().createQuery(sqlQuery, Author.class);
        query.setParameter(1, bookId);
        return query.getSingleResult();
    }
}
