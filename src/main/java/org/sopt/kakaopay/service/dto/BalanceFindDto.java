package org.sopt.kakaopay.service.dto;

import org.sopt.kakaopay.domain.Member;

public record BalanceFindDto(
    String balance
) {
    public static BalanceFindDto of(Member member){
        return new BalanceFindDto(member.getBalance());
    }

}
