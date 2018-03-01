package com.library.repository.impl;

import com.library.entity.Book;
import com.library.entity.Client;
import com.library.repository.ClientRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ClientRepositoryImpl extends CrudRepositoryImpl<Client, Integer>
        implements ClientRepository {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Book> findReadBooks(int clientId) {
        String sql = "SELECT client.readBooks FROM Client client WHERE client.id = ?1";
        TypedQuery<Book> query = getEntityManager().createQuery(sql, Book.class);
        query.setParameter(1, clientId);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Book> findNotReturnedBooks(int clientId) {
        String sql = "SELECT book FROM Rent rent "
                + "JOIN rent.copyOfBook copyOfBook "
                + "JOIN copyOfBook.book book "
                + "JOIN rent.user client "
                + "WHERE rent.returnTime IS NULL AND client.id = ?1";
        TypedQuery<Book> query = getEntityManager().createQuery(sql, Book.class);
        query.setParameter(1, clientId);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     * Returns days count that preset client uses library (in days).
     */
    @Override
    public Integer getUsingLibraryDaysCount(int clientId) {
        String sql = "SELECT DATEDIFF (client.registrationDate, NOW()) "
                + "FROM Client client WHERE client.id = ?1";
        TypedQuery<Integer> query = getEntityManager().createQuery(sql, Integer.class);
        query.setParameter(1, clientId);
        return query.getSingleResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Client> findDebtors() {
        String sql = "SELECT client FROM Client client JOIN FETCH client.rents rent "
                + "WHERE rent.returnTime IS NULL AND rent.borrowingTime IS NOT NULL";
        TypedQuery<Client> query = getEntityManager().createQuery(sql, Client.class);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     * Returns average age by all clients (in years).
     */
    @Override
    public Double getAverageAge() {
        String sql = "SELECT AVG(DATEDIFF(NOW(), client.birthDate) / 365.25) "
                + "FROM Client client";
        TypedQuery<Double> query = getEntityManager().createQuery(sql, Double.class);
        return query.getSingleResult();
    }

    /**
     * {@inheritDoc}
     * Returns average days count that all clients use library (in days).
     */
    @Override
    public Double getAverageUsingLibraryDaysCount() {
        String sql = "SELECT AVG(DATEDIFF(NOW(), client.registrationDate)) "
                + "FROM Client client";
        TypedQuery<Double> query = getEntityManager().createQuery(sql, Double.class);
        return query.getSingleResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal getAverageRentsCountByPeriod(LocalDateTime fromTime, LocalDateTime toTime) {
        String sql = "SELECT AVG(one_client_count) "
                + "FROM client, "
                + "(SELECT count(rent.id) AS one_client_count "
                + "FROM rent, client  "
                + "WHERE rent.user_id = client.id "
                + "AND rent.borrowing_time BETWEEN ?1 AND ?2 "
                + "GROUP BY client.id) AS temp_table";
        Query nativeQuery = getEntityManager().createNativeQuery(sql, BigDecimal.class);
        nativeQuery.setParameter(1, fromTime);
        nativeQuery.setParameter(2, toTime);
        return (BigDecimal) nativeQuery.getSingleResult();
    }

    /**
     * {@inheritDoc}
     * Returns average age by all clients that read preset book (in years)
     */
    @Override
    public Double findAverageAgeByBook(int bookId) {
        String sql = "SELECT AVG(DATEDIFF(NOW(), client.birthDate) / 365.25) "
                + "FROM Client client "
                + "JOIN client.readBooks book "
                + "WHERE book.id = ?1";
        TypedQuery<Double> query = getEntityManager().createQuery(sql, Double.class);
        query.setParameter(1, bookId);
        return query.getSingleResult();
    }

    /**
     * {@inheritDoc}
     * Returns average age by all clients that read books by preset author (in years)
     */
    @Override
    public Double findAverageAgeByAuthor(int authorId) {
        String sql = "SELECT AVG(DATEDIFF(NOW(), client.birthDate) / 365.25)"
                + " FROM Client client "
                + "JOIN client.readBooks book "
                + "JOIN book.mainAuthor author "
                + "WHERE author.id = ?1";
        TypedQuery<Double> query = getEntityManager().createQuery(sql, Double.class);
        query.setParameter(1, authorId);
        return query.getSingleResult();
    }

    /**
     * (Not works)
     * {@inheritDoc}
     */
    @Override
    public Integer getAge(int clientId) {
        String sql = "SELECT DATEDIFF(NOW(), client.birthDate) "
                + "FROM Client client "
                + "WHERE client.id = ?1";
        TypedQuery<Double> query = getEntityManager().createQuery(sql, Double.class);
        query.setParameter(1, clientId);
        List singleResult = query.getResultList();
        Integer result = (Integer) singleResult.get(0);
        return result;
    }

    @Override
    public List<Integer> getAllClientsId() {
        String sql = "SELECT client.id from Client client";
        TypedQuery<Integer> query = getEntityManager().createQuery(sql, Integer.class);
        return query.getResultList();
    }
}