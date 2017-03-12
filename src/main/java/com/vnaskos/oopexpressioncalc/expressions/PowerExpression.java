package com.vnaskos.oopexpressioncalc.expressions;

/**
 * @author Vasilis Naskos
 */
public class PowerExpression extends BinaryExpression {

    public PowerExpression() {
        precedence = Priority.HIGHEST;
    }
    
    @Override
    public double evaluate() {
        return Math.pow(operand1.evaluate(), operand2.evaluate());
    }
    
}
