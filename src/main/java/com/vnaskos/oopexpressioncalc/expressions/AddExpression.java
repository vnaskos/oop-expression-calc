package com.vnaskos.oopexpressioncalc.expressions;

/**
 * @author Vasilis Naskos
 */
public class AddExpression extends BinaryExpression {

    public AddExpression() {
        precedence = Priority.LOW;
    }
    
    @Override
    public double evaluate() {
        return operand1.evaluate() + operand2.evaluate();
    }
    
}
