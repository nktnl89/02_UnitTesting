import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CalculateTest {

    private static Calculator calculator;

    @BeforeAll
    static void initCalculator() {
        calculator = new Calculator();
    }

    @Test
    void clearInputString() {
        assertAll("clear",
                () -> assertThat(calculator.clearInputString("  _&5fghfg+5.,-#@ 1"), is("5+5-1")),
                () -> assertThat(calculator.clearInputString("+jf-  */"), is("+-*/")));
    }

    @ParameterizedTest
    @CsvSource({"3+2, 5.0", "1+_)2+(2, 5.0", "5+5*5+5+5, 80.0", "5*1+4+1-3*12/2, -8.0", "5/0, Infinity"})
    void calculateExpressions(String argument, String result) {
        System.out.println(calculator.getResult(argument));
        assertThat(calculator.getResult(argument), is(result));

    }

    @ParameterizedTest
    @ValueSource(chars = {'+', '-', '/', '*'})
    void getExceptionInvalidOperation(char operation) {
        assertThat(calculator.isOperation(operation), is(true));
    }

    @ParameterizedTest
    @ValueSource(chars = {'/', '*'})
    void isOperationPriorityDivMult(char operation) {
        assertThat(calculator.isOperation(operation), is(true));
    }

    @AfterAll
    static void setNullCalculator() {
        calculator = null;
    }
}
