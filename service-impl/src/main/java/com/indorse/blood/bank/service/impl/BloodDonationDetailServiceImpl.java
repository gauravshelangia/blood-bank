package com.indorse.blood.bank.service.impl;

import com.indorse.blood.bank.dao.api.BloodDonationDetailRepository;
import com.indorse.blood.bank.model.*;
import com.indorse.blood.bank.model.exception.BloodBankException;
import com.indorse.blood.bank.rest.web.model.*;
import com.indorse.blood.bank.service.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.indorse.blood.bank.model.constant.ErrorCode.*;

@Service
public class BloodDonationDetailServiceImpl implements BloodDonationDetailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BloodDonationDetailServiceImpl.class);
    private static final String BLOOD_DONATION_PREFIX = "BDD";

    @Autowired
    private BloodDonationDetailRepository bloodDonationDetailRepository;

    @Autowired
    private BloodTestStoreService bloodTestStoreService;

    @Autowired
    private BloodInventoryService bloodInventoryService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private BloodBankBranchService bloodBankBranchService;


    @Override
    public BloodDonationDetailDto save(BloodDonationDetailDto donationDetailDto) {
        if (ObjectUtils.isEmpty(donationDetailDto)){
            throw new BloodBankException(CRUD_EMPTY_ENTITY_ERROR, new Object[]{"Blood Donation Details"});
        }
        if (ObjectUtils.isEmpty(donationDetailDto.getDonationUniqueId())){
            throw new BloodBankException(NEW_ENTITY_WITH_ID_CODE, new Object[]{"Blood Donation Detail", donationDetailDto.getDonationUniqueId()});
        }
        BloodDonationDetail donationDetail = new BloodDonationDetail();
        BeanUtils.copyProperties(donationDetailDto, donationDetail);
        if (ObjectUtils.isEmpty(donationDetail.getDonatedOn())){
            donationDetail.setDonatedOn(new Date());
        }
        BloodBankBranch bloodBankBranch = bloodBankBranchService.getBloodBankBranchModelByBranchCode(donationDetailDto.getBloodBankBranchCode());
        if (ObjectUtils.isEmpty(bloodBankBranch)){
            throw new BloodBankException(RESOURCE_NOT_FOUND, new Object[]{"Blood Bank Branch", donationDetailDto.getBloodBankBranchCode()});
        }
        donationDetail.setBloodBankBranch(bloodBankBranch);
        Member member = memberService.getByMemberId(donationDetailDto.getMemberId());
        if (ObjectUtils.isEmpty(member)){
            throw new BloodBankException(RESOURCE_NOT_FOUND, new Object[]{"Blood Donor", donationDetailDto.getMemberId()});
        }
        donationDetail.setMember(member);

        // add blood to Test store as well
        BloodTestStoreDto bloodTestStoreDto = new BloodTestStoreDto();
        bloodTestStoreDto.setConductedOn(new Date());
        bloodTestStoreDto.setBloodGroup(donationDetailDto.getBloodGroup());
        bloodTestStoreDto.setBloodSubType(donationDetailDto.getBloodSubType());
        bloodTestStoreDto = bloodTestStoreService.add(bloodTestStoreDto);


        donationDetail.setDonationUniqueId(BLOOD_DONATION_PREFIX+donationDetail.getId());

        donationDetail = bloodDonationDetailRepository.save(donationDetail);
        donationDetailDto.setDonationUniqueId(donationDetail.getDonationUniqueId());

        // Add blood to inventory
        BloodInventoryDto bloodInventoryDto = new BloodInventoryDto();
        bloodInventoryDto.setBloodBankBranchCode(donationDetailDto.getBloodBankBranchCode());
        bloodInventoryDto.setBloodGroup(donationDetailDto.getBloodGroup());
        bloodInventoryDto.setBloodSubType(donationDetailDto.getBloodSubType());
        bloodInventoryDto.setQuantityInMl(donationDetailDto.getQuantityInMl());
        bloodInventoryDto.setDonationUniqueId(donationDetail.getDonationUniqueId());
        bloodInventoryDto.setTestId(bloodTestStoreDto.getTestId());

        bloodInventoryDto = bloodInventoryService.add(bloodInventoryDto);

        // link inventory to donation detail
        donationDetail = bloodDonationDetailRepository.save(donationDetail);
        return donationDetailDto;
    }

    @Override
    public void update(BloodDonationDetailDto donationDetailDto) {
        if (ObjectUtils.isEmpty(donationDetailDto)){
            throw new BloodBankException(CRUD_EMPTY_ENTITY_ERROR, new Object[]{"Blood Donation Details"});
        }
        if (ObjectUtils.isEmpty(donationDetailDto.getDonationUniqueId())){
            throw new BloodBankException(NEW_ENTITY_WITH_ID_CODE, new Object[]{"Blood Donation Detail", donationDetailDto.getDonationUniqueId()});
        }
        BloodDonationDetail donationDetail = bloodDonationDetailRepository.findByDonationUniqueId(donationDetailDto.getDonationUniqueId());
        BeanUtils.copyProperties(donationDetailDto, donationDetail);
        if (ObjectUtils.isEmpty(donationDetail)){
            throw new BloodBankException(RESOURCE_NOT_FOUND,
                    new Object[]{"Blood donation detail", "donationUniqueId Id = "+ donationDetailDto.getDonationUniqueId()});
        }
        Member member = memberService.getByMemberId(donationDetailDto.getMemberId());
        if (ObjectUtils.isEmpty(member)){
            throw new BloodBankException(RESOURCE_NOT_FOUND, new Object[]{"Blood Donor", donationDetailDto.getMemberId()});
        }
        donationDetail.setMember(member);
        BloodBankBranch bloodBankBranch = bloodBankBranchService.getBloodBankBranchModelByBranchCode(donationDetailDto.getBloodBankBranchCode());
        if (ObjectUtils.isEmpty(bloodBankBranch)){
            throw new BloodBankException(RESOURCE_NOT_FOUND, new Object[]{"Blood Bank Branch", donationDetailDto.getBloodBankBranchCode()});
        }
        donationDetail.setBloodBankBranch(bloodBankBranch);

        donationDetail.setBloodGroup(donationDetailDto.getBloodGroup());
        donationDetail.setBloodSubType(donationDetailDto.getBloodSubType());
        donationDetail.setQuantityInMl(donationDetail.getQuantityInMl());

        BloodInventory bloodInventory = bloodInventoryService.getBloodInventoryByDonationUniqueCode(donationDetail.getDonationUniqueId());
        BloodInventoryDto bloodInventoryDto = new BloodInventoryDto();
        bloodInventoryDto.setQuantityInMl(donationDetailDto.getQuantityInMl());
        bloodInventoryDto.setBloodGroup(donationDetailDto.getBloodGroup());
        bloodInventoryDto.setBloodSubType(donationDetailDto.getBloodSubType());
        bloodInventoryDto.setInventoryCode(bloodInventory.getInventoryCode());
        bloodInventoryService.update(bloodInventoryDto);
        donationDetail = bloodDonationDetailRepository.save(donationDetail);
    }

    @Override
    public List<BloodDonationDetailDto> getDetailsByMemberId(String memberId) {
        List<BloodDonationDetail> donationDetails = bloodDonationDetailRepository.findAllByMemberMemberId(memberId);
        List<BloodDonationDetailDto> donationDetailDtoList = new ArrayList<>();
        for(BloodDonationDetail donationDetail : donationDetails){
            BloodDonationDetailDto bloodDonationDetailDto = new BloodDonationDetailDto();
            BeanUtils.copyProperties(donationDetail, bloodDonationDetailDto);
            donationDetailDtoList.add(bloodDonationDetailDto);
        }
        return donationDetailDtoList;
    }

    @Override
    public void delete(String donationUniqueId) {
        BloodDonationDetail bloodDonationDetail = bloodDonationDetailRepository.findByDonationUniqueId(donationUniqueId);
        if (ObjectUtils.isEmpty(bloodDonationDetail)){
            throw new BloodBankException(RESOURCE_NOT_FOUND, new Object[]{"Blood donation detail", "donationUniqueId Id = "+donationUniqueId});
        }
        bloodDonationDetail.setMarkForDelete(true);
        bloodDonationDetailRepository.save(bloodDonationDetail);
    }

    @Override
    public List<MemberDto> getTopDonorsByPeriod(StatsPeriod period, int month, int year) {
        //TODO write query
        return null;
    }


}
