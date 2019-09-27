package com.tamu.chicagocrime.rest.impl;

import com.tamu.chicagocrime.model.Community;
import com.tamu.chicagocrime.model.Crime;
import com.tamu.chicagocrime.model.CrimeCode;
import com.tamu.chicagocrime.model.District;
import com.tamu.chicagocrime.repository.CommunityRepository;
import com.tamu.chicagocrime.repository.CrimeCodeRepository;
import com.tamu.chicagocrime.repository.CrimeRepository;
import com.tamu.chicagocrime.repository.DistrictRepository;
import com.tamu.chicagocrime.rest.DataUploadController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by arshi on 9/19/2019.
 */
@RestController
public class DataUploadControllerImpl implements DataUploadController {

    @Autowired
    CommunityRepository communityRepository;

    @Autowired
    DistrictRepository districtRepository;

    @Autowired
    CrimeCodeRepository crimeCodeRepository;

    @Autowired
    CrimeRepository crimeRepository;

    @Override
    @PostMapping("/uploadDistricts")
    public String uploadDistricts(@RequestBody District[] districts) {
        for(District dt : districts) {
            District district = new District();
            district.setDistrictName(dt.getDistrictName());
            districtRepository.save(district);
        }
        return "Successfully uploaded";
    }

    @Override
    @PostMapping("/uploadCommunities")
    public String uploadCommunities(@RequestBody Community[] communities) {
        for(Community ct : communities) {
            Community community = new Community();
            community.setCommunityName(ct.getCommunityName());
            communityRepository.save(community);
        }
        return "Successfully uploaded";
    }

    @Override
    @PostMapping("/uploadCrimeCodes")
    public String uploadCrimeCodes(@RequestBody CrimeCode[] crimeCodes) {
        for(CrimeCode cc : crimeCodes) {
            crimeCodeRepository.save(cc);
        }
        return "Successfully uploaded";
    }

    @Override
    @PostMapping("/uploadCrimes")
    public String uploadCrimes(@RequestBody Crime[] crimes) {
        for(Crime crime: crimes) {
            try {
                crimeRepository.save(crime);
            } catch (Exception e) {
                System.out.println(crime.getCrimeCode().getIucr());
            }
        }
        return "Successfully uploaded";
    }
}
