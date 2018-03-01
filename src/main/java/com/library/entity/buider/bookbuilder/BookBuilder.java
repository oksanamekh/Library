package com.library.entity.buider.bookbuilder;

import com.library.entity.Book;
import com.library.entity.buider.ClassBuilder;

public abstract class BookBuilder implements ClassBuilder<Book> {

    protected Book book;

    protected void createNewBook() {
        book = new Book();
    }
}
