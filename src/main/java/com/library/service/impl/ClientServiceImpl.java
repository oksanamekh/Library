package com.library.service.impl;

import com.library.entity.Book;
import com.library.entity.Client;
import com.library.entity.buider.ClassBuilder;
import com.library.entity.buider.clientbuilder.RegisteredClient;
import com.library.model.request.ClientRequest;
import com.library.repository.ClientRepository;
import com.library.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClientServiceImpl extends CrudServiceImpl<Client, Integer, ClientRepository> implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientRepository getRepository() {
        return clientRepository;
    }

    @Override
    public List<Book> findReadBooks(int clientId) {
        return getRepository().findReadBooks(clientId);
    }

    @Override
    public List<Book> findNotReturnedBooks(int clientId) {
        return getRepository().findNotReturnedBooks(clientId);
    }

    @Override
    public Integer getUsingLibraryDaysCount(int clientId) {
        return getRepository().getUsingLibraryDaysCount(clientId);
    }

    @Override
    public List<Client> findDebtors() {
        return getRepository().findDebtors();
    }

    @Override
    public Double getAverageAge() {
        return getRepository().getAverageAge();
    }

    @Override
    public Double getAverageUsingLibraryDaysCount() {
        return getRepository().getAverageUsingLibraryDaysCount();
    }

    @Override
    public BigDecimal getAverageRentsCountByPeriod(LocalDateTime fromTime, LocalDateTime toTime) {
        return getRepository().getAverageRentsCountByPeriod(fromTime, toTime);
    }

    @Override
    public Double findAverageAgeByBook(int bookId) {
        return getRepository().findAverageAgeByBook(bookId);
    }

    @Override
    public Double findAverageAgeByAuthor(int authorId) {
        return getRepository().findAverageAgeByAuthor(authorId);
    }

    @Override
    public Integer getAge(int clientId) {
        return getRepository().getAge(clientId);
    }

    @Override
    @Transactional
    public void save(ClientRequest clientRequest) {
        ClassBuilder<Client> clientClassBuider = new RegisteredClient(clientRequest);
        clientClassBuider.buid();
        getRepository().save(clientClassBuider.getInstance());
    }

    @Override
    public List<Integer> getAllClientsId() {
        return getRepository().getAllClientsId();
    }
}
