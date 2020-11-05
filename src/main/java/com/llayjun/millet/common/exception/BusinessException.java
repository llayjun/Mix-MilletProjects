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

    public BusinessException(Integer code, String message){
        super(message);
        this.code = code;
    }
}
