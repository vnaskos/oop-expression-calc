package com.vnaskos.oopexpressioncalc.expressions;

public abstract class UnaryExpression implements Expression {

    protected Expression operand;

    public UnaryExpression() {}

    public UnaryExpression(Expression operand) {
        this();
        this.operand = operand;
    }

    @Override
    public abstract double evaluate();
}
