package com.vnaskos.oopexpressioncalc.expressions;

/**
 * @author Vasilis Naskos
 */
public class SubtractExpression extends BinaryExpression {

    public SubtractExpression() {
        precedence = Priority.LOW;
    }
    
    @Override
    public double evaluate() {
        return operand1.evaluate() - operand2.evaluate();
    }
    
}
