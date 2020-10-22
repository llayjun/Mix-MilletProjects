package com.llayjun.millet.common.exception;

import lombok.Data;

/**
 * Description(自定义异常)
 * author: Gao xueyong
 * Create at: 2020/4/12 6:08 下午
 */
@Data
public class BusinessException extends RuntimeException {
    private Integer code;

    private String message;

    public BusinessException(BusinessExceptionEnum businessExceptionEnum) {
        this.code = businessExceptionEnum.code();
        this.message = businessExceptionEnum.message();
    }
}
