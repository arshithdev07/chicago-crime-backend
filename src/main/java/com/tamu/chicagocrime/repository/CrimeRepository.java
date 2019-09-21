package com.tamu.chicagocrime.repository;

import com.tamu.chicagocrime.model.Crime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by arshi on 9/17/2019.
 */
@Repository
public interface CrimeRepository extends JpaRepository<Crime, Long> {
}
