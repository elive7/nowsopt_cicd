package org.sopt.kakaopay.exception;

import org.sopt.kakaopay.common.dto.ErrorMessage;

public class BusinessException extends RuntimeException {
    private ErrorMessage errorMessage;
    public BusinessException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }
}
