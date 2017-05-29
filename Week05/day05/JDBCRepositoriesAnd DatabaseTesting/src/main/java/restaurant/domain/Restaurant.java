package restaurant.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude = "id")
public class Restaurant {
	
	private String id;
	private String name;
	private String city;
	private int zip;
	private String country;
	
	public Restaurant(String name, String city, int zip, String country) {
		super();
		this.name = name;
		this.city = city;
		this.zip = zip;
		this.country = country;
	}

	public Restaurant(String id, String name, String city, int zip, String country) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.zip = zip;
		this.country = country;
	}
	
	

}
