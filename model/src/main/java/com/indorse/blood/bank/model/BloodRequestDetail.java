package com.indorse.blood.bank.model;

import com.indorse.blood.bank.model.constant.BloodGroup;
import com.indorse.blood.bank.model.constant.BloodSubType;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "blood_request_detail")
public class BloodRequestDetail extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "blood_seeker_id")
    private Member member;
    @ManyToOne
    @JoinColumn(name = "requested_at")
    private BloodBankBranch requestedFromBranch;
    @ManyToOne
    @JoinColumn(name = "given_from")
    private BloodBankBranch givenFromBranch;
    @Column
    private Date givenOn;
    @Column
    private BloodGroup bloodGroup;
    @Column
    private BloodSubType bloodSubType;
    @Column
    private Integer quantityInMl;
    @Column
    private Boolean requestCompleted;
    @Column
    private String info;
    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private BloodInventory bloodInventory;


}
