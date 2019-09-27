package com.tamu.chicagocrime.repository;

import com.tamu.chicagocrime.model.Crime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by arshi on 9/17/2019.
 */
@Repository
public interface CrimeRepository extends JpaRepository<Crime, Long> {

    List<Crime> findByCrimeDateAfter(Date crimeDate);
    List<Crime> findByCrimeDateAfterAndDistrictDistrictNo(Date crimeDate, Long districtNo);

    @Query("SELECT new map(c.district.districtName as label, COUNT(*) as data) FROM Crime c WHERE c.crimeDate >= :cd GROUP BY c.district.districtNo ORDER BY Count(*)")
    List<?> findCrimeCount(@Param("cd") Date crimeDate);

}
