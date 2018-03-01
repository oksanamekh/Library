package com.library.repository;

import com.library.entity.Book;
import com.library.entity.Client;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Integer> {

    /**
     * Task 3.1. Переглянути статистику по читачу (які книжки брав)
     */
    List<Book> findReadBooks(int clientId);

    /**
     * Task 3.2. Переглянути статистику по читачу (які книжки на руках)
     */
    List<Book> findNotReturnedBooks(int clientId);

    /**
     * Task 3.3. Переглянути статистику по читачу
     * (скільки часу користується послугами бібліотеки)
     */
    Integer getUsingLibraryDaysCount(int clientId);


    /**
     * Task 7. Отримати список читачів-боржників з детальною інформацією
     */
    List<Client> findDebtors();

    /**
     * Task 8.1. Статистика по читачам (середній вік)
     */
    Double getAverageAge();

    /**
     * Task 8.2. Статистика по читачам (середній час користування бібліотекою)
     */
    Double getAverageUsingLibraryDaysCount();

    /**
     * Task 8.3. Статистика по читачам (середня кількість звернень за певний період)
     */
    BigDecimal getAverageRentsCountByPeriod(LocalDateTime fromTime, LocalDateTime toTime);

    /**
     * Task 9.1. Отримати середній вік читачів по певній книжці
     */
    Double findAverageAgeByBook(int bookId);

    /**
     * Task 9.2. Отримати середній вік читачів по певному автору
     */
    Double findAverageAgeByAuthor(int authorId);

    /**
     * No task. Returns age based on birth date.
     */
    Integer getAge(int clientId);

    List<Integer> getAllClientsId();

}

