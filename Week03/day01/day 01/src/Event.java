import java.time.LocalDate;

public class Event {

	private static int count; //class Variable
	private String name; // scope of the instance
	private String location;
	private LocalDate date = LocalDate.now();
	
	public Event (){
		Event.count++;
	}
	
	public Event (String name){
		
	}
	
	
}
