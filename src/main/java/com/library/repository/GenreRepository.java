package com.library.repository;

import com.library.entity.Genre;

import java.util.List;

public interface GenreRepository extends CrudRepository<Genre, Integer> {

    List<String> findAllGenresNames();

}
