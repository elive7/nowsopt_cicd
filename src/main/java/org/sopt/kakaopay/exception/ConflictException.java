package org.sopt.kakaopay.exception;

import org.sopt.kakaopay.common.dto.ErrorMessage;

public class ConflictException extends BusinessException{

    public ConflictException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}


