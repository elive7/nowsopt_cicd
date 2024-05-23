package org.sopt.kakaopay.service;

import lombok.RequiredArgsConstructor;
import org.sopt.kakaopay.common.dto.ErrorMessage;
import org.sopt.kakaopay.domain.Member;
import org.sopt.kakaopay.exception.NotFoundException;
import org.sopt.kakaopay.repository.MemberRepository;
import org.sopt.kakaopay.service.dto.BalanceFindDto;
import org.sopt.kakaopay.service.dto.PayPointFindDto;
import org.sopt.kakaopay.service.dto.PayMoneyFindDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    public Member findMemberById(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(
            () -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND)
        );
    }


    public Member findMemberByBankAndBankAccount(String bank, String bankAccount) {
        return memberRepository.findByBankAndBankAccount(bank, bankAccount).orElseThrow(
            () -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND)

        );
    }

    public PayPointFindDto findPayPointById(Long memberId) {
        Member member = findMemberById(memberId);
        return PayPointFindDto.of(member);
    }

    public PayMoneyFindDto findPayMoneyById(Long memberId) {
        Member member = findMemberById(memberId);
        return PayMoneyFindDto.of(member);
    }

    public BalanceFindDto findBalanceById(Long memberId) {
        Member member = findMemberById(memberId);
        return BalanceFindDto.of(member);
    }

}
