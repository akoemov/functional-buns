package org.blockchain_monitoring.functional.api;


/**
 * Created by Ruslan Kryukov on 13/04/2017.
 * Copyright IBM Corp. All Rights Reserved.
 */
@FunctionalInterface
public interface ThrowableBiFunction<T, U, R> {
    R unsafeApply(T t, U u) throws Exception;
}
