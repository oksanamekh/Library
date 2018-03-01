package com.library.model.view;

import com.library.entity.Author;
import com.library.entity.Book;

import java.time.LocalDate;
import java.util.List;

public class BookView {

    private Integer id;
    private String photoUrl;
    private String name;
    private Integer authorId;
    private String authorFirstName;
    private String authorLastName;
    private List<Author> collaborationAuthors;
    private String genre;
    private LocalDate releaseDate;
    private String fullDescription;
    private Integer pagesAmount;
    private Integer availableCount;
    private Integer generalCount;
    private Double averageClientsAge;
    private Long rentCount;
    private List<String> notReturnedBooks;
    private String usingLibraryTime;

    public BookView() {
    }

    public BookView(Book book, Double averageAgeByBook, Long rentCount) {
        this.id = book.getId();
        this.photoUrl = book.getPhotoUrl();
        this.name = book.getName();
        this.authorId = book.getMainAuthor().getId();
        this.authorFirstName = book.getMainAuthor().getFirstName();
        this.authorLastName = book.getMainAuthor().getLastName();
        this.collaborationAuthors = book.getCollaborationAuthors();
        this.genre = book.getGenre().getGenreName();
        this.releaseDate = book.getReleaseDate();
        this.fullDescription = book.getFullDescription();
        this.pagesAmount = book.getPagesAmount();
        this.availableCount = book.getAvailableCount();
        this.generalCount = book.getGeneralCount();
        this.averageClientsAge = averageAgeByBook;
        this.rentCount = rentCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public List<Author> getCollaborationAuthors() {
        return collaborationAuthors;
    }

    public void setCollaborationAuthors(List<Author> collaborationAuthors) {
        this.collaborationAuthors = collaborationAuthors;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public Integer getPagesAmount() {
        return pagesAmount;
    }

    public void setPagesAmount(Integer pagesAmount) {
        this.pagesAmount = pagesAmount;
    }

    public Integer getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(Integer availableCount) {
        this.availableCount = availableCount;
    }

    public Integer getGeneralCount() {
        return generalCount;
    }

    public void setGeneralCount(Integer generalCount) {
        this.generalCount = generalCount;
    }

    public Double getAverageClientsAge() {
        return averageClientsAge;
    }

    public void setAverageClientsAge(Double averageClientsAge) {
        this.averageClientsAge = averageClientsAge;
    }

    public Long getRentCount() {
        return rentCount;
    }

    public void setRentCount(Long rentCount) {
        this.rentCount = rentCount;
    }

    public List<String> getNotReturnedBooks() {
        return notReturnedBooks;
    }

    public void setNotReturnedBooks(List<String> notReturnedBooks) {
        this.notReturnedBooks = notReturnedBooks;
    }

    public String getUsingLibraryTime() {
        return usingLibraryTime;
    }

    public void setUsingLibraryTime(String usingLibraryTime) {
        this.usingLibraryTime = usingLibraryTime;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public static class Builder {

        private Integer id;
        private String photoUrl;
        private String name;
        private Integer authorId;
        private String authorFirstName;
        private String authorLastName;
        private List<Author> collaborationAuthors;
        private String genre;
        private LocalDate releaseDate;
        private String fullDescription;
        private Integer pagesAmount;
        private Integer availableCount;
        private Integer generalCount;
        private Double averageClientsAge;
        private Long rentCount;
        private List<String> notReturnedBooks;
        private String usingLibraryTime;

        public Builder setId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder setPhotoUrl(String photoUrl) {
            this.photoUrl = photoUrl;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAuthorId(Integer authorId) {
            this.authorId = authorId;
            return this;
        }

        public Builder setAuthorFirstName(String authorFirstName) {
            this.authorFirstName = authorFirstName;
            return this;
        }

        public Builder setAuthorLastName(String authorLastName) {
            this.authorLastName = authorLastName;
            return this;
        }

        public Builder setCollaborationAuthors(List<Author> collaborationAuthors) {
            this.collaborationAuthors = collaborationAuthors;
            return this;
        }

        public Builder setGenre(String genre) {
            this.genre = genre;
            return this;
        }

        public Builder setReleaseDate(LocalDate releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public Builder setFullDescription(String fullDescription) {
            this.fullDescription = fullDescription;
            return this;
        }

        public Builder setPagesAmount(Integer pagesAmount) {
            this.pagesAmount = pagesAmount;
            return this;
        }

        public Builder setAvailableCount(Integer availableCount) {
            this.availableCount = availableCount;
            return this;
        }

        public Builder setGeneralCount(Integer generalCount) {
            this.generalCount = generalCount;
            return this;
        }

        public Builder setAverageClientsAge(Double averageClientsAge) {
            this.averageClientsAge = averageClientsAge;
            return this;
        }

        public Builder setRentCount(Long rentCount) {
            this.rentCount = rentCount;
            return this;
        }

        public Builder setGetNotReturnedBooks(List<String> notReturnedBooks) {
            this.notReturnedBooks = notReturnedBooks;
            return this;
        }

        public Builder setUsingLibraryTime(String usingLibraryTime) {
            this.usingLibraryTime = usingLibraryTime;
            return this;
        }

        public BookView build() {
            BookView bookView = new BookView();
            bookView.setId(id);
            bookView.setPhotoUrl(photoUrl);
            bookView.setName(name);
            bookView.setAuthorId(authorId);
            bookView.setAuthorFirstName(authorFirstName);
            bookView.setAuthorLastName(authorLastName);
            bookView.setCollaborationAuthors(collaborationAuthors);
            bookView.setGenre(genre);
            bookView.setReleaseDate(releaseDate);
            bookView.setFullDescription(fullDescription);
            bookView.setPagesAmount(pagesAmount);
            bookView.setAvailableCount(availableCount);
            bookView.setGeneralCount(generalCount);
            bookView.setAverageClientsAge(averageClientsAge);
            bookView.setRentCount(rentCount);
            bookView.setNotReturnedBooks(notReturnedBooks);
            bookView.setUsingLibraryTime(usingLibraryTime);
            return bookView;
        }
    }
}
