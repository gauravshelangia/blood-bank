package com.indorse.blood.bank.service.impl;

import com.indorse.blood.bank.model.constant.BloodGroup;
import com.indorse.blood.bank.model.constant.BloodSubType;
import com.indorse.blood.bank.rest.web.model.BloodInventoryDto;
import com.indorse.blood.bank.service.api.BloodInventoryService;

public class BloodInventoryServiceImpl implements BloodInventoryService {
    @Override
    public void add(BloodInventoryDto bloodInventoryDto) {

    }

    @Override
    public void update(BloodInventoryDto bloodInventoryDto) {

    }

    @Override
    public BloodInventoryDto getBlood(BloodGroup bloodGroup, BloodSubType bloodSubType, Integer quantity) {
        return null;
    }

    @Override
    public void markInventoryAsInactive(Long inventoryId) {

    }
}
