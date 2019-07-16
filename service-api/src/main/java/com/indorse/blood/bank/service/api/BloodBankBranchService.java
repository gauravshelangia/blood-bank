package com.indorse.blood.bank.service.api;

import com.indorse.blood.bank.rest.web.model.BloodBankBranchDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BloodBankBranchService {

    /**
     * Add blood bank Branch
     * @param bloodBankBranchDto
     * @return
     */
    BloodBankBranchDto add(BloodBankBranchDto bloodBankBranchDto);

    /**
     * Update an existing blood bank branch details
     * @param bloodBankBranchDto
     */
    void update(BloodBankBranchDto bloodBankBranchDto);

    /**
     * Get BloodBank branch by branchCode
     * @param branchCode
     * @return
     */
    BloodBankBranchDto getByBranchCode(String branchCode);

    /**
     * Get all branches of a bank by blood bank name
     * @param bloodBankName
     * @return
     */
    List<BloodBankBranchDto> getAllBloodBankBranches(String bloodBankName);

    /**
     * Delete blood bank branch by branch code
     * @param branchCode
     */
    void deleteByBranchCode(String branchCode);

}
