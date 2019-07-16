package com.indorse.blood.bank.service.impl;

import com.indorse.blood.bank.dao.api.BloodBankBranchRepository;
import com.indorse.blood.bank.dao.api.BloodBankRepository;
import com.indorse.blood.bank.model.BloodBank;
import com.indorse.blood.bank.model.BloodBankBranch;
import com.indorse.blood.bank.model.exception.BloodBankException;
import com.indorse.blood.bank.rest.web.model.BloodBankBranchDto;
import com.indorse.blood.bank.rest.web.model.BloodBankDto;
import com.indorse.blood.bank.service.api.BloodBankBranchService;
import com.indorse.blood.bank.service.api.BloodBankService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

import static com.indorse.blood.bank.model.constant.ErrorCode.*;

@Service
public class BloodBankBranchServiceImpl implements BloodBankBranchService {

    private static final String BRANCH_CODE_PREFIX = "BR";

    @Autowired
    private BloodBankBranchRepository bloodBankBranchRepository;

    @Autowired
    private BloodBankService bloodBankService;


    @Override
    public BloodBankBranchDto add(BloodBankBranchDto bloodBankBranchDto) {
        if (ObjectUtils.isEmpty(bloodBankBranchDto)){
            throw new BloodBankException(CRUD_EMPTY_ENTITY_ERROR, new Object[]{"Blood Bank branch"});
        }
        BloodBank bloodBank = bloodBankService.getBloodBankModelByName(bloodBankBranchDto.getBloodBankName());
        if (ObjectUtils.isEmpty(bloodBankBranchDto)){
            throw new BloodBankException(BLOOD_BANK_NOT_EXIST, new Object[]{bloodBankBranchDto.getBloodBankName()});
        }
        BloodBankBranch bloodBankBranch = new BloodBankBranch();
        BeanUtils.copyProperties(bloodBankBranchDto, bloodBankBranch);
        bloodBankBranch.setBloodBank(bloodBank);
        bloodBankBranch = bloodBankBranchRepository.save(bloodBankBranch);
        bloodBankBranch.setBranchCode(bloodBank.getBankCode()+BRANCH_CODE_PREFIX+bloodBankBranch.getId());
        bloodBankBranch = bloodBankBranchRepository.save(bloodBankBranch);
        bloodBankBranchDto.setBranchCode(bloodBankBranch.getBranchCode());
        return bloodBankBranchDto;
    }

    @Override
    public void update(BloodBankBranchDto bloodBankBranchDto) {
        if (ObjectUtils.isEmpty(bloodBankBranchDto)){
            throw new BloodBankException(CRUD_EMPTY_ENTITY_ERROR, new Object[]{"blood bank branch"});
        }
        BloodBankBranch bloodBankBranch = bloodBankBranchRepository.findByBranchCode(bloodBankBranchDto.getBranchCode());
        if (ObjectUtils.isEmpty(bloodBankBranch)){
            throw new BloodBankException(RESOURCE_NOT_FOUND,new Object[]{"BloodBankBranch", bloodBankBranch.getBranchCode()});
        }
        BeanUtils.copyProperties(bloodBankBranchDto, bloodBankBranch);
        bloodBankBranchRepository.save(bloodBankBranch);
    }

    @Override
    public BloodBankBranchDto getByBranchCode(String branchCode) {
        BloodBankBranch bloodBankBranch = bloodBankBranchRepository.findByBranchCode(branchCode);
        BloodBankBranchDto bloodBankBranchDto = new BloodBankBranchDto();
        BeanUtils.copyProperties(bloodBankBranch, bloodBankBranchDto);
        return bloodBankBranchDto;
    }

    @Override
    public List<BloodBankBranchDto> getAllBloodBankBranches(String bloodBankName) {
        List<BloodBankBranchDto> bloodBankBranchDtos = new ArrayList<>();
        List<BloodBankBranch> branches = bloodBankBranchRepository.findAllByBloodBankName(bloodBankName);
        for (BloodBankBranch bloodBankBranch: branches) {
            BloodBankBranchDto bloodBankBranchDto = new BloodBankBranchDto();
            BeanUtils.copyProperties(bloodBankBranch, bloodBankBranchDto);
            bloodBankBranchDtos.add(bloodBankBranchDto);
        }
        return bloodBankBranchDtos;
    }

    @Override
    public void deleteByBranchCode(String branchCode) {
        BloodBankBranch bloodBankBranch = bloodBankBranchRepository.findByBranchCode(branchCode);
        if (ObjectUtils.isEmpty(bloodBankBranch)){
            throw new BloodBankException(RESOURCE_NOT_FOUND,
                    new Object[]{"Blood Bank Branch", branchCode});
        }
        bloodBankBranch.setMarkForDelete(true);
        bloodBankBranchRepository.save(bloodBankBranch);
    }
}
