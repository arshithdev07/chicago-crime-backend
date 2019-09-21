package com.tamu.chicagocrime.service.impl;

import com.tamu.chicagocrime.model.Crime;
import com.tamu.chicagocrime.repository.CrimeRepository;
import com.tamu.chicagocrime.service.CrimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by arshi on 9/17/2019.
 */
@Service
public class CrimeServiceImpl implements CrimeService {

    @Autowired
    CrimeRepository crimeRepository;

    @Override
    public List<Crime> getAllCrimes() {
        return crimeRepository.findAll();
    }

    @Override
    public Crime createCrime(Crime crime) {
        return crimeRepository.save(crime);
    }
}
