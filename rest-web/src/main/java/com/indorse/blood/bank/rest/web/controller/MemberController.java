package com.indorse.blood.bank.rest.web.controller;

import com.indorse.blood.bank.rest.web.model.ApiResponseDto;
import com.indorse.blood.bank.rest.web.model.MemberDto;
import com.indorse.blood.bank.service.api.MemberService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/member")
@Api(description = "Provides operation around blood bank member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping(value = "/add")
    public ApiResponseDto<String> addMember(HttpServletRequest request, @RequestBody MemberDto memberDto){
        String memberId = memberService.add(memberDto);
        return new ApiResponseDto<String>(memberId, "Member Added successfully", ApiResponseDto.STATUS_SUCCESS);
    }
}
