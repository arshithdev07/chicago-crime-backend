package com.tamu.chicagocrime.rest;

import com.tamu.chicagocrime.model.Community;
import com.tamu.chicagocrime.model.Crime;
import com.tamu.chicagocrime.model.CrimeCode;
import com.tamu.chicagocrime.model.District;

/**
 * Created by arshi on 9/19/2019.
 */
public interface DataUploadController {
    String uploadDistricts(District[] districts);
    String uploadCommunities(Community[] communities);
    String uploadCrimeCodes(CrimeCode[] crimeCodes);
    String uploadCrimes(Crime[] crimes);
}
