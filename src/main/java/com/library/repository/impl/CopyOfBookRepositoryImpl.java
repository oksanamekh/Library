package com.library.repository.impl;

import com.library.entity.BookCopy;
import com.library.repository.CopyOfBookRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CopyOfBookRepositoryImpl extends CrudRepositoryImpl<BookCopy, Integer>
        implements CopyOfBookRepository {

}
