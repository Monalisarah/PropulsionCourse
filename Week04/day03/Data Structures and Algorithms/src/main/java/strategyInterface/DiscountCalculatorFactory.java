package strategyInterface;

import java.time.DayOfWeek;


public class DiscountCalculatorFactory {
	
	private static final DiscountCalculator weekend = new TenPercentDiscountCalculator();
	private static final DiscountCalculator weekday = new ZeroDiscountCalculator();
	
	public static DiscountCalculator getDiscountCalculatorFor(DayOfWeek dayOfWeek){
	
		if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY ) {
			return weekend;
		} 	
		return weekday;
		 
	}

}
