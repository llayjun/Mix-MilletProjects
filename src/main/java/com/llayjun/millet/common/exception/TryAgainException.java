package com.llayjun.millet.common.exception;

/**
 * @author sjw
 * @date 2019/8/2
 */
public class TryAgainException extends RuntimeException {

    public TryAgainException() {
        super();
    }

    public TryAgainException(String message) {
        super(message);
    }

    public TryAgainException(String message, Throwable cause) {
        super(message, cause);
    }

    public TryAgainException(Throwable cause) {
        super(cause);
    }

    protected TryAgainException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
