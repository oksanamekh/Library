package com.library.service;

import com.library.entity.Genre;

import java.util.List;

public interface GenreService extends CrudService<Genre, Integer> {

    List<String> findAllGenresNames();
}
