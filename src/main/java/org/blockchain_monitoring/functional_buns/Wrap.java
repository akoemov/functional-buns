package org.blockchain_monitoring.functional_buns;

import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.blockchain_monitoring.functional_buns.api.ThrowableBiConsumer;
import org.blockchain_monitoring.functional_buns.api.ThrowableBiFunction;
import org.blockchain_monitoring.functional_buns.api.ThrowableConsumer;
import org.blockchain_monitoring.functional_buns.api.ThrowableFunction;
import org.blockchain_monitoring.functional_buns.api.ThrowableThConsumer;
import org.blockchain_monitoring.functional_buns.api.TripleConsumer;
import org.blockchain_monitoring.functional_buns.api.VoidAction;
import org.blockchain_monitoring.functional_buns.exception.LambdaException;

/**
 *  Класс для предоставления полезных функций при использовании Java-Stream
 */
public class Wrap {
    /**
     * Безопасный вызов функции, которая выбрасывает проверяемое исключение,
     * При исключении будет произведен вывод стектрейса
     * @param func целевая функция
     * @param o аргумент функции
     * @param <T> тип входных данных
     * @param <R> тип выходных даных
     * @return Optional результат выполнения
     */
    public static <T, R> Optional<R> safeCallF(ThrowableFunction<T, R> func, T o) {
        try {
            return Optional.ofNullable(func.unsafeApply(o));
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    /**
     * Безопасный вызов функции, которая выбрасывает проверяемое исключение,
     * При исключении будет произведен вывод стектрейса
     * @param func целевая функция
     * @param o аргумент функции
     * @param <T> тип входных данных
     * @param <R> тип выходных даных
     * @param errorMessage - сообщение об ошибке в случае выброса исключения
     * @return Optional результат выполнения
     */
    public static <T, R> Optional<R> safeCallF(ThrowableFunction<T, R> func, T o, Supplier<String> errorMessage) {
        try {
            return Optional.ofNullable(func.unsafeApply(o));
        } catch (Exception e) {
            throw new LambdaException(errorMessage.get(), e.getCause());
        }
    }

    /**
     * Безопасный вызов функции, которая выбрасывает проверяемое исключение,
     * При исключении будет произведен вывод стектрейса
     * @param func целевая функция
     * @param o аргумент функции
     * @param u аргумент функции
     * @param <T> тип первого параметра
     * @param <U> тип второго параметра
     * @param <R> тип выходных данных
     * @return Optional результат выполнения
     */
    public static <T, U, R> Optional<R> safeCallF(ThrowableBiFunction<T, U, R> func, T o, U u) {
        try {
            return Optional.ofNullable(func.unsafeApply(o, u));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    /**
     * Безопасный вызов функции, которая выбрасывает проверяемое исключение,
     * При исключении будет произведен вывод стектрейса
     * @param func целевая функция
     * @param o аргумент функции
     * @param u аргумент функции
     * @param <T> тип первого параметра
     * @param <U> тип второго параметра
     * @param <R> тип выходных данных
     * @param errorMessage - сообщение об ошибке в случае выброса исключения
     * @return результат выполнения
     */
    public static <T, U, R> Optional<R> safeCallF(ThrowableBiFunction<T, U, R> func, T o, U u, Supplier<String> errorMessage) {
        try {
            return Optional.ofNullable(func.unsafeApply(o, u));
        } catch (Exception e) {
            throw new LambdaException(errorMessage.get(), e.getCause());
        }
    }

    /**
     * Безопасный вызов Consumer-like функций
     * @param func - Consumer
     * @param o - аргумент функции
     * @param <T> тип входных данных
     */
    public static <T> void safeCallC(ThrowableConsumer<T> func, T o) {
        try {
            func.unsafeAccept(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Безопасный вызов Consumer-like функций
     * @param func - Consumer
     * @param o - аргумент функции
     * @param errorMessage - сообщение об ошибке в случае выброса исключения
     * @param <T> тип входных данных
     */
    public static <T> void safeCallC(ThrowableConsumer<T> func, T o, Supplier<String> errorMessage) {
        try {
            func.unsafeAccept(o);
        } catch (Exception e) {
            throw new LambdaException(errorMessage.get(), e.getCause());
        }
    }

    /**
     * Безопасный вызов Consumer-like функций
     * @param func - Consumer
     * @param o - аргумент функции
     * @param <T> тип входных данных
     */
    public static <T, U> void safeCallC(ThrowableBiConsumer<T, U> func, T o, U u) {
        try {
            func.unsafeAccept(o, u);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Безопасный вызов Consumer-like функций
     * @param func - Consumer
     * @param o - аргумент функции
     * @param errorMessage - сообщение об ошибке в случае выброса исключения
     * @param <T> тип входных данных
     */
    public static <T, U> void safeCallC(ThrowableBiConsumer<T, U> func, T o, U u, Supplier<String> errorMessage) {
        try {
            func.unsafeAccept(o, u);
        } catch (Exception e) {
            throw new LambdaException(errorMessage.get(), e.getCause());
        }
    }

    /**
     * Безопасный вызов Consumer-like функций
     * @param func - Consumer
     * @param o - аргумент функции
     * @param <T> тип входных данных
     */
    public static <T, U, R> void safeCallC(ThrowableThConsumer<T, U, R> func, T o, U u, R r) {
        try {
            func.unsafeAccept(o, u, r);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Безопасный вызов Consumer-like функций.
     * @param func - Consumer
     * @param o - аргумент функции
     * @param errorMessage - сообщение об ошибке в случае выброса исключения
     * @param <T> тип входных данных
     */
    public static <T, U, R> void safeCallC(ThrowableThConsumer<T, U, R> func, T o, U u, R r, Supplier<String> errorMessage) {
        try {
            func.unsafeAccept(o, u, r);
        } catch (Exception e) {
            throw new LambdaException(errorMessage.get(), e.getCause());
        }
    }

    /**
     * Функция-преобразователь для функций, которые выбрасывают проверямые исключения, в безопасные функции,
     * возвращающие опциональное значение в случае ошибки.
     * @param func - целевая функция
     * @param <T> - тип входных данных
     * @param <R> - тип выходных данных
     * @return - безопасная функция
     */
    public static <T, R> Function<T, Optional<R>> safeFunc(ThrowableFunction<T, R> func) {
        return (x) -> {
            try {
                return Optional.ofNullable(func.unsafeApply(x));

            } catch (Exception e) {
                e.printStackTrace();
                return Optional.empty();
            }
        };
    }

    /**
     * Функция-преобразователь для функций, которые выбрасывают проверямые исключения, в безопасные функции,
     * возвращающие опциональное значение в случае ошибки.
     * @param func - целевая функция
     * @param <T> - тип входных данных
     * @param <R> - тип выходных данных
     * @param errorMessage - сообщение об ошибке в случае выброса исключения
     * @return - безопасная функция
     */
    public static <T, R> Function<T, Optional<R>> safeFunc(ThrowableFunction<T, R> func, Supplier<String> errorMessage) {
        return (x) -> {
            try {
                return Optional.ofNullable(func.unsafeApply(x));

            } catch (Exception e) {
                throw new LambdaException(errorMessage.get(), e.getCause());
            }
        };
    }

    /**
     * Функция-преобразователь для функций, которые выбрасывают проверямые исключения, в безопасные функции,
     * возвращающие опциональное значение в случае ошибки.
     * @param func - целевая функция
     * @param <T> - тип входных данных
     * @param <U> - тип входных данных
     * @param <R> - тип выходных данных
     * @return - безопасная функция
     */
    public static <T, U, R> BiFunction<T, U, Optional<R>> safeBiFunc(ThrowableBiFunction<T, U, R> func) {
        return (x, y) -> {
            try {
                return Optional.ofNullable(func.unsafeApply(x, y));

            } catch (Exception e) {
                e.printStackTrace();
                return Optional.empty();
            }
        };
    }

    /**
     * Функция-преобразователь для функций, которые выбрасывают проверямые исключения, в безопасные функции,
     * возвращающие опциональное значение в случае ошибки.
     * @param func - целевая функция
     * @param <T> - тип входных данных
     * @param <U> - тип входных данных
     * @param <R> - тип выходных данных
     * @return - безопасная функция
     */
    public static <T, U, R> BiFunction<T, U, Optional<R>> safeBiFunc(ThrowableBiFunction<T, U, R> func, Supplier<String> errorMessage) {
        return (x, y) -> {
            try {
                return Optional.ofNullable(func.unsafeApply(x, y));

            } catch (Exception e) {
                throw new LambdaException(errorMessage.get(), e.getCause());
            }
        };
    }

    /**
     * Функция-преобразователь для Consumer-like функций в безопасные функцмм
     * @param func - входная функция
     * @param <T> - тип входных данных
     * @return - безопасная функция
     */
    public static <T> Consumer<T> safeConsumer(ThrowableConsumer<T> func) {
        return (x) -> {
            try {
                func.unsafeAccept(x);

            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }

    /**
     * Функция-преобразователь для Consumer-like функций в безопасные функцмм
     * @param func - входная функция
     * @param <T> - тип входных данных
     * @return - безопасная функция
     */
    public static <T> Consumer<T> safeConsumer(ThrowableConsumer<T> func, Supplier<String> errorMessage) {
        return (x) -> {
            try {
                func.unsafeAccept(x);

            } catch (Exception e) {
                throw new LambdaException(errorMessage.get(), e.getCause());
            }
        };
    }

    /**
     * Функция-преобразователь для Consumer-like функций в безопасные функцмм
     * @param func - входная функция
     * @param <T> - тип входных данных
     * @return - безопасная функция
     */
    public static <T, U> BiConsumer<T, U> safeBiConsumer(ThrowableBiConsumer<T, U> func) {
        return (x, y) -> {
            try {
                func.unsafeAccept(x, y);

            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }

    /**
     * Функция-преобразователь для Consumer-like функций в безопасные функцмм
     * @param func - входная функция
     * @param <T> - тип входных данных
     * @return - безопасная функция
     */
    public static <T, U> BiConsumer<T, U> safeBiConsumer(ThrowableBiConsumer<T, U> func, Supplier<String> errorMessage) {
        return (x, y) -> {
            try {
                func.unsafeAccept(x, y);

            } catch (Exception e) {
                throw new LambdaException(errorMessage.get(), e.getCause());
            }
        };
    }

    /**
     * Функция-преобразователь для Consumer-like функций в безопасные функцмм
     * @param func - входная функция
     * @param <T> - тип входных данных
     * @return - безопасная функция
     */
    public static <T, U, R> TripleConsumer<T, U, R> safeThConsumer(ThrowableThConsumer<T, U, R> func) {
        return (x, y, z) -> {
            try {
                func.unsafeAccept(x, y, z);

            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }

    /**
     * Функция-преобразователь для Consumer-like функций в безопасные функцмм
     * @param func - входная функция
     * @param <T> - тип входных данных
     * @return - безопасная функция
     */
    public static <T, U, R> TripleConsumer<T, U, R> safeThConsumer(ThrowableThConsumer<T, U, R> func, Supplier<String> errorMessage) {
        return (x, y, z) -> {
            try {
                func.unsafeAccept(x, y, z);

            } catch (Exception e) {
                throw new LambdaException(errorMessage.get(), e.getCause());
            }
        };
    }

    /**
     * Преобразование Optional в "монаду"
     * @param opt - опциональный объект
     * @param <T> - тип хранимого в монаде значения
     * @return - Стрим с данными
     */
    public static <T> Stream<T> streamOpt(Optional<T> opt) {
        return opt.map(Stream::of).orElseGet(Stream::empty);
    }

    /**
     * Функция-преобразователь типов объекта с возможностью вывода данных об ошибке внутри lambda-выражения
     * @param o - объект для преобразования
     * @param errorMessage - сообщение об ошибки преобразования
     * @param <T> - тип результирующего значения
     * @return - преобразованное значение
     */
    public static <T> T castOrThrow(Supplier<String> errorMessage, Object o) {
        try {
            return (T)o;
        } catch (ClassCastException e) {
            throw new LambdaException(errorMessage.get(), e.getCause());
        }
    }

    /**
     * Обработка ошибок для лямбда-выражений
     * @param action - Выражение, котороре необходимо обернуть в try-catch
     * @param errorHandler - получатель-обработчик возможного исключения
     */
    public static void handleErrorC(Consumer<Exception> errorHandler, VoidAction action) {
        try {
            action.act();
        } catch (Exception e) {
            errorHandler.accept(e);
        }
    }

    /**
     * Обработка ошибок для лямбда-выражений
     * @param supplier - Выражение, отдающее некоторое значение, которое может бросить исключение
     * @param errorHandler - получатель-обработчик возможного исключения
     * @param <R> - тип возвращаемого значения
     * @return возвращает результат работы выражения supplier или же ответ от обработчика ошибок
     */
    public static <R> R handleErrorF(Function<Exception, R> errorHandler, Supplier<R> supplier) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return errorHandler.apply(e);
        }
    }

    /**
     * Обработка ошибок для лямбда-выражений
     * @param action - Выражение, котороре необходимо обернуть в try-catch
     * @param errorHandler получатель-обработчик возможного исключения, отдающий ответ в случае ошибки
     * @param goodSupplier - положительный результат работы action-выражения
     * @param <R> - тип результата
     * @return - возвращает некоторый ответ, характеризующий результат работы action
     */
    public static <R> R handleErrAndGood(Function<Exception, R> errorHandler, Supplier<R> goodSupplier, VoidAction action) {
        try {
            action.act();
            return goodSupplier.get();
        } catch (Exception e) {
            return errorHandler.apply(e);
        }
    }

    public static Supplier<RuntimeException> withMessage(String message) {
        return () -> new LambdaException(message);
    }


    public static<T> Collector<T,?,Optional<T>> singleOrEmpty() {
        return Collectors.collectingAndThen(
                Collectors.toList(),
                ls -> ls.size() > 0
                        ? Optional.ofNullable(ls.get(0))
                        : Optional.empty()
        );
    }

    public static void doWell() {
        System.out.println("now well");
    }
}
