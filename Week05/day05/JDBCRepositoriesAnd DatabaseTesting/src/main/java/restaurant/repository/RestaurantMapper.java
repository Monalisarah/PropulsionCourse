package restaurant.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import restaurant.domain.Restaurant;

public class RestaurantMapper implements RowMapper<Restaurant> {

	@Override
	public Restaurant mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Restaurant (rs.getString("id"), 
							   rs.getString("name"),
							   rs.getString("city"), 
							   rs.getInt("zip"), 
							   rs.getString("country")
							   );
	}
	
}
