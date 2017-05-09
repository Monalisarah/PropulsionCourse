package exercises;

import java.util.Scanner;


public class BmiCalculator {
	
	public static void main(String[] args) {
		System.out.println("Let's calculate your BMI (kg/m^2");
		System.out.println();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("What is your weight in kilograms?");
		double weight = scanner.nextDouble();
		scanner.nextLine();
		
		System.out.println("you typed: " + weight);
	}

}
