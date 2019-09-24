package com.tamu.chicagocrime.service.impl;

import com.tamu.chicagocrime.model.District;
import com.tamu.chicagocrime.repository.DistrictRepository;
import com.tamu.chicagocrime.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by arshi on 9/24/2019.
 */
@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    DistrictRepository districtRepository;

    @Override
    public List<District> getAllDistricts() {
        return districtRepository.findAll();
    }
}
