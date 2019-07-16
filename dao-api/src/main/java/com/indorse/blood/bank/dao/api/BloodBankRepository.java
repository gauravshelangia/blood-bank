package com.indorse.blood.bank.dao.api;

import com.indorse.blood.bank.model.BloodBank;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodBankRepository extends CrudRepository<BloodBank, Long> {

    /**
     * Get blood bank by bank code or bank name
     * @param bankCode
     * @param name
     * @return
     */
    BloodBank findByBankCodeOrName(String bankCode, String name);
}
