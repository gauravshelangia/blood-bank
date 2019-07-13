package com.indorse.blood.bank.model;

import com.indorse.blood.bank.model.constant.BloodGroup;
import com.indorse.blood.bank.model.constant.BloodSubType;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "blood_inventory")
public class BloodInventory extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "stored_at")
    private BloodBankBranch bloodBankBranch;
    @Column
    private BloodGroup bloodGroup;
    @Column
    private BloodSubType bloodSubType;
    @Column
    private Integer quantityInMl;
    @Column
    private Date expiresOn;
    @Column
    private Boolean active;
}
