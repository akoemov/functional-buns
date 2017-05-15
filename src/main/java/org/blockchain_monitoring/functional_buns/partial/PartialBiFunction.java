package org.blockchain_monitoring.functional_buns.partial;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by Ruslan Kryukov on 14/04/2017.
 * Copyright IBM Corp. All Rights Reserved.
 */
public class PartialBiFunction<IN1, IN2, OUT> implements Function<IN2, OUT> {
    private BiFunction<IN1, IN2, OUT> function;
    private IN1 arg;

    public PartialBiFunction(BiFunction<IN1, IN2, OUT> function, IN1 arg) {
        this.function = function;
        this.arg = arg;
    }

    public static <IN1, IN2, IN3> Function<IN2, IN3> partial(BiFunction<IN1, IN2, IN3> function, IN1 elem) {
        return new PartialBiFunction<>(function, elem);
    }

    public OUT apply(IN2 arg2) {
        return function.apply(arg, arg2);
    }
}
