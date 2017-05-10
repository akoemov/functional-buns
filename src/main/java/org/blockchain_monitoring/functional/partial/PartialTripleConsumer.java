package org.blockchain_monitoring.functional.partial;

import org.blockchain_monitoring.functional.api.TripleConsumer;

import java.util.function.BiConsumer;

/**
 * Created by Ruslan Kryukov on 14/04/2017.
 * Copyright IBM Corp. All Rights Reserved.
 */
public class PartialTripleConsumer<IN1, IN2, IN3> implements BiConsumer<IN2, IN3> {
    private TripleConsumer<IN1, IN2, IN3> tripleConsumer;
    private IN1 arg;

    public PartialTripleConsumer(TripleConsumer<IN1, IN2, IN3> function, IN1 arg) {
        this.tripleConsumer = function;
        this.arg = arg;
    }

    public static <IN1, IN2, OUT> BiConsumer<IN2, OUT> partial(TripleConsumer<IN1, IN2, OUT> function, IN1 elem) {
        return new PartialTripleConsumer<>(function, elem);
    }

    @Override
    public void accept(IN2 in2, IN3 in3) {
        tripleConsumer.accept(arg, in2, in3);
    }
}
