package com.indorse.blood.bank.dao.api;

import com.indorse.blood.bank.model.BloodRequestDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodRequestDetailRepository extends CrudRepository<BloodRequestDetail, Long> {

}
