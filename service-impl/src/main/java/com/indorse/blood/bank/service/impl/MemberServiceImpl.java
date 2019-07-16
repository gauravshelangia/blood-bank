package com.indorse.blood.bank.service.impl;

import com.indorse.blood.bank.dao.api.MemberRepository;
import com.indorse.blood.bank.model.Member;
import com.indorse.blood.bank.model.exception.BloodBankException;
import com.indorse.blood.bank.rest.web.model.MemberDto;
import com.indorse.blood.bank.service.api.MemberService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import static com.indorse.blood.bank.model.constant.ErrorCode.*;

@Service
public class MemberServiceImpl implements MemberService {

    private static final String MEMBER_ID_PREFIX = "BBM";

    @Autowired
    private MemberRepository memberRepository;


    @Override
    public MemberDto add(MemberDto memberDto) {
        if (ObjectUtils.isEmpty(memberDto)){
            throw new BloodBankException(NEW_MEMBER_EMPTY, new Object[]{});
        }
        if (!ObjectUtils.isEmpty(memberDto.getMemberId())){
            throw new BloodBankException(NEW_MEMBER_WITH_MEMBER_ID, new Object[]{memberDto.getMemberId()});
        }
        Member member = new Member();
        BeanUtils.copyProperties(memberDto, member);
        member = memberRepository.save(member);
        member.setMemberId(MEMBER_ID_PREFIX+member.getId());
        memberRepository.save(member);
        memberDto.setMemberId(member.getMemberId());
        return memberDto;
    }

    @Override
    public void update(MemberDto memberDto) {
        Member member = memberRepository.findByMemberIdOrEmail(memberDto.getMemberId(), memberDto.getEmail());
        if (ObjectUtils.isEmpty(member)){
            throw new BloodBankException(RESOURCE_NOT_FOUND,new Object[]{"Member", memberDto.getMemberId() + ", "
                    + memberDto.getEmail()});
        }

        member.setBloodGroup(memberDto.getBloodGroup());
        member.setDateOfBirth(memberDto.getDateOfBirth());
        member.setFirstName(memberDto.getFirstName());
        member.setLastName(memberDto.getLastName());
        member.setMiddleName(memberDto.getMiddleName());
        member.setEmail(memberDto.getEmail());
        memberRepository.save(member);
    }

    @Override
    public void deleteByMemberIdOrEmail(String memberId, String email) {
        Member member = memberRepository.findByMemberIdOrEmail(memberId, email);
        if (ObjectUtils.isEmpty(member)){
            throw new BloodBankException(RESOURCE_NOT_FOUND,new Object[]{"Member", memberId + ", " + email});
        }
        member.setMarkForDelete(true);
        memberRepository.save(member);
    }

    @Override
    public MemberDto getByMemberIdOrEmail(String memberId, String email) {
        Member member = memberRepository.findByMemberIdOrEmail(memberId, email);
        MemberDto memberDto = new MemberDto();
        BeanUtils.copyProperties(member, memberDto);
        return memberDto;
    }
}
