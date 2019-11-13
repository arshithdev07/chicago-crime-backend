package com.tamu.chicagocrime.rest;

import com.tamu.chicagocrime.model.Crime;

import java.util.List;

/**
 * Created by arshi on 9/17/2019.
 */
public interface CrimeController {
    List<Crime> getAllCrimes();
    String insertCrimes();
//    Long getTotalCrimeCount();
//    Crime createCrime(Crime crime);
//    List<Crime> getCrimesByDate(String crimeDate);
//    List<Crime> getCrimesByDateAndDistrict(String crimeDate, String districtNo);
    List<?> getCrimeCountByDistrict(String crimeDate);
//    List<?> getCrimeCountByLocation(String location);
//    List<?> getCrimeCountByCommunityArea(String crimeDate);
    
}
