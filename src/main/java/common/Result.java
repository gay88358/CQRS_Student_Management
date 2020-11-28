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
}

