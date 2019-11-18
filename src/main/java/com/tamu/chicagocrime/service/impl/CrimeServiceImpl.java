package com.tamu.chicagocrime.service.impl;

import com.tamu.chicagocrime.model.*;
import com.tamu.chicagocrime.repository.CrimeRepository;
import com.tamu.chicagocrime.service.CrimeService;
import com.tamu.chicagocrime.service.util.DatesUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

/**
 * Created by arshi on 9/17/2019.
 */
@Service
public class CrimeServiceImpl implements CrimeService {

    @Autowired
    CrimeRepository crimeRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<Crime> getAllCrimes() {
        return crimeRepository.findAll();
    }

    @Override
    public String insertCrimes() {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("C:/Users/arshi/Desktop/crimes.json"))
        {
            //Read JSON file
            Object obj = null;
            try {
                obj = jsonParser.parse(reader);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            JSONArray crimeList = (JSONArray) obj;
            System.out.println(crimeList);

            crimeList.forEach(crime -> {
                try {
                    Crime crimeNew = new Crime();
                    crimeNew.setCrimeId((Long) ((JSONObject) crime).get("crimeId"));
                    crimeNew.setArrest((Boolean) ((JSONObject) crime).get("arrest"));

                    JSONObject cc = (JSONObject) ((JSONObject) crime).get("crimeCode");
                    CrimeCode crimeCode = new CrimeCode();
                    crimeCode.setIucr((String) cc.get("iucr"));
                    crimeCode.setPrimaryDescription((String) cc.get("primaryDescription"));
                    crimeCode.setSecondaryDescription((String) cc.get("secondaryDescription"));
                    crimeNew.setCrimeCode(crimeCode);

                    crimeNew.setLocationDescription((String) ((JSONObject) crime).get("locationDescription"));
                    crimeNew.setDomestic((Boolean) ((JSONObject) crime).get("domestic"));
                    crimeNew.setCaseNumber((String) ((JSONObject) crime).get("caseNumber"));
                    crimeNew.setFBICode((String) ((JSONObject) crime).get("fbicode"));
                    crimeNew.setBeat((String) ((JSONObject) crime).get("beat"));

                    String creationDate = (String) ((JSONObject) crime).get("creationTimestamp");
                    Date date1 = null;
                    try {
                        date1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US).parse(creationDate);
                    } catch (java.text.ParseException e) {
                        e.printStackTrace();
                    }
                    crimeNew.setCreationTimestamp(date1);
                    crimeNew.setBlock((String) ((JSONObject) crime).get("block"));

                    String crimeDate = (String) ((JSONObject) crime).get("crimeDate");
                    Date date2 = null;
                    try {
                        date2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US).parse(crimeDate);
                    } catch (java.text.ParseException e) {
                        e.printStackTrace();
                    }
                    crimeNew.setCrimeDate(date2);
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(date2);
                    int year = cal.get(Calendar.YEAR);
                    int month = cal.get(Calendar.MONTH);
                    int day = cal.get(Calendar.DAY_OF_MONTH);
                    crimeNew.setCrimeYear(String.valueOf(year));

                    JSONObject dis = (JSONObject) ((JSONObject) crime).get("district");
                    District district = new District();
                    district.setDistrictNo((Long) dis.get("districtNo"));
                    district.setDistrictName((String) dis.get("districtName"));
                    crimeNew.setDistrict(district);

                    JSONObject com = (JSONObject) ((JSONObject) crime).get("communityArea");
                    Community community = new Community();
                    community.setCommunityNo((Long) com.get("communityNo"));
                    community.setCommunityName((String) com.get("communityName"));
                    crimeNew.setCommunityArea(community);
                    crimeNew.setCount(1);

                    crimeRepository.save(crimeNew);
                }
                catch (NullPointerException e) {
                    System.out.println(crime);
                }
            });
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "OK";
    }

//    @Override
//    public Long getTotalCrimeCount() {
//        return crimeRepository.count();
//    }
//
//    @Override
//    public Crime createCrime(Crime crime) {
//        return crimeRepository.save(crime);
//    }
//
//    @Override
//    public List<Crime> getCrimesByDate(String crimeDate) {
//        Date date = DatesUtil.stringToDate(crimeDate, "yyyy-MM-dd");
//        return crimeRepository.findByCrimeDateAfter(date);
//    }
//
//    @Override
//    public List<Crime> getCrimesByDateAndDistrict(String crimeDate, String districtNo) {
//        Date date = DatesUtil.stringToDate(crimeDate, "yyyy-MM-dd");
//        date = DatesUtil.reduceDays(date, -1);
//        Long dNo = Long.parseLong(districtNo);
//        return crimeRepository.findByCrimeDateAfterAndDistrictDistrictNo(date, dNo);
//    }
//
    @Override
    public List<?> getCrimeCountByDistrict(String crimeDate) {
        Date date = DatesUtil.stringToDate(crimeDate, "yyyy-MM-dd");
//        date = DatesUtil.reduceDays(date, -1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);

        MatchOperation yearMatch = match(Criteria.where("crimeYear").is(String.valueOf(year)));
        GroupOperation groupByDistrict = group("district.districtNo")
                                            .sum("count").as("count")
                                            .addToSet("district.districtName").as("districtName");
        SortOperation sortByCount = sort(Sort.Direction.ASC, "count");

        Aggregation agg = newAggregation(
            yearMatch,
            groupByDistrict,
            project("count", "districtName"),
            sortByCount
        );

        AggregationResults<LocationCrimesResult> groupResults
                = mongoTemplate.aggregate(agg, Crime.class, LocationCrimesResult.class);
        List<LocationCrimesResult> result = groupResults.getMappedResults();

        return result;
//        return crimeRepository.findCrimeCount(date);
    }

    @Override
    public List<?> getCrimeCountByLocation(String location) {
        MatchOperation locationMatch = match(Criteria.where("locationDescription").regex(location));
        GroupOperation groupByCrime = group("crimeCode.primaryDescription")
                .sum("count").as("count")
                .addToSet("crimeCode.primaryDescription").as("crime");
        SortOperation sortByCount = sort(Sort.Direction.DESC, "count");

        Aggregation agg = newAggregation(
                locationMatch,
                groupByCrime,
                project("count", "crime"),
                sortByCount
        );

        AggregationResults<LocationCrimeResult> groupResults
                = mongoTemplate.aggregate(agg, Crime.class, LocationCrimeResult.class);
        List<LocationCrimeResult> result = groupResults.getMappedResults();

        return result;

//        return crimeRepository.findTopCrimesByLocation(location);
    }

    @Override
    public List<?> getCrimeCountByCommunityArea(String crimeDate) {
        Date date = DatesUtil.stringToDate(crimeDate, "yyyy-MM-dd");
//        date = DatesUtil.reduceDays(date, -1);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);

        MatchOperation yearMatch = match(Criteria.where("crimeYear").is(String.valueOf(year)).and("crimeCode.primaryDescription").is("ARSON"));
        GroupOperation groupByDistrict = group("communityArea.communityNo")
                .sum("count").as("count")
                .addToSet("communityArea.communityName").as("community");
        SortOperation sortByCount = sort(Sort.Direction.DESC, "count");

        Aggregation agg = newAggregation(
                yearMatch,
                groupByDistrict,
                project("count", "community"),
                sortByCount
        );

        AggregationResults<AreaCrimesResult> groupResults
                = mongoTemplate.aggregate(agg, Crime.class, AreaCrimesResult.class);
        List<AreaCrimesResult> result = groupResults.getMappedResults();

        return result;
    }
}
