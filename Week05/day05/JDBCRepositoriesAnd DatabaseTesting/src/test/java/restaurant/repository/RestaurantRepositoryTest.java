package restaurant.repository;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import config.TestDataAccessConfig;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestDataAccessConfig.class, RepositoryConfig.class})
@ActiveProfiles("dev")

public class RestaurantRepositoryTest {
	
	@Autowired
	RestaurantRepository restaurantRepository;
	
	@Test
	@Sql(statements = "delete from restaurant")
	@Sql("/test-data.sql")
	public void save() throws Exception {
	assertThat(restaurantRepository.count()).isEqualTo(1);
	
	}

//	void save(Restaurant restaurant);
//
//	Restaurant findById(String id);
//
//	List<Restaurant> findAll();
//	
//	List<Restaurant> findAllByCity(String city);
//	
//	List<Restaurant> findAllByCityAndCountry(String city, String country);
//
//	void deleteAll(); //(delete from Restaurant)
//
//	void deleteById(Integer id);
}
