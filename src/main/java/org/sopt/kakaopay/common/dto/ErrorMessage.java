package org.sopt.kakaopay.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorMessage {

    //message 사용 예시
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "요청하신 사용자가 존재하지 않습니다."),
    BOOKMARK_NOT_FOUND(HttpStatus.NOT_FOUND.value(),"요청하신 북마크가 존재하지 않습니다."),
    POST_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "요청하신 포스트가 존재하지 않습니다."),
    BOOKMARK_ALREADY_EXISTS(HttpStatus.CONFLICT.value(), "요청하신 북마크가 이미 존재합니다."),
    FORBIDDEN_MEMBER_ACCESS(HttpStatus.FORBIDDEN.value(), "이 멤버는 해당 블로그에 대한 접근 권한이 없습니다.")
    ;
    private final int status;

    private final String message;
}
