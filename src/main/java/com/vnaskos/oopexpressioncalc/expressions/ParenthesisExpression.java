package com.vnaskos.oopexpressioncalc.expressions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vasilis Naskos
 */
public class ParenthesisExpression implements Expression {

    protected final List<Expression> expressions;

    public ParenthesisExpression() {
        expressions = new ArrayList<>();
    }

    public ParenthesisExpression(List<Expression> expressions) {
        this.expressions = expressions;
    }
    
    public void add(Expression expr) {
        expressions.add(expr);
    }
    
    public void remove(Expression expr) {
        expressions.remove(expr);
    }
    
    @Override
    public double evaluate() {
        int precedence = Priority.HIGHEST.value;
        
        while(precedence > Priority.LOWEST.value) {
            processEpression(precedence--);
        }
        
        return expressions.get(0).evaluate();
    }
    
    protected void processEpression(int precedence) {
        int i = 0;
        
        while(i < expressions.size()) {
            Expression expr = expressions.get(i);
            
            if(expr instanceof BinaryExpression) {
                BinaryExpression bExpr = (BinaryExpression) expr;
                
                if(precedence == bExpr.getPrecedence().value) {
                    bExpr.setOperand2(expressions.remove(i+1));

                    if(i == 0) {
                        bExpr.setOperand1(new NumericExpression(0));
                    } else {
                        bExpr.setOperand1(expressions.remove(i - 1));
                        i--;
                    }
                }
            } else if(expr instanceof UnaryExpression) {
                UnaryExpression uExpr = (UnaryExpression) expr;

                uExpr.evaluate();
            }
            
            i++;
        }
    }
    
}
