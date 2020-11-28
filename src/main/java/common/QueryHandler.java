package common;

public interface QueryHandler<V, T extends Query<V>> {
    Result<V> handle(T t);
}

