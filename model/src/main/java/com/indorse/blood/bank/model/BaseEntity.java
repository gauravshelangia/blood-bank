package com.indorse.blood.bank.model;

import com.indorse.blood.bank.model.constant.FieldNames;
import lombok.Data;
import org.springframework.data.annotation.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

@Data
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(name = FieldNames.CREATED_DATE, updatable = false)
    private Date createdDate;

    @CreatedBy
    @Column(name = FieldNames.CREATED_BY, updatable = false)
    private String createdBy;

    @LastModifiedDate
    @Column(name = FieldNames.UPDATED_DATE)
    private Date updatedDate;

    @LastModifiedBy
    @Column(name = FieldNames.UPDATED_BY)
    private String updatedBy;

}
