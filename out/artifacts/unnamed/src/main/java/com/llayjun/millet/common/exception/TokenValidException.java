package com.llayjun.millet.common.exception;

public class TokenValidException extends RuntimeException{

    private Integer code;

    public TokenValidException(Integer code, String message){
        super(message);
        this.code = code;
    }

}
