package org.blockchain_monitoring.functional.api;

/**
 * Created by Ruslan Kryukov on 14/04/2017.
 * Copyright IBM Corp. All Rights Reserved.
 */

@FunctionalInterface
public interface TripleFunction<T, U, X, R> {
    R accept(T o, U u, X x);
}
