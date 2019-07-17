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
     * @return
     */
    BloodDonationDetailDto save(BloodDonationDetailDto donationDetailDto);

    /**
     * update existing blood donation details
     * @param donationDetailDto
     */
    void update(BloodDonationDetailDto donationDetailDto);

    /**
     * Get all donation detail by a member
     * @param memberId
     * @return
     */
    List<BloodDonationDetailDto> getDetailsByMemberId(String memberId);

    /**
     * Delete donation detail by Id
     * @param donationUniqueId
     */
    void delete(String donationUniqueId);
}
