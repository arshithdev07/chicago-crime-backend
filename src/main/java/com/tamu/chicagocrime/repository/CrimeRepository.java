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

    @Query("SELECT new map(c.crimeCode.primaryDescription as crimeType, COUNT(*) as count) FROM Crime c WHERE c.locationDescription LIKE %:loc% GROUP BY c.crimeCode.primaryDescription ORDER BY Count(*) DESC")
    List<?> findTopCrimesByLocation(@Param("loc") String location);

}
