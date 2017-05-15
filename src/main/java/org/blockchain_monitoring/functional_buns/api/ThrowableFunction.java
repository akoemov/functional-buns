package org.blockchain_monitoring.functional_buns.api;

/**
 * Created by Ruslan Kryukov on 13/04/2017.
 * Copyright IBM Corp. All Rights Reserved.
 */
@FunctionalInterface
public interface ThrowableFunction<T, R>  {
    R unsafeApply(T o) throws Exception;
}
