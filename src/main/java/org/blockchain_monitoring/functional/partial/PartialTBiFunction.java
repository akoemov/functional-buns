package org.blockchain_monitoring.functional.partial;

import org.blockchain_monitoring.functional.api.ThrowableBiFunction;
import org.blockchain_monitoring.functional.api.ThrowableFunction;

/**
 * Created by Ruslan Kryukov on 14/04/2017.
 * Copyright IBM Corp. All Rights Reserved.
 */
public class PartialTBiFunction<IN1, IN2, OUT> implements ThrowableFunction<IN2, OUT> {
    private ThrowableBiFunction<IN1, IN2, OUT> unsafeFunction;
    private IN1 arg;


    public PartialTBiFunction(ThrowableBiFunction<IN1, IN2, OUT> function, IN1 arg) {
        this.unsafeFunction = function;
        this.arg = arg;
    }

    public static <IN1, IN2, OUT> ThrowableFunction<IN2, OUT> partial(ThrowableBiFunction<IN1, IN2, OUT> function, IN1 elem) {
        return new PartialTBiFunction<>(function, elem);
    }

    public OUT unsafeApply(IN2 arg2) throws Exception {
        return unsafeFunction.unsafeApply(arg, arg2);
    }
}
