package com.vnaskos.oopexpressioncalc.processing;

import com.vnaskos.oopexpressioncalc.expressions.Expression;
import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Vasilis Naskos
 */
public class ExpressionFactory {
    
    public static Expression getExpression(String token) throws Exception {
        Map<String, String> patterns = Patterns.getPatternsWithNames();
        
        for(Map.Entry<String, String> pattern : patterns.entrySet()) {
            Pattern r = Pattern.compile(pattern.getValue());
            Matcher m = r.matcher(token);
            
            if(m.find()) {
                Class<?> klass = Class.forName(pattern.getKey());
                Constructor<?> ctor = klass.getConstructor();
                return (Expression) ctor.newInstance();
            }
        }
        
        throw new Exception("Not supported token");
    }
    
}
