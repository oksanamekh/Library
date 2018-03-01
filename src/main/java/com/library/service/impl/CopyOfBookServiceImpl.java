package com.library.service.impl;

import com.library.entity.BookCopy;
import com.library.repository.CopyOfBookRepository;
import com.library.service.CopyOfBookServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CopyOfBookServiceImpl extends CrudServiceImpl<BookCopy, Integer, CopyOfBookRepository> implements CopyOfBookServise {

    @Autowired
    private CopyOfBookRepository copyRepository;

    @Override
    public CopyOfBookRepository getRepository() {
        return copyRepository;
    }
}
