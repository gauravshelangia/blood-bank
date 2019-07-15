package com.indorse.blood.bank.dao.api;

import com.indorse.blood.bank.model.BloodInventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodInventoryRepository extends CrudRepository<BloodInventory, Long> {

}
