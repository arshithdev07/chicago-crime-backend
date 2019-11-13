package com.tamu.chicagocrime.rest.impl;

import com.tamu.chicagocrime.model.Crime;
import com.tamu.chicagocrime.rest.CrimeController;
import com.tamu.chicagocrime.service.CrimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @GetMapping("/insertCrimes")
    public String insertCrimes() {
        return crimeService.insertCrimes();
    }

//    @Override
//    @GetMapping("/totalCrimeCount")
//    public Long getTotalCrimeCount() {
//        return crimeService.getTotalCrimeCount();
//    }
//
//    @Override
//    @PostMapping("/crime")
//    public Crime createCrime(@RequestBody Crime crime) {
//        return crimeService.createCrime(crime);
//    }
//
//    @Override
//    @GetMapping("/filteredCrimesByDate")
//    public List<Crime> getCrimesByDate(@RequestParam("crimeDate") String crimeDate){
//        return crimeService.getCrimesByDate(crimeDate);
//    }
//
//    @Override
//    @GetMapping("/filteredCrimes")
//    public List<Crime> getCrimesByDateAndDistrict(@RequestParam("crimeDate") String crimeDate, @RequestParam("districtNo") String districtNo) {
//        return crimeService.getCrimesByDateAndDistrict(crimeDate, districtNo);
//    }
//
    @Override
    @GetMapping("/crimeCount")
    public List<?> getCrimeCountByDistrict(@RequestParam("crimeDate") String crimeDate) {
        return crimeService.getCrimeCountByDistrict(crimeDate);
    }
//
//    @Override
//    @GetMapping("/locationCrimeCount")
//    public List<?> getCrimeCountByLocation(@RequestParam("location") String location) {
//        return crimeService.getCrimeCountByLocation(location);
//    }
//
//    @Override
//    @GetMapping("/areaCrimeCount")
//    public List<?> getCrimeCountByCommunityArea(@RequestParam("crimeDate") String crimeDate) {
//        return crimeService.getCrimeCountByCommunityArea(crimeDate);
//    }
}
