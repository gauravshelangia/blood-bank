package com.indorse.blood.bank.service.api;

import com.indorse.blood.bank.rest.web.model.BloodRequestDetailDto;

public interface BloodRequestDetailService {

    /**
     * save blood request
     * @param bloodRequestDetailDto
     */
    void add(BloodRequestDetailDto bloodRequestDetailDto);

    /**
     * update blood request
     * @param bloodRequestDetailDto
     */
    void update(BloodRequestDetailDto bloodRequestDetailDto);

    /**
     * Get blood request by ID
     * @param bloodRequestId
     */
    void getBloodRequestDetail(Long bloodRequestId);

    /**
     * Delete bloodRequestDetail by id
     * @param bloodRequestId
     */
    void deleteBloodRequestDetailById(Long bloodRequestId);
}
