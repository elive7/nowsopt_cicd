package org.sopt.kakaopay.exception;

import org.sopt.kakaopay.common.dto.ErrorMessage;

public class NotFoundException extends BusinessException {
    public NotFoundException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
