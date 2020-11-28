package common;

import common.Result;

import java.util.List;

public class Failure<T> extends Result<T> {
    private final List<String> messages;

    Failure(List<String> messages) {
        this.messages = messages;
    }

    public T getValue() {
        throw new RuntimeException("common.Failure result contains no value");
    }
}
