package com.indorse.blood.bank.dao.api;

import com.indorse.blood.bank.model.BloodTestResult;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodTestResultRepository extends CrudRepository<BloodTestResult, Long> {

}
