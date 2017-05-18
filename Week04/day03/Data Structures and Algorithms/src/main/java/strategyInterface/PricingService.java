package strategyInterface;

import java.time.DayOfWeek;

public class PricingService {

	private DayOfWeek dayOfWeek;


	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public double calculatePrice(double quantity, double amount){
		double baseprice = quantity * amount;
		DiscountCalculator calculatorBasedOnDay =  DiscountCalculatorFactory.getDiscountCalculatorFor(dayOfWeek);
		return calculatorBasedOnDay.calculateDiscountedPrice(baseprice);
		
	}
	

}
