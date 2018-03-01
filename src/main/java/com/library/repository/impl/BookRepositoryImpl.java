package com.library.repository.impl;

import com.library.entity.Book;
import com.library.repository.BookRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@Repository
public class BookRepositoryImpl extends CrudRepositoryImpl<Book, Integer>
        implements BookRepository {
    private static final LocalDate INDEPENDENCE_DAY_DATE = LocalDate.of(1991, Month.AUGUST, 24);

    @Override
    public Book findAvailableBookById(int bookId) {
        String sqlQuery = "SELECT b from Book b WHERE (b.id = ?1 and b.availableCount > 0)";
        TypedQuery<Book> query= getEntityManager().createQuery(sqlQuery, Book.class);
        query.setParameter(1,bookId);
        return query.getSingleResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Book> findByMainAuthor(int authorId) {
        String sqlQuery = "SELECT b FROM Book b JOIN b.mainAuthor a WHERE a.id = ?1";
        TypedQuery<Book> query = getEntityManager().createQuery(sqlQuery, Book.class);
        query.setParameter(1, authorId);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Book> findByCoAuthor(int coAuthorId) {
        String sqlQuery = "SELECT DISTINCT b.name FROM Book b JOIN b.collaborationAuthors a WHERE a.id = ?1";
        TypedQuery<Book> query = getEntityManager().createQuery(sqlQuery, Book.class);
        query.setParameter(1, coAuthorId);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long findReleasedDuringIndependence() {
        String sqlQuery = "SELECT COUNT(b.id) FROM Book b"
                + " WHERE b.releaseDate BETWEEN :startDate AND :endDate";
        TypedQuery<Long> query = getEntityManager().createQuery(sqlQuery, Long.class);
        query.setParameter("startDate", INDEPENDENCE_DAY_DATE);
        query.setParameter("endDate", LocalDate.now());
        return query.getSingleResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long getRentCount(int bookId) {
        String sqlQuery = "SELECT COUNT(r.copyOfBook.id) FROM Rent r JOIN r.copyOfBook c JOIN c.book b WHERE b.id = ?1";
        TypedQuery<Long> query= getEntityManager().createQuery(sqlQuery,Long.class);
        query.setParameter(1,bookId);
        return query.getSingleResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long getCopiesRentCount(int bookId) {
        String sqlQuery = "SELECT COUNT(c.id) FROM Rent r JOIN r.copyOfBook c JOIN c.book b"
                + " WHERE b.id = ?1 GROUP BY b.id";
        TypedQuery<Long> query = getEntityManager().createQuery(sqlQuery, Long.class);
        query.setParameter(1,bookId);
        return query.getSingleResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double averageReadingTime(int bookId) {
//        TODO check this query for exeption
        String sqlQuery = "SELECT AVG (DATEDIFF(r.returnTime, r.borrowingTime)) FROM Rent r"
                + " JOIN r.copyOfBook c JOIN c.book b WHERE b.id = ?1 AND r.returnTime IS NOT NULL";
        TypedQuery<Double> query = getEntityManager().createQuery(sqlQuery, Double.class);
        query.setParameter(1,bookId);
        return query.getSingleResult();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Book> findBestBooksByPeriod(LocalDateTime startDate, int resultListSize) {
        String sqlQuery = "SELECT b FROM Rent r JOIN r.copyOfBook c JOIN c.book b"
                + " WHERE r.borrowingTime BETWEEN :startDate AND :endDate GROUP BY b.id ORDER BY COUNT(r.id) DESC";
        TypedQuery<Book> query = getEntityManager().createQuery(sqlQuery, Book.class);
        query.setParameter("startDate", startDate)
                .setParameter("endDate", LocalDateTime.now())
                .setMaxResults(resultListSize);
        return query.getResultList();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Book> findWorstBooksByPeriod(LocalDateTime startDate, int resultListSize) {
        String sqlQuery = "SELECT b FROM Rent r JOIN r.copyOfBook c JOIN c.book b"
                + " WHERE r.borrowingTime BETWEEN :startDate AND :endDate GROUP BY b.id ORDER BY COUNT(r.id) ASC";
        TypedQuery<Book> query = getEntityManager().createQuery(sqlQuery, Book.class);
        query.setParameter("startDate", startDate)
                .setParameter("endDate", LocalDateTime.now())
                .setMaxResults(resultListSize);
        return query.getResultList();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Long> findBestCountOfRentByPeriod(LocalDateTime startDate, int resultListSize) {
        String sqlQuery = "SELECT COUNT(r.id) FROM Rent r JOIN r.copyOfBook c JOIN c.book b"
                + " WHERE r.borrowingTime BETWEEN :startDate AND :endDate GROUP BY b.id ORDER BY COUNT(r.id) DESC";
        TypedQuery<Long> query = getEntityManager().createQuery(sqlQuery, Long.class);
        query.setParameter("startDate", startDate)
                .setParameter("endDate", LocalDateTime.now())
                .setMaxResults(resultListSize);
        return query.getResultList();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Long> findWorstCountOfRentByPeriod(LocalDateTime startDate, int resultListSize) {
        String sqlQuery = "SELECT COUNT(r.id) FROM Rent r JOIN r.copyOfBook c JOIN c.book b"
                + " WHERE r.borrowingTime BETWEEN :startDate AND :endDate GROUP BY b.id ORDER BY COUNT(r.id) ASC";
        TypedQuery<Long> query = getEntityManager().createQuery(sqlQuery, Long.class);
        query.setParameter("startDate", startDate)
                .setParameter("endDate", LocalDateTime.now())
                .setMaxResults(resultListSize);
        return query.getResultList();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Book findBookByName(String bookName) {
        String sqlQuery = "SELECT book FROM Book book WHERE book.name = ?1";
        TypedQuery<Book> query = getEntityManager().createQuery(sqlQuery, Book.class);
        query.setParameter(1, bookName);
        return query.getSingleResult();
    }
//    @Override
//    public List<BookIndexView> findAllAvailableBookIndexViews() {
//        String sqlQuery = "SELECT new com.library.model.view.BookIndexView"
//                +"( b.id, b.name, a.firstName, a.lastName, g.genreName, b.photoUrl, b.availableCount) "
//                    +"FROM Book b JOIN b.genre g JOIN b.mainAuthor a WHERE (b.id = ?1 and b.availableCount > 0)";
//        TypedQuery<BookIndexView> query = getEntityManager().createQuery(sqlQuery, BookIndexView.class);
//        return query.getResultList();
//    }
}