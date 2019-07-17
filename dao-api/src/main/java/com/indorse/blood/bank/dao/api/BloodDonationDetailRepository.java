package com.indorse.blood.bank.dao.api;

import com.indorse.blood.bank.model.BloodDonationDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BloodDonationDetailRepository extends CrudRepository<BloodDonationDetail, Long> {

    /**
     * Get details by TestStore id
     * @param id
     * @return
     */
    BloodDonationDetail findByBloodTestStoreId(Long id);

    /**
     * Get detail by donationUniqueId
     * @param donationUniqueId
     * @return
     */
    BloodDonationDetail findByDonationUniqueId(String donationUniqueId);

    List<BloodDonationDetail> findAllByMemberMemberId(String memberId);
}
