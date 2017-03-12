package com.vnaskos.oopexpressioncalc;

import com.vnaskos.oopexpressioncalc.processing.Tokenizer;
import com.vnaskos.oopexpressioncalc.processing.ExpressionParser;
import static com.vnaskos.oopexpressioncalc.processing.Tokenizer.getDefaultTokenizer;
import com.vnaskos.oopexpressioncalc.expressions.ParenthesisExpression;
import java.util.List;

/**
 * @author Vasilis Naskos
 */
public class Calculator {
    
    public static void main(String[] args) throws Exception {
        String mathExpression = "(1+2+3)+5^2-10*(2/1)";
        Tokenizer tokenizer = getDefaultTokenizer();
        List<String> tokens = tokenizer.tokenize(mathExpression);
        ExpressionParser parser = new ExpressionParser();
        ParenthesisExpression root = parser.parse(tokens);
        System.out.println(root.evaluate());
    }
    
}
