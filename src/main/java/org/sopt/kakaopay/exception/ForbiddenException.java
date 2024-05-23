package org.sopt.kakaopay.exception;

import org.sopt.kakaopay.common.dto.ErrorMessage;

public class ForbiddenException extends BusinessException{
    public ForbiddenException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
