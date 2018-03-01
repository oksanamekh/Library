package com.library.service.impl;

import com.library.entity.Rent;
import com.library.repository.RentRepository;
import com.library.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentServiceImpl extends CrudServiceImpl <Rent, Integer, RentRepository> implements RentService{

    @Autowired
    private RentRepository rentRepository;
    @Override
    public RentRepository getRepository() {
        return rentRepository;
    }
}
