import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InvalidTest {

    private static Calculator calculator;

    @BeforeAll
    @Disabled
    static void initCalculator() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-3+2", "1++2+2", "5/+5", "-8*0"})
    @Disabled
    void calculateExpressions(String argument) {
        System.out.println(calculator.getResult(argument));
        assertThat(calculator.getResult(argument), is("Недопустимая операция"));

    }

    @ParameterizedTest
    @ValueSource(chars = {')', '_', '?', '|', '('})
    @Disabled
    void getExceptionInvalidOperation(char operation) {
        Throwable exception = assertThrows(Exception.class, () -> {
            calculator.calculateOperation(5, 4, operation);
        });
        assertThat(exception.getMessage(), is("Недопустимая операция"));
    }

    @AfterAll
    static void setNullCalculator() {
        calculator = null;
    }
}
