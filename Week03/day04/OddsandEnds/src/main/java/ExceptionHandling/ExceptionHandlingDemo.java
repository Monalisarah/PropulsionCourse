package ExceptionHandling;

import java.io.IOException;

public class ExceptionHandlingDemo {

	public static void main(String[] args) {
		
		try {
			System.out.println("Vor");
			throwIllegalArgumentException();
			throwIOExeption();
			throwThrowable();
			System.out.println("Nach  der IOEx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Vor dem catch der IOEx");
			e.printStackTrace();
			System.out.println("Nach dem catch der IOEx");
		} catch (IllegalArgumentException e){
			System.out.println("Vor dem catch der IllArg");
			e.printStackTrace();
			System.out.println("Nach dem catch der IllArg");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		throwIllegalArgumentException();
		System.out.println("Yusef isch da bitte");
		
	
		
		
//		throwAssertionError();
		
	}
	//checked example
	private static void throwIOExeption() throws IOException {
		throw new IOException("My message here");	
	}
	//unchecked example
	private static void throwIllegalArgumentException() {
		throw new IllegalArgumentException("Simona is here");
	}
	
	private static void throwThrowable() throws Throwable {
		throw new Throwable ("Alli sind da");
	}
	
	
	
}
