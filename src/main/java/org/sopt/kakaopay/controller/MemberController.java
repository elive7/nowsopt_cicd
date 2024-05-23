package org.sopt.kakaopay.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sopt.kakaopay.common.dto.SuccessMessage;
import org.sopt.kakaopay.common.dto.SuccessStatusResponse;
import org.sopt.kakaopay.service.MemberService;
import org.sopt.kakaopay.service.dto.BalanceFindDto;
import org.sopt.kakaopay.service.dto.PayPointFindDto;
import org.sopt.kakaopay.service.dto.PayMoneyFindDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/paypoint")
    public ResponseEntity<SuccessStatusResponse<PayPointFindDto>> getMemberPayPoint(
        @RequestHeader("memberId") Long memberId
    ) {
        return ResponseEntity.status(HttpStatus.OK)
            .body(SuccessStatusResponse.of(SuccessMessage.PAYPOINT_FIND_SUCCESS,
                memberService.findPayPointById(memberId)));
    }


    @GetMapping("/paymoney")
    public ResponseEntity<SuccessStatusResponse<PayMoneyFindDto>> getMemberPayMoney(
        @RequestHeader("memberId") Long memberId
    ) {
        return ResponseEntity.status(HttpStatus.OK)
            .body(SuccessStatusResponse.of(SuccessMessage.PAYMONEY_FIND_SUCCESS,
                memberService.findPayMoneyById(memberId)));
    }


    @GetMapping("/balance")
    public ResponseEntity<SuccessStatusResponse<BalanceFindDto>> getMemberBalance(
        @RequestHeader("memberId") Long memberId
    ) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(SuccessStatusResponse.of(SuccessMessage.BALANCE_FIND_SUCCESS,
                    memberService.findBalanceById(memberId)));
    }


}
