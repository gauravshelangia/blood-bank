package com.indorse.blood.bank.dao.api;

import com.indorse.blood.bank.model.BloodBank;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodBankRepository extends CrudRepository<BloodBank, Long> {

}
