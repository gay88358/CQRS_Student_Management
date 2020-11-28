import common.Result;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ResultTest {

    @Test
    public void create_success_result() {
        String value = "success";
        Result<String> result = Result.success(value);
        assertEquals(value, result.getValue());
    }

    @Test
    public void create_failure_result() {
        List<String> errorMessages = Arrays.asList("common.Failure");
        Result<String> result = Result.failure(errorMessages);
        try {
            result.getValue();
        } catch (RuntimeException e) {
            assertEquals("common.Failure result contains no value", e.getMessage());
        }
    }
}