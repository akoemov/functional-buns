package org.blockchain_monitoring.functional_buns.api;

/**
 * Created by Ruslan Kryukov on 13/04/2017.
 * Copyright IBM Corp. All Rights Reserved.
 */
@FunctionalInterface
public interface ThrowableBiConsumer<T, U> {
    void unsafeAccept(T o, U u) throws Exception;
}
