package common;

public interface CommandHandler<T extends Command> {
    Result handle(T t);
}


