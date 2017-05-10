package org.blockchain_monitoring.functional.partial;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Created by Ruslan Kryukov on 14/04/2017.
 * Copyright IBM Corp. All Rights Reserved.
 */
public class PartialBiConsumer<IN1, IN2> implements Consumer<IN2> {
    private BiConsumer<IN1, IN2> biConsumer;
    private IN1 arg;

    public PartialBiConsumer(BiConsumer<IN1, IN2> function, IN1 arg) {
        this.biConsumer = function;
        this.arg = arg;
    }

    public static <IN1, IN2> Consumer<IN2> partial(BiConsumer<IN1, IN2> function, IN1 elem) {
        return new PartialBiConsumer<>(function, elem);
    }

    @Override
    public void accept(IN2 in2) {
        biConsumer.accept(arg, in2);
    }
}
