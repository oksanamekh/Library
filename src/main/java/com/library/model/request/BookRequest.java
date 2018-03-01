package com.library.model.request;

import com.library.entity.Author;
import com.library.entity.Genre;
import java.time.LocalDate;

public class BookRequest {

    private Integer id;
    private String name;
    private String mainAuthorFirstName;
    private String mainAuthorLastName;
    private String author;
    private String releaseDate;
    private Integer generalCount;
    private String genre;
    private String photoUrl;
    private String fullDescription;
    private Integer pagesAmount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMainAuthorFirstName() {
        return mainAuthorFirstName;
    }

    public void setMainAuthorFirstName(String mainAuthorFirstName) {
        this.mainAuthorFirstName = mainAuthorFirstName;
    }

    public String getMainAuthorLastName() {
        return mainAuthorLastName;
    }

    public void setMainAuthorLastName(String mainAuthorLastName) {
        this.mainAuthorLastName = mainAuthorLastName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getGeneralCount() {
        return generalCount;
    }

    public void setGeneralCount(Integer generalCount) {
        this.generalCount = generalCount;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
