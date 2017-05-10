package org.blockchain_monitoring.functional.exception;

/**
 * Created by Ruslan Kryukov on 13/04/2017.
 * Copyright IBM Corp. All Rights Reserved.
 */
public class LambdaException extends RuntimeException {
    public LambdaException(String message) {
        super(message);
    }

    public LambdaException(String message, Throwable cause) {
        super(message, cause);
    }
}
