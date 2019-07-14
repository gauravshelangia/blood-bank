package com.indorse.blood.bank.dao.api;

import com.indorse.blood.bank.model.BloodDonationDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodDonationeDetailRepository extends CrudRepository<BloodDonationDetail, Long> {

}
