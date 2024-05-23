package org.sopt.kakaopay.service.dto;

import org.sopt.kakaopay.domain.Member;

public record PayMoneyFindDto(String payMoney){
    public static PayMoneyFindDto of(Member member){
        return new PayMoneyFindDto(member.getPayMoney());
    }
}
