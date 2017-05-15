package org.blockchain_monitoring.functional_buns.api;

/**
 * Created by Ruslan Kryukov on 13/04/2017.
 * Copyright IBM Corp. All Rights Reserved.
 */
@FunctionalInterface
public interface ThrowableThConsumer<T, U, R> {
    void unsafeAccept(T o, U u, R r) throws Exception;
}
