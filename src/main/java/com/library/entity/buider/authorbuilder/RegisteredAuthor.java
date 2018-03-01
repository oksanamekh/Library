package com.library.entity.buider.authorbuilder;

import com.library.entity.Author;
import com.library.model.request.AuthorRequest;

import java.time.LocalDate;

public class RegisteredAuthor extends AuthorBuilder {

    private AuthorRequest authorRequest;

    public RegisteredAuthor(AuthorRequest authorRequest) {
        this.authorRequest = authorRequest;
    }

    @Override
    public void buid() {
        createNewAuthor();
        author.setFirstName(authorRequest.getFirstName());
        author.setLastName(authorRequest.getLastName());
        author.setBirthDate(LocalDate.parse(authorRequest.getBirthDate()));
        author.setCountry(authorRequest.getCountry());
        author.setPhotoUrl(authorRequest.getPhotoUrl());
    }

    @Override
    public Author getInstance() {
        return author;
    }
}
