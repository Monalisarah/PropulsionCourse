package Enums;

public class PriceCalculator {

	// public static  double calculatePrice(Product product) {
	 double calculatePrice(Product product) {
		return product.getPrice() * (1+product.getSize().getSurchargePercentage());
	}
}
