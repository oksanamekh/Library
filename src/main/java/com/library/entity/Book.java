package com.library.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "book")
public class Book extends AbstractEntityId {

    @ManyToMany(mappedBy = "readBooks")
//    @JoinTable(name = "book_id_user_id",
//            joinColumns = {@JoinColumn(name = "book_id")},
//            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<Client> users;

    @OneToMany(mappedBy = "book")
    private List<BookCopy> copiesList;

    @ManyToOne(fetch = FetchType.LAZY)
    private Author mainAuthor;

    @ManyToMany
    private List<Author> collaborationAuthors;

    @ManyToOne(fetch = FetchType.LAZY)
    private Genre genre;

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "name", length = 40)
    private String name;

    @Column(name = "available_count")
    private Integer availableCount;

    @Column(name = "general_count")
    private Integer generalCount;

    @Column(name = "full_description", length = 1000)
    private String fullDescription;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "pages_amount")
    private Integer pagesAmount;

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getPagesAmount() {
        return pagesAmount;
    }

    public void setPagesAmount(Integer pagesAmount) {
        this.pagesAmount = pagesAmount;
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

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<BookCopy> getCopiesList() {
        return copiesList;
    }

    public void setCopiesList(List<BookCopy> copiesList) {
        this.copiesList = copiesList;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public List<Client> getUsers() {
        return users;
    }

    public void setUsers(List<Client> users) {
        this.users = users;
    }

    public Author getMainAuthor() {
        return mainAuthor;
    }

    public void setMainAuthor(Author mainAuthor) {
        this.mainAuthor = mainAuthor;
    }

    public List<Author> getCollaborationAuthors() {
        return collaborationAuthors;
    }

    public void setCollaborationAuthors(List<Author> collaborationAuthors) {
        this.collaborationAuthors = collaborationAuthors;
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
}
