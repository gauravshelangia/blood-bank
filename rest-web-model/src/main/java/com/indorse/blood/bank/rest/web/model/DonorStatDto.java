package com.indorse.blood.bank.rest.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DonorStatDto {

    private Long donatedBlood;
    private String name;
    private String memberId;
}
