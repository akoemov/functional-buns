package org.blockchain_monitoring.functional_buns.partial;


import org.blockchain_monitoring.functional_buns.api.TripleConsumer;
import org.blockchain_monitoring.functional_buns.api.TripleFunction;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by Ruslan Kryukov on 14/04/2017.
 * Copyright IBM Corp. All Rights Reserved.
 */
public class Partial {
    public static <IN1, IN2, IN3> BiConsumer<IN2, IN3> partial(TripleConsumer<IN1, IN2, IN3> function, IN1 arg) {
        return PartialTripleConsumer.partial(function, arg);
    }

    public static <IN1, IN2, IN3, OUT> BiFunction<IN2, IN3, OUT> partial(TripleFunction<IN1, IN2, IN3, OUT> function, IN1 arg) {
        return PartialTripleFunction.partial(function, arg);
    }

    public static <IN1, IN2> Consumer<IN2> partial(BiConsumer<IN1, IN2> function, IN1 arg) {
        return PartialBiConsumer.partial(function, arg);
    }

    public static <IN1, IN2, OUT> Function<IN2, OUT> partial(BiFunction<IN1, IN2, OUT> function, IN1 arg)
    {
        return PartialBiFunction.partial(function, arg);
    }
}
