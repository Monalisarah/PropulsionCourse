package exercises;

public class Calculator {
	
	double result = 0;

	public double getResult() {  // public void getResult() {
		// system.out.println(result);
		return result;
		
	}
	public void add(double x){
		this.result = result + x;
	}
	
	public void subtract(double x){
		this.result = result - x;
	}
	
	public void multiply(double x){
		this.result = result *x;
	}
	
	public void divide(double x){
		this.result = result/x;
	}
	
	public void clear(){
		this.result = 0;
	}
	

//	public static void main(String[] args) {
//			
//	Calculator myCalculator = new Calculator ();
//		
//	System.out.println(MyCalculator.add(2.5));	
//	}


}
