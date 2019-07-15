package com.indorse.blood.bank.rest.web.model;

import com.indorse.blood.bank.model.constant.BloodGroup;
import lombok.Data;

import java.util.Date;

@Data
public class BloodDonationDetailDto extends BaseDto{

    private String bloodBankBranchCode;
    private Date donatedOn;
    private BloodGroup bloodGroup;
    private Integer quantityInMl;
    private String memberId;

}
