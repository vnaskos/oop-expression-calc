package com.vnaskos.oopexpressioncalc.expressions;

/**
 * @author Vasilis Naskos
 */
public class MultiplyExpression extends BinaryExpression {

    public MultiplyExpression() {
        precedence = Priority.MEDIUM;
    }
    
    @Override
    public double evaluate() {
        return operand1.evaluate() * operand2.evaluate();
    }
    
}
