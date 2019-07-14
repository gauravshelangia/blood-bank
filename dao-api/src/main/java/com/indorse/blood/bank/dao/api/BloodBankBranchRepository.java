package com.indorse.blood.bank.dao.api;

import com.indorse.blood.bank.model.BloodBankBranch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodBankBranchRepository extends CrudRepository<BloodBankBranch, Long> {

}
