package com.library.repository.impl;

import com.library.entity.Genre;
import com.library.repository.GenreRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class GenreRepositoryImpl extends CrudRepositoryImpl<Genre, Integer>
        implements GenreRepository {

    @Override
    public List<String> findAllGenresNames() {
        String sql = "SELECT genre.genreName FROM Genre genre";
        TypedQuery<String> query = getEntityManager().createQuery(sql, String.class);
        return query.getResultList();
    }

}
