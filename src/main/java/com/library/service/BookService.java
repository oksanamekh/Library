package com.library.service;

import com.library.entity.Book;
import com.library.model.request.BookRequest;
import com.library.model.request.ClientRequest;
import com.library.model.request.BookFamousFilterRequest;
import java.time.LocalDateTime;
import java.util.List;

public interface BookService extends CrudService<Book, Integer> {

    Boolean getBookAvailability(int bookId);

    List<Book> findByMainAuthor(int authorId);

    List<Book> findByCoAuthor(int coAuthorId);

    Long findReleasedDuringIndependence();

    Long getRentCount(int bookId);

    Long getCopiesRentCount(int bookId);

    Double getAverageReadingTime(int bookId);

    List<Book> findBestBooksByPeriod(LocalDateTime startDate, int resultListSize);

    List<Book> findWorstBooksByPeriod(LocalDateTime startDate, int resultListSize);

    List<Long> findBestCountOfRentByPeriod(LocalDateTime startDate, int resultListSize);

    List<Long> findWorstCountOfRentByPeriod(LocalDateTime startDate, int resultListSize);

    Book findBookByName(String bookName);

    void save(BookRequest bookRequest);

    List<Book> findBooksByFamousFilter(BookFamousFilterRequest request);

}
