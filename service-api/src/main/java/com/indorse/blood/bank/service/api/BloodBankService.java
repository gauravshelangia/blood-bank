package com.indorse.blood.bank.service.api;

import com.indorse.blood.bank.rest.web.model.BloodBankDto;
import org.springframework.stereotype.Service;

@Service
public interface BloodBankService {

    /**
     * Save or add/register new @link{BloodBank}
     * @param bloodBankDto
     */
    void save(BloodBankDto bloodBankDto);

    /**
     * Update existing @link{BloodBank} details
     * @param bloodBankDto
     */
    void update(BloodBankDto bloodBankDto);

    /**
     * Get @link{BloodBank} detail by name
     * @param name
     * @return
     */
    BloodBankDto getByName(String name);

    /**
     * Delete Bank by bankName
     * @param bloodBankName
     */
    void deleteByName(String bloodBankName);
}
