package strategyInterface;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.time.DayOfWeek;

import org.junit.Test;

public class DicountCalculatorFactoryTest {

	@Test
	public void test() {
		DiscountCalculator weekend = DiscountCalculatorFactory.getDiscountCalculatorFor(DayOfWeek.SATURDAY);
		assertEquals(9, weekend.calculateDiscountedPrice(10), 0);
		assertThat(weekend).isInstanceOf(TenPercentDiscountCalculator.class);
	
		
	}

}