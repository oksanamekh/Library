package com.library.service.impl;

import com.library.entity.Book;
import com.library.entity.buider.ClassBuilder;
import com.library.entity.buider.bookbuilder.RegisteredBook;
import com.library.model.request.BookRequest;
import com.library.model.request.BookFamousFilterRequest;
import com.library.repository.BookRepository;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookServiceImpl extends CrudServiceImpl<Book, Integer, BookRepository> implements BookService {

    private static final LocalDateTime WEEK_AGO = LocalDateTime.now().minusWeeks(1);
    private static final LocalDateTime MONTH_AGO = LocalDateTime.now().minusMonths(1);
    private static final LocalDateTime YEAR_AGO = LocalDateTime.now().minusYears(1);

    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookRepository getRepository() {
        return bookRepository;
    }

    @Override
    public Boolean getBookAvailability(int bookId) {
        Book book = bookRepository.findAvailableBookById(bookId);
        return (book != null);
    }

    @Override
    public List<Book> findByMainAuthor(int authorId) {
        List<Book> books = bookRepository.findByMainAuthor(authorId);
        return books;
    }

    @Override
    public List<Book> findByCoAuthor(int coAuthorId) {
        List<Book> books = bookRepository.findByCoAuthor(coAuthorId);
        return books;
    }

    @Override
    public Long findReleasedDuringIndependence() {
        Long count = bookRepository.findReleasedDuringIndependence();
        return count;
    }

    @Override
    public Long getRentCount(int bookId) {
        Long rentCount = bookRepository.getRentCount(bookId);
        return rentCount;
    }

    @Override
    public Long getCopiesRentCount(int bookId) {
        Long copiesRentCount = bookRepository.getCopiesRentCount(bookId);
        return copiesRentCount;
    }

    @Override
    public Double getAverageReadingTime(int bookId) {
        Double averageReadingTime = bookRepository.averageReadingTime(bookId);
        return averageReadingTime;
    }

    @Override
    public List<Book> findBestBooksByPeriod(LocalDateTime startDate, int resultListSize) {
        List<Book> books = bookRepository.findBestBooksByPeriod(startDate, resultListSize);
        return books;
    }

    @Override
    public List<Book> findWorstBooksByPeriod(LocalDateTime startDate, int resultListSize) {
        List<Book> books = bookRepository.findBestBooksByPeriod(startDate, resultListSize);
        return books;
    }

    @Override
    public List<Long> findBestCountOfRentByPeriod(LocalDateTime startDate, int resultListSize) {
        List<Long> countOfRentByPeriod = bookRepository.findBestCountOfRentByPeriod(startDate, resultListSize);
        return countOfRentByPeriod;
    }

    @Override
    public List<Long> findWorstCountOfRentByPeriod(LocalDateTime startDate, int resultListSize) {
        List<Long> countOfRentByPeriod = bookRepository.findBestCountOfRentByPeriod(startDate, resultListSize);
        return countOfRentByPeriod;
    }

    @Override
    public Book findBookByName(String bookName) {
        Book book = bookRepository.findBookByName(bookName);
        return book;
    }

    @Override
    @Transactional
    public void save(BookRequest bookRequest) {
        ClassBuilder<Book> classBuider = new RegisteredBook(bookRequest);
        classBuider.buid();
        getRepository().save(classBuider.getInstance());
    }

    @Override
    public List<Book> findBooksByFamousFilter(BookFamousFilterRequest request) {

        if (request.getBookFamous().equals("best")) {
            if (request.getPeriod().equals("week")) {
                return bookRepository.findBestBooksByPeriod(WEEK_AGO, 4);
            }
            if (request.getPeriod().equals("year")) {
                return bookRepository.findBestBooksByPeriod(YEAR_AGO, 4);
            } else return bookRepository.findBestBooksByPeriod(MONTH_AGO, 4);
        }
        if (request.getBookFamous().equals("worst")) {
            if (request.getPeriod().equals("week")) {
                return bookRepository.findWorstBooksByPeriod(WEEK_AGO, 4);
            }
            if (request.getPeriod().equals("year")) {
                return bookRepository.findWorstBooksByPeriod(YEAR_AGO, 4);
            } else return bookRepository.findWorstBooksByPeriod(MONTH_AGO, 4);
        } else return bookRepository.findAll();

    }
}
