
public class EvenOrOdd {
	
	public static void print(String... names){	
			System.out.println("-------------");
			for (String name : names) {
				System.out.println(name);
			}		
	}

	public static boolean isEven(int num){
		if (num % 2 == 0){
			return true;
		}
		return false;
		
	}
//	public static void main(string[] args){
	public static void main(String... args) {	
		EvenOrOdd evenOrOdd = new EvenOrOdd();
		int num= 10;
		System.out.println( num + "isEven? " + evenOrOdd.isEven(num));
		
		print(new String[] {"John", "Jane", "Sally"});
		print("John", "Jane", "Sally");
		print();
	}
	
}
