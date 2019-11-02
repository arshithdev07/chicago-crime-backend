package com.tamu.chicagocrime.repository;

import com.tamu.chicagocrime.model.Crime;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by arshi on 9/17/2019.
 */
@Repository
public interface CrimeRepository extends MongoRepository<Crime, Long> {

//    List<Crime> findByCrimeDateAfter(Date crimeDate);
//    List<Crime> findByCrimeDateAfterAndDistrictDistrictNo(Date crimeDate, Long districtNo);
//
//    @Query("SELECT new map(c.district.districtName as label, COUNT(*) as data) FROM Crime c WHERE c.crimeDate >= :cd GROUP BY c.district.districtNo ORDER BY Count(*)")
//    List<?> findCrimeCount(@Param("cd") Date crimeDate);
//
//    @Query("SELECT new map(c.crimeCode.primaryDescription as crimeType, COUNT(*) as count) FROM Crime c WHERE c.locationDescription LIKE %:loc% GROUP BY c.crimeCode.primaryDescription ORDER BY Count(*) DESC")
//    List<?> findTopCrimesByLocation(@Param("loc") String location);
//
//    @Query("SELECT new map(c.communityArea.communityName as community, COUNT(*) as count) FROM Crime c WHERE c.crimeDate >= :cd AND c.crimeCode.primaryDescription='ARSON' GROUP BY c.communityArea.communityNo ORDER BY Count(*) DESC")
//    List<?> findCrimeCountByCommunityArea(@Param("cd") Date crimeDate);
//
////    @Query("SELECT new map(c.communityArea.communityName as community, c.beat as beat, COUNT(*) as count) FROM Crime c GROUP BY c.communityArea.communityName,c.beat ORDER BY Count(*) DESC")
////    List<?> findCrimeCountByCommunityArea(@Param("cd") Date crimeDate);

}
