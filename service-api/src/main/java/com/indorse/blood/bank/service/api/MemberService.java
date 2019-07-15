package com.indorse.blood.bank.service.api;

import com.indorse.blood.bank.rest.web.model.MemberDto;

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
     */
    void deleteByMemberCode(String memberCode, String email);

    /**
     * Get memberDetail by memberCode or email
     * @param memberCode
     * @param email
     * @return
     */
    MemberDto getByMemberCode(String memberCode, String email);

}
