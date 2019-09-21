package com.tamu.chicagocrime.rest.impl;

import com.tamu.chicagocrime.model.Crime;
import com.tamu.chicagocrime.rest.CrimeController;
import com.tamu.chicagocrime.service.CrimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by arshi on 9/17/2019.
 */
@RestController
public class CrimeControllerImpl implements CrimeController {

    @Autowired
    CrimeService crimeService;

    @Override
    @GetMapping("/crimes")
    public List<Crime> getAllCrimes() {
        return crimeService.getAllCrimes();
    }

    @Override
    @PostMapping("/crime")
    public Crime createCrime(@RequestBody Crime crime) {
        return crimeService.createCrime(crime);
    }
}
