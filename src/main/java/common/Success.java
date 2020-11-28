package common;

import common.Result;

public class Success<T> extends Result<T> {
    private final T t;

    public Success(T t) {
        this.t = t;
    }
    public T getValue() {
        return this.t;
    }
}
