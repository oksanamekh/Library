package com.library.model.view;

import com.library.entity.Book;
import com.library.entity.Client;

import java.util.List;

public class ClientView {

    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String homeAddress;
    private Integer usingLibraryDaysCount;
    private List<Book> readBooks;
    private List<Book> notReturnedBooks;

    public ClientView() {
    }

    private ClientView(Integer id, String firstName, String lastName, String phoneNumber,
                       String homeAddress, Integer usingLibraryDaysCount,
                       List<Book> readBooks, List<Book> notReturnedBooks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.homeAddress = homeAddress;
        this.usingLibraryDaysCount = usingLibraryDaysCount;
        this.readBooks = readBooks;
        this.notReturnedBooks = notReturnedBooks;
    }

    public ClientView(Client client, Integer usingLibraryDaysCount, List<Book> notReturnedBooks) {
        this.id = client.getId();
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
        this.phoneNumber = client.getPhoneNumber();
        this.homeAddress = client.getHomeAddress();
        this.usingLibraryDaysCount = usingLibraryDaysCount;
        this.readBooks = client.getReadBooks();
        this.notReturnedBooks = notReturnedBooks;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Integer getUsingLibraryDaysCount() {
        return usingLibraryDaysCount;
    }

    public void setUsingLibraryDaysCount(Integer usingLibraryDaysCount) {
        this.usingLibraryDaysCount = usingLibraryDaysCount;
    }

    public List<Book> getReadBooks() {
        return readBooks;
    }

    public void setReadBooks(List<Book> readBooks) {
        this.readBooks = readBooks;
    }

    public List<Book> getNotReturnedBooks() {
        return notReturnedBooks;
    }

    public void setNotReturnedBooks(List<Book> notReturnedBooks) {
        this.notReturnedBooks = notReturnedBooks;
    }

    public static class Builder {

        private Integer id;
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private String homeAddress;
        private Integer usingLibraryDaysCount;
        private List<Book> readBooks;
        private List<Book> notReturnedBooks;

        public Builder setId(Integer id) {
            this.id = id;
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

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setHomeAddress(String homeAddress) {
            this.homeAddress = homeAddress;
            return this;
        }

        public Builder setUsingLibraryDaysCount(Integer usingLibraryDaysCount) {
            this.usingLibraryDaysCount = usingLibraryDaysCount;
            return this;
        }

        public Builder setReadBooks(List<Book> readBooks) {
            this.readBooks = readBooks;
            return this;
        }

        public Builder setNotReturnedBooks(List<Book> notReturnedBooks) {
            this.notReturnedBooks = notReturnedBooks;
            return this;
        }

        public ClientView build() {
            return new ClientView(id, firstName, lastName, phoneNumber, homeAddress,
                    usingLibraryDaysCount, readBooks, notReturnedBooks);
        }
    }

}
