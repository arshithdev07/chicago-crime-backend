package com.tamu.chicagocrime.service;

import com.tamu.chicagocrime.model.Crime;

import java.util.List;

/**
 * Created by arshi on 9/17/2019.
 */
public interface CrimeService {

    List<Crime> getAllCrimes();
    Crime createCrime(Crime crime);
}
