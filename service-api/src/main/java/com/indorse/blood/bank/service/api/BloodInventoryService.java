package com.indorse.blood.bank.service.api;

import com.indorse.blood.bank.model.constant.BloodGroup;
import com.indorse.blood.bank.model.constant.BloodSubType;
import com.indorse.blood.bank.rest.web.model.BloodInventoryDto;

public interface BloodInventoryService {

    /**
     * Add donated blood to inventory, with marking as inactive
     * @param bloodInventoryDto
     */
    void add(BloodInventoryDto bloodInventoryDto);

    /**
     * Update inventory
     * @param bloodInventoryDto
     */
    void update(BloodInventoryDto bloodInventoryDto);

    /**
     * Get blood if available by bloodGroup, bloodSubType and quantity
     * @param bloodGroup
     * @param bloodSubType
     * @param quantity
     * @return
     */
    BloodInventoryDto getBlood(BloodGroup bloodGroup, BloodSubType bloodSubType, Integer quantity);

    /**
     * Mark blood as inactive by inventoryId
     * @param inventoryId
     */
    void markInventoryAsInactive(Long inventoryId);
}
