package Enums;

import org.assertj.core.internal.Strings;

public class Product {

	private String name;
	private Color color;
	private Size size;
	private int price;
	
	public Product(String name, Color color, Size size, int price) {
		
		this.name = name;
		this.color = color;
		this.size = size;
		this.price = price;
		
	}


	public Size getSize() {
		return size;
	}

	public int getPrice() {
		return price;
	}
	
	
	
	
}
