package com.vnaskos.oopexpressioncalc.processing;

import com.vnaskos.oopexpressioncalc.expressions.ParenthesisExpression;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Vasilis Naskos
 */
public class Tokenizer {
    
    private final Collection<String> patterns;
    
    public Tokenizer(Collection<String> patterns) {
        this.patterns = patterns;
    }
    
    public static Tokenizer getDefaultTokenizer() {
        Collection<String> patterns = Patterns.getPatterns();
        
        return new Tokenizer(patterns);
    }
    
    public List<String> tokenize(String line) {
        String pattern = String.join("|", patterns);
        
        List<String> tokens = new ArrayList<>();
        
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(line);
        while(m.find()) {
            String token = m.group();
            tokens.add(token);
        }
        
        return tokens;
    }
    
}
