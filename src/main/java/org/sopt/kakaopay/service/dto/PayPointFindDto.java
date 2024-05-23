package org.sopt.kakaopay.service.dto;

import org.sopt.kakaopay.domain.Member;

public record PayPointFindDto(
    String payPoint
) {

    public static PayPointFindDto of(Member member) {
        return new PayPointFindDto(
            member.getPayPoint());
    }
}
