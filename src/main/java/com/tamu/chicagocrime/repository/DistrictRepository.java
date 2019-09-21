package com.tamu.chicagocrime.repository;

import com.tamu.chicagocrime.model.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by arshi on 9/19/2019.
 */
@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {
}
