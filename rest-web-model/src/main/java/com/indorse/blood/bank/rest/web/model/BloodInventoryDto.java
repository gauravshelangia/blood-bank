package com.indorse.blood.bank.rest.web.model;

import com.indorse.blood.bank.model.constant.BloodGroup;
import com.indorse.blood.bank.model.constant.BloodSubType;
import lombok.Data;

import java.util.Date;

@Data
public class BloodInventoryDto extends BaseDto{

    private Long inventoryId;
    private String bloodBankBranchCode;
    private BloodGroup bloodGroup;
    private BloodSubType bloodSubType;
    private Integer quantityInMl;
    private Date expiresOn;
}
