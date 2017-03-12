package com.vnaskos.oopexpressioncalc.expressions;

/**
 * Binary expressions are those which has a left and a right part
 * 
 * @author Vasilis Naskos
 */
public abstract class BinaryExpression implements Expression {
    
    protected Expression operand1, operand2;
    protected Priority precedence;

    public BinaryExpression() {}

    public BinaryExpression(Expression operand1, Expression operand2) {
        this();
        this.operand1 = operand1;
        this.operand2 = operand2;
    }
    
    public void setOperand1(Expression operand1) {
        this.operand1 = operand1;
    }

    public void setOperand2(Expression operand2) {
        this.operand2 = operand2;
    }

    @Override
    public abstract double evaluate();

    public Priority getPrecedence() {
        return precedence;
    }
    
}
