package common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.text.MessageFormat;

@Aspect
public class LoggerAspect {


    @Pointcut("execution(* *.handle(Command)) && args(command)")
    public void commandExecution(Command command) {

    }

    @Around(value = "commandExecution(command)", argNames = "jp,command")
    public Object handle(ProceedingJoinPoint jp, Command command) {
        displayBeforeAudit(command);
        Object result;
        try {
            result = jp.proceed();
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
        displayAfterAudit(command);
        return result;
    }

    private void displayAfterAudit(Command command) {
        String afterAudit = MessageFormat.format("After {0} is execute", nameOf(command));
        System.out.println(afterAudit);
    }

    private void displayBeforeAudit(Command command) {
        String beforeAudit = MessageFormat.format("Before {0} is execute", nameOf(command));
        System.out.println(beforeAudit);
    }

    private String nameOf(Command command) {
        return command.getClass().getName();
    }
}
