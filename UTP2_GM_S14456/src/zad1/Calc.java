/**
 *
 *  @author Grzechnik Mariusz S14456
 *
 */

package zad1;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Calc {

	public String doCalc(String string) {
	
		Map<String, BiFunction<BigDecimal, BigDecimal, BigDecimal>> operations;

        operations = new HashMap<>();
        
        operations.put("+", BigDecimal::add);
        operations.put("-", BigDecimal::subtract);
        operations.put("/", BigDecimal::divide);
        operations.put("*", BigDecimal::multiply);
        
        MathContext precision = new MathContext(20);
        String[] args = string.split("\\s");
        BigDecimal bd;
        BigDecimal a = new BigDecimal(args[0].replace(',', '.'));
        BigDecimal b = new BigDecimal(args[2].replace(',', '.'));
        BiFunction<BigDecimal, BigDecimal, BigDecimal> operator = operations.get(args[1]);
        
        try {
            bd = operator.apply(a, b);
        } catch (ArithmeticException e){
            bd = a.divide(b, precision).setScale(19, RoundingMode.FLOOR);
        };
        
        return bd.toString();
        

	}
	
}  
