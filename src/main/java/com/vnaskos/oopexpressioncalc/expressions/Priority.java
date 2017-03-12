package com.vnaskos.oopexpressioncalc.expressions;

/**
 *
 * @author Vasilis Naskos
 */
public enum Priority {
    
    HIGHEST(5), HIGH(4), MEDIUM(3), LOW(2), LOWEST(1);
    
    public int value;

    private Priority(int value) {
        this.value = value;
    }
    
}
