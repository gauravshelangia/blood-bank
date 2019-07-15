package com.indorse.blood.bank.service.api;

import com.indorse.blood.bank.rest.web.model.MemberDto;

public interface MemberService {

    /**
     * Add member to the catalog
     * @param memberDto
     * @return memberCode
     */
    String add(MemberDto memberDto);
}
