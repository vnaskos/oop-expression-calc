package com.vnaskos.oopexpressioncalc.processing;

import com.vnaskos.oopexpressioncalc.expressions.ParenthesisExpression;
import com.vnaskos.oopexpressioncalc.expressions.NumericExpression;
import com.vnaskos.oopexpressioncalc.expressions.BinaryExpression;
import com.vnaskos.oopexpressioncalc.expressions.CloseParenthesisExpression;
import com.vnaskos.oopexpressioncalc.expressions.Expression;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vasilis Naskos
 */
public class ExpressionParser {
    
    private final List<ParenthesisExpression> parentheses;
    
    public ExpressionParser() {
        parentheses = new ArrayList<>();
        parentheses.add(new ParenthesisExpression()); //Root
    }
    
    public ParenthesisExpression parse(List<String> tokens) throws Exception {
        while(!tokens.isEmpty()) {
            String token = tokens.remove(0);
            
            Expression expr = ExpressionFactory.getExpression(token);
            
            if(!parseExpression(expr, token)) {
                throw new Exception("Unknown expression " + token);
            }
        }
        
        return parentheses.get(0);
    }
    
    private boolean parseExpression(Expression expr, String token) {
        int lastParenthesis = parentheses.size() - 1;
        
        if (expr instanceof ParenthesisExpression) {
            parentheses.add((ParenthesisExpression) expr);
        } else if (expr instanceof CloseParenthesisExpression) {
            ParenthesisExpression paren = parentheses.remove(lastParenthesis);
            lastParenthesis = parentheses.size() - 1;
            parentheses.get(lastParenthesis).add(paren);
        } else if (expr instanceof BinaryExpression) {
            parentheses.get(lastParenthesis).add(expr);
        } else if (expr instanceof NumericExpression) {
            double value = Double.parseDouble(token);
            ((NumericExpression) expr).setValue(value);
            parentheses.get(lastParenthesis).add(expr);
        } else {
            return false;
        }
        
        return true;
    }
    
}
