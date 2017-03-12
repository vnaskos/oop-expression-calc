package com.vnaskos.oopexpressioncalc.expressions;

/**
 * @author Vasilis Naskos
 */
public class DivideExpression extends BinaryExpression {

    public DivideExpression() {
        precedence = Priority.MEDIUM;
    }
    
    @Override
    public double evaluate() {
        return operand1.evaluate() / operand2.evaluate();
    }
    
}
