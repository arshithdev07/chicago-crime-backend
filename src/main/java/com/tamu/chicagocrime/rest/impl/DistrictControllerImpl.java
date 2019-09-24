package com.tamu.chicagocrime.rest.impl;

import com.tamu.chicagocrime.model.District;
import com.tamu.chicagocrime.rest.DistrictController;
import com.tamu.chicagocrime.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by arshi on 9/24/2019.
 */
@RestController
public class DistrictControllerImpl implements DistrictController {

    @Autowired
    DistrictService districtService;

    @Override
    @GetMapping("/districts")
    public List<District> getAllDistricts() {
        return districtService.getAllDistricts();
    }
}
