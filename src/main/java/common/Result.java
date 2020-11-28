package common;

import java.util.List;

public abstract class Result<T> {

    public static <T> Result<T> success(T value) {
        return new Success<T>(value);
    }

    public static <T> Result<T> failure(List<String> errorMessages) {
        return new Failure<T>(errorMessages);
    }

    public abstract T getValue();


    public static class Success<T> extends Result<T> {
        private final T t;

        Success(T t) {
            this.t = t;
        }
        public T getValue() {
            return this.t;
        }
    }


    public static class Failure<T> extends Result<T> {
        private final List<String> messages;

        Failure(List<String> messages) {
            this.messages = messages;
        }

        public T getValue() {
            throw new RuntimeException("common.Failure result contains no value");
        }
    }

}

