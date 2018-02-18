package com.vnaskos.oopexpressioncalc.processing;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Vasilis Naskos
 */
public class Patterns {
    
    private static final Map<String, String> PATTERNS = new HashMap<>();
    
    private static void initPatterns() {
        String packageName = "com.vnaskos.oopexpressioncalc.expressions.";

        //Number
        PATTERNS.put(packageName+"NumericExpression", "\\d+(\\.\\d+)?");
        
        //Plus
        PATTERNS.put(packageName+"AddExpression", "\\+");

        //Minus
        PATTERNS.put(packageName+"SubtractExpression", "-");
        
        //Multiply
        PATTERNS.put(packageName+"MultiplyExpression", "\\*");
        
        //Divide
        PATTERNS.put(packageName+"DivideExpression", "/");
        
        //Power
        PATTERNS.put(packageName+"PowerExpression", "\\^");
        
        //Parenthesis
        PATTERNS.put(packageName+"ParenthesisExpression", "\\(");
        
        //Close Parenthesis
        PATTERNS.put(packageName+"CloseParenthesisExpression", "\\)");
    }
    
    public static Map<String, String> getPatternsWithNames() {
        if(PATTERNS.isEmpty()) {
            initPatterns();
        }
        
        return PATTERNS;
    }
    
    public static Collection<String> getPatterns() {
        if(PATTERNS.isEmpty()) {
            initPatterns();
        }
        
        return PATTERNS.values();
    }
    
}
