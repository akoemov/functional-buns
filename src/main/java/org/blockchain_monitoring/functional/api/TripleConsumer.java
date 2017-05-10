package org.blockchain_monitoring.functional.api;

/**
 * Created by Ruslan Kryukov on 13/04/2017.
 * Copyright IBM Corp. All Rights Reserved.
 */
@FunctionalInterface
public interface TripleConsumer<T, U, X> {
    void accept(T o, U u, X x);
}
