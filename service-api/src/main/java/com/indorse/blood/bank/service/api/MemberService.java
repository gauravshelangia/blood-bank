package com.indorse.blood.bank.service.api;

import com.indorse.blood.bank.rest.web.model.MemberDto;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {

    /**
     * Add member to the catalog
     * @param memberDto
     * @return memberCode
     */
    String add(MemberDto memberDto);

    /**
     * Update existing memberDetail
     * @param memberDto
     */
    void update(MemberDto memberDto);

    /**
     * Delete member by memberCode or email
     * @param memberCode
     * @param email
     */
    void deleteByMemberCodeOrEmail(String memberCode, String email);

    /**
     * Get memberDetail by memberCode or email
     * @param memberCode
     * @param email
     * @return
     */
    MemberDto getByMemberCodeOrEmail(String memberCode, String email);

}
