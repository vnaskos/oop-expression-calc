package com.vnaskos.oopexpressioncalc.expressions;

/**
 * @author Vasilis Naskos
 */
public class NumericExpression implements Expression {

    private double value;

    public NumericExpression() {
        this.value = 0;
    }
    
    public NumericExpression(double value) {
        this.value = value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
    @Override
    public double evaluate() {
        return value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
    
}
