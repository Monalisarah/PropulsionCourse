package restaurant.repository;

import java.util.List;

import restaurant.domain.Restaurant;

public interface RestaurantRepository {

	int count();

	void save(Restaurant restaurant);

	Restaurant findById(String id);

	List<Restaurant> findAll();
	
	List<Restaurant> findAllByCity(String city);
	
	List<Restaurant> findAllByCityAndCountry(String city, String country);

	void deleteAll(); //(delete from Restaurant)

	void deleteById(Integer id);
}
