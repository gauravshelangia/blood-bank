package com.indorse.blood.bank.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "blood_test_result")
public class BloodTestResult extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "blood_donation_detail_id")
    private BloodDonationDetail bloodDonationDetail;
    @OneToOne
    @JoinColumn(name = "blood_inventory_id")
    private BloodInventory bloodInventory;
    @Column
    private Boolean passed;
    @Column
    private String info;
    @Column
    private Date conductedOn;
}
