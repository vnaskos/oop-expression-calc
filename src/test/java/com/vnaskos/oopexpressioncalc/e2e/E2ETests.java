package com.vnaskos.oopexpressioncalc.e2e;

import com.vnaskos.oopexpressioncalc.expressions.ParenthesisExpression;
import com.vnaskos.oopexpressioncalc.processing.ExpressionParser;
import com.vnaskos.oopexpressioncalc.processing.Tokenizer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static com.vnaskos.oopexpressioncalc.processing.Tokenizer.getDefaultTokenizer;

public class E2ETests {

    @Test
    public void noExpressions_ShouldBeZero() throws Exception {
        double result = calculate("");
        Assertions.assertEquals(0, result);
    }

    @ParameterizedTest
    @CsvSource({
        "-20.5, -20.5",
        "-15, -15",
        "0, 0",
        "0.4, 0.4",
        "12, 12"
    })
    public void singleValue_ShouldValue(String candidate, double expected) throws Exception {
        double result = calculate(candidate);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
        "'20.5+20', 40.5",
        "'-20.5+20', -0.5",
        "'-20.5+20+0.5', 0",
        "'-20.5+20+0.5+123', 123",
    })
    public void addition_ShouldAddUpAllValues(String candidate, double expected) throws Exception {
        double result = calculate(candidate);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
        "'   0 -   0   ', 0",
        "'0-12', -12",
        "'12-0', 12",
        "'12-10', 2",
        "'-20.5-20', -40.5",
        "'-20.5+20+0.5', 0",
        "'-20.5-20-0.5-123', -164",
    })
    public void subtraction_ShouldSubtractAllValues(String candidate, double expected) throws Exception {
        double result = calculate(candidate);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
        "'0*0', 0",
        "'1*0', 0",
        "'0*1', 0",
        "'0.1*0', 0",
        "'0*0.1', 0",
        "'0*0.1*20*40*30', 0",
        "1*2, 2",
        "2*1, 2",
        "2*2, 4",
        "'-2*2', -4",
        "'-20.5*2*0.5*  123', -2521.5",
    })
    public void multiplication_ShouldMultiplyAllValues(String candidate, double expected) throws Exception {
        double result = calculate(candidate);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
        "'0*0', 0",
        "'1*0', 0",
        "'0*1', 0",
        "'0.1*0', 0",
        "'0*0.1', 0",
        "'0*0.1*20*40*30', 0",
        "1*2, 2",
        "2*1, 2",
        "2*2, 4",
        "'-2*2', -4",
        "'-20.5*2*0.5*  123', -2521.5",
    })
    public void division_ShouldDivideFromLeftToRight(String candidate, double expected) throws Exception {
        double result = calculate(candidate);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
        "'1^0', 1",
        "'1^1', 1",
        "'0^1', 0",
        "'1^2', 1",
        "'2^2', 4",
        "'2^3', 8",
        "'2.5^2', 6.25",
        "'-2.5^3', -15.625",
    })
    public void power_ShouldRaiseLeftPartToThePowerOfRightPart(String candidate, double expected) throws Exception {
        double result = calculate(candidate);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
        "'()', 0",
        "'(1)', 1",
        "'(-1)', -1",
        "'(1-1)', 0",
        "'(1.5-1)', 0.5",
        "'(1.5-1)-(2)', -1.5",
        "'(1.5-1)-(2+5+2)', -8.5",
        "'(1.5-1)-(2*3)', -5.5",
        "'(4*4)/(2*4)', 2",
        "'(4*4)/(2*4)/2', 1",
    })
    public void parenthesis_ShouldEvaluateAllParenthesis(String candidate, double expected) throws Exception {
        double result = calculate(candidate);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
        "'2*2-2*2', 0",
        "'2*2-2*3', -2",
        "'2*2/2-2*3', -4",
        "'2*2^3/2-2*3', 2",
        "'(2*2^(3*2/3)-2)*3', 18",
    })
    public void priority_ShouldPerformExpressionsWithMathematicalPriority(String candidate, double expected) throws Exception {
        double result = calculate(candidate);
        Assertions.assertEquals(expected, result);
    }

    private double calculate(String expression) throws Exception {
        Tokenizer tokenizer = getDefaultTokenizer();
        List<String> tokens = tokenizer.tokenize(expression);
        ExpressionParser parser = new ExpressionParser();
        ParenthesisExpression root = parser.parse(tokens);
        return root.evaluate();
    }
}
