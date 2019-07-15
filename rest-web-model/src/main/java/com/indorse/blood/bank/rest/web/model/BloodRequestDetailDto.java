package com.indorse.blood.bank.rest.web.model;

import com.indorse.blood.bank.model.BloodBankBranch;
import com.indorse.blood.bank.model.constant.BloodGroup;
import com.indorse.blood.bank.model.constant.BloodSubType;
import lombok.Data;

@Data
public class BloodRequestDetailDto {
    private String bloodRequestId;
    private String memberCode;
    private String requestedFromBranchCode;
    private String givenFromBranchCode;
    private BloodGroup bloodGroup;
    private BloodSubType bloodSubType;
    private Integer quantityInMl;
}
