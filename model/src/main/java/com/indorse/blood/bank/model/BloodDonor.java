package com.indorse.blood.bank.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "blood_donor")
public class BloodDonor extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "donor_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "donated_at")
    private BloodBankBranch bloodBankBranch;

    @Column
    private Data donatedOn;

}
