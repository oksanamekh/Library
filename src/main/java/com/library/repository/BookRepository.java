package com.library.repository;

import com.library.entity.Book;

import java.time.LocalDateTime;
import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {

    /**
     * Task 1. Подивитись, чи певна книжка доступна
     */
    Book findAvailableBookById(int bookId);

    /**
     * Task 2.1. Вивести всі книжки по основному автору
     */
    List<Book> findByMainAuthor(int authorId);

    /**
     * Task 2.2. Вивести всі книжки по співавтору
     */
    List<Book> findByCoAuthor(int coAuthorId);

    /**
     * Task 4 Показати книги, які видані в період незалежності
     */
    Long findReleasedDuringIndependence();

    /**
     * Task 5.1. Скільки разів брали певну книжку в загальному
     */
    Long getRentCount(int bookId);

    /**
     * Task 5.2. Скільки разів брали певну книжку по примірникам
     * (Скільки разів брали певний примірник.)
     */
    Long getCopiesRentCount(int bookId);

    /**
     * Task 5.3. Скільки разів брали певну книжку (середній час читання)
     */
    Double averageReadingTime(int bookId);

    /**
     * Task 6.1. Отримати найпопулярніші книжки за період
     */
    List<Book> findBestBooksByPeriod(LocalDateTime startDate, int resultListSize);

    /**
     * Task 6.2. Отримати найнепопулярніші книжки за період
     */
    List<Book> findWorstBooksByPeriod(LocalDateTime startDate, int resultListSize);
    /**
     * Task 6.3. Отримати к-сть рентів найпопулярніших книжок за період
     */
    List<Long> findBestCountOfRentByPeriod(LocalDateTime startDate, int resultListSize);

    /**
     * Task 6.4. Отримати к-сть рентів НЕ найпопулярніших книжок за період
     */
    List<Long> findWorstCountOfRentByPeriod(LocalDateTime startDate, int resultListSize);

    /**
     * Task 10. Вивести по назві книжки
     * кількість екземплярів з інформацією про них (наявна, на руках)
     */
    Book findBookByName(String bookName);
    // TODO Тут потрібно повертати не Book, а щось типу BookAvailabilityView, котррий містить bookName, generalCount, availableCount

//    List<BookIndexView> findAllAvailableBookIndexViews();
}
