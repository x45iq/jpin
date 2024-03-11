package com.purplerat.jpin;

public class NotSupportedFormatException extends RuntimeException{
    public NotSupportedFormatException() {
    }

    public NotSupportedFormatException(String message) {
        super(message);
    }

    public NotSupportedFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotSupportedFormatException(Throwable cause) {
        super(cause);
    }

    public NotSupportedFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
