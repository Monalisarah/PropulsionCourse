package restaurant.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import restaurant.domain.Restaurant;

@Repository
public class JdbcRestaurantRepository implements RestaurantRepository {
	
	private final RestaurantMapper restaurantMapper  = new RestaurantMapper();
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcRestaurantRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int count() {
				return jdbcTemplate.queryForObject("select count(*) from restaurant", Integer.class);
	}

	@Override
	public void save(Restaurant restaurant) {
		jdbcTemplate.update("insert into restaurant(name, city, zip, country) values(?,?,?,?)",
				restaurant.getName(), restaurant.getCity(), restaurant.getZip(), restaurant.getCountry());
		
	}


	@Override
	public Restaurant findById(String id) {
		return jdbcTemplate.queryForObject("select * from restaurant where id=?",restaurantMapper, id);
	}

	@Override
	public List<Restaurant> findAll() {
		return jdbcTemplate.query("select * from restaurant",restaurantMapper);
	}

	@Override
	public List<Restaurant> findAllByCity(String city) {
		return jdbcTemplate.query("select * from restaurant where city=?",restaurantMapper, city);
	}

	@Override
	public List<Restaurant> findAllByCityAndCountry(String city, String country) {
		return jdbcTemplate.query("select * from restaurant where(city, country) values(?,?)",restaurantMapper, city, country);
	}

	@Override
	public void deleteAll() {
		jdbcTemplate.update("delete restaurant");
	}

	@Override
	public void deleteById(Integer id) {
		jdbcTemplate.update("delete from restaurant where id=?", id);
		
	}



}
