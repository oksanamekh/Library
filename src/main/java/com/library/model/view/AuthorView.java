package com.library.model.view;

import com.library.entity.Author;
import com.library.entity.Book;

import java.time.LocalDate;
import java.util.List;

public class AuthorView {

    private Integer id;
    private String photoUrl;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String country;
    private Double averageClientsAge;
    private List<Book> books;
    private String shortBiography;

    public AuthorView() {
    }

    private AuthorView(Integer id, String photoUrl, String firstName, String lastName,
                       LocalDate birthDate, String country, Double averageClientsAge,
                       List<Book> books, String shortBiography) {
        this.id = id;
        this.photoUrl = photoUrl;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.country = country;
        this.averageClientsAge = averageClientsAge;
        this.books = books;
        this.shortBiography = shortBiography;
    }

    public AuthorView(Author author, Double averageClientsAge) {
        this.id = author.getId();
        this.photoUrl = author.getPhotoUrl();
        this.firstName = author.getFirstName();
        this.lastName = author.getLastName();
        this.birthDate = author.getBirthDate();
        this.country = author.getCountry();
        this.averageClientsAge = averageClientsAge;
        this.books = author.getOwnBooks();
        this.shortBiography = author.getShortBiography();
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getCountry() {
        return country;
    }

    public Double getAverageClientsAge() {
        return averageClientsAge;
    }

    public Integer getId() {
        return id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getShortBiography() {
        return shortBiography;
    }

    public void setShortBiography(String shortBiography) {
        this.shortBiography = shortBiography;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Integer id;
        private String photoUrl;
        private String firstName;
        private String lastName;
        private LocalDate birthDate;
        private String country;
        private Double averageClientsAge;
        private List<Book> books;
        private String shortBiography;

        public Builder setId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder setPhotoUrl(String photoUrl) {
            this.photoUrl = photoUrl;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setBirthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder setAverageClientsAge(Double averageClientsAge) {
            this.averageClientsAge = averageClientsAge;
            return this;
        }

        public Builder setBooks(List<Book> books) {
            this.books = books;
            return this;
        }

        public Builder setShortBiography(String shortBiography) {
            this.shortBiography = shortBiography;
            return this;
        }

        public AuthorView build() {
            return new AuthorView(id, photoUrl, firstName, lastName,
                    birthDate, country, averageClientsAge, books, shortBiography);
        }
    }
}
