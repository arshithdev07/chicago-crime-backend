package com.tamu.chicagocrime.service.impl;

import com.tamu.chicagocrime.model.Crime;
import com.tamu.chicagocrime.repository.CrimeRepository;
import com.tamu.chicagocrime.service.CrimeService;
import com.tamu.chicagocrime.service.util.DatesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Override
    public List<Crime> getCrimesByDate(String crimeDate) {
        Date date = DatesUtil.stringToDate(crimeDate, "yyyy-MM-dd");
        return crimeRepository.findByCrimeDateAfter(date);
    }

    @Override
    public List<Crime> getCrimesByDateAndDistrict(String crimeDate, String districtNo) {
        Date date = DatesUtil.stringToDate(crimeDate, "yyyy-MM-dd");
        date = DatesUtil.reduceDays(date, -1);
        Long dNo = Long.parseLong(districtNo);
        return crimeRepository.findByCrimeDateAfterAndDistrictDistrictNo(date, dNo);
    }

    @Override
    public List<?> getCrimeCountByDistrict(String crimeDate) {
        Date date = DatesUtil.stringToDate(crimeDate, "yyyy-MM-dd");
        date = DatesUtil.reduceDays(date, -1);
        return crimeRepository.findCrimeCount(date);
    }
}
