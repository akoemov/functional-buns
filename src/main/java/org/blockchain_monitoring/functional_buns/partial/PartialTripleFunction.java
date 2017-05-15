package org.blockchain_monitoring.functional_buns.partial;

import org.blockchain_monitoring.functional_buns.api.TripleFunction;

import java.util.function.BiFunction;

/**
 * Created by Ruslan Kryukov on 14/04/2017.
 * Copyright IBM Corp. All Rights Reserved.
 */
public class PartialTripleFunction<IN1, IN2, IN3, OUT> implements BiFunction<IN2, IN3, OUT> {
    private TripleFunction<IN1, IN2, IN3, OUT> tripleFunction;
    private IN1 arg;

    public PartialTripleFunction(TripleFunction<IN1, IN2, IN3, OUT> function, IN1 arg) {
        this.tripleFunction = function;
        this.arg = arg;
    }

    public static <IN1, IN2, IN3, OUT> BiFunction<IN2, IN3, OUT> partial(TripleFunction<IN1, IN2, IN3, OUT> function, IN1 elem) {
        return new PartialTripleFunction<>(function, elem);
    }

    @Override
    public OUT apply(IN2 in2, IN3 in3) {
        return tripleFunction.accept(arg, in2, in3);
    }
}
