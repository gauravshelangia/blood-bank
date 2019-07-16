package com.indorse.blood.bank.service.impl;

import com.indorse.blood.bank.dao.api.BloodBankRepository;
import com.indorse.blood.bank.model.BloodBank;
import com.indorse.blood.bank.model.constant.ErrorCode;
import com.indorse.blood.bank.model.exception.BloodBankException;
import com.indorse.blood.bank.rest.web.model.BloodBankDto;
import com.indorse.blood.bank.service.api.BloodBankService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import static com.indorse.blood.bank.model.constant.ErrorCode.*;

@Service
public class BloodBankServiceImpl  implements BloodBankService {

    private static final String BLOOD_BANK="BB";
    @Autowired
    private BloodBankRepository bloodBankRepository;


    @Override
    public BloodBankDto save(BloodBankDto bloodBankDto) {

        if (ObjectUtils.isEmpty(bloodBankDto)){
            throw new BloodBankException(CRUD_EMPTY_ENTITY_ERROR, new Object[]{"Blood Bank"});
        }
        BloodBank bloodBank = new BloodBank();
        BeanUtils.copyProperties(bloodBankDto, bloodBank);
        bloodBank = bloodBankRepository.save(bloodBank);
        bloodBank.setBankCode(BLOOD_BANK+bloodBank.getId());
        bloodBank = bloodBankRepository.save(bloodBank);
        bloodBankDto.setBankCode(bloodBank.getBankCode());
        return bloodBankDto;
    }

    @Override
    public void update(BloodBankDto bloodBankDto) {
        if (ObjectUtils.isEmpty(bloodBankDto)){
            throw new BloodBankException(CRUD_EMPTY_ENTITY_ERROR, new Object[]{"blood bank"});
        }
        BloodBank bloodBank = bloodBankRepository.findByBankCodeOrName(bloodBankDto.getBankCode(),
                bloodBankDto.getName());
        if (ObjectUtils.isEmpty(bloodBank)){
            throw new BloodBankException(RESOURCE_NOT_FOUND,new Object[]{"BloodBank", bloodBankDto.getBankCode() + ", "
                    + bloodBank.getName()});
        }
        BeanUtils.copyProperties(bloodBankDto, bloodBank);
        bloodBankRepository.save(bloodBank);
    }

    @Override
    public BloodBankDto getByName(String name) {
        BloodBankDto bloodBankDto = new BloodBankDto();
        BloodBank bloodBank = bloodBankRepository.findByBankCodeOrName(null, name);
        BeanUtils.copyProperties(bloodBank, bloodBankDto);
        return bloodBankDto;
    }

    @Override
    public void deleteByNameOrBankCode(String bloodBankName, String bloodBankCode) {
        BloodBank bloodBank = bloodBankRepository.findByBankCodeOrName(bloodBankCode, bloodBankName);
        if (ObjectUtils.isEmpty(bloodBank)){
            throw new BloodBankException(RESOURCE_NOT_FOUND,
                    new Object[]{"Blood Bank", bloodBank + " and "+ bloodBankCode});
        }
        bloodBank.setMarkForDelete(true);
        bloodBankRepository.save(bloodBank);
    }

    @Override
    public BloodBank getBloodBankModelByName(String name) {
        return bloodBankRepository.findByBankCodeOrName(null, name);
    }
}
