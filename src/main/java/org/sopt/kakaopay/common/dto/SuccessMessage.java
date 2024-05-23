package org.sopt.kakaopay.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum SuccessMessage {

    PAYPOINT_FIND_SUCCESS(HttpStatus.OK.value(), "페이포인트 조회가 완료되었습니다."),
    PAYMONEY_FIND_SUCCESS(HttpStatus.OK.value(), "페이머니 조회가 완료되었습니다."),

    BALANCE_FIND_SUCCESS(HttpStatus.OK.value(), "계좌 잔액 조회가 완료되었습니다."),

    BOOKMARK_DELETE_SUCCESS(HttpStatus.OK.value(), "즐겨찾기가 삭제되었습니다."),
    BOOKMARK_ADDED_SUCCESS(HttpStatus.CREATED.value(), "즐겨찾기가 추가되었습니다."),

    HISTORY_FIND_SUCCESS(HttpStatus.OK.value(),"거래 내역 조회가 완료되었습니다.");



    private final int status;
    private final String message;
}
