package com.indorse.blood.bank.service.api;

import com.indorse.blood.bank.model.BloodDonationDetail;
import com.indorse.blood.bank.rest.web.model.BloodDonationDetailDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BloodDonationDetailService {

    /**
     * Save blood donation detail
     * @param donationDetailDto
     */
    void save(BloodDonationDetailDto donationDetailDto);

    /**
     * update existing blood donation details
     * @param donationDetail
     */
    void update(BloodDonationDetail donationDetail);

    /**
     * Get all donation detail by a member
     * @param memberId
     * @return
     */
    List<BloodDonationDetailDto> getDetailsByMemberId(String memberId);

    /**
     * Delete donation detail by Id
     * @param donationDetailId
     */
    void delete(Integer donationDetailId);
}
