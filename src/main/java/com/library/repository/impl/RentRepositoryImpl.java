package com.library.repository.impl;

import com.library.entity.Rent;
import com.library.repository.RentRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RentRepositoryImpl extends CrudRepositoryImpl<Rent, Integer>
        implements RentRepository {

}
