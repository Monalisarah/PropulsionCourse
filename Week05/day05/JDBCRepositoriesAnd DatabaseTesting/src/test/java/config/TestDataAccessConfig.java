package config;

import javax.sql.DataSource;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

@Configuration
@Profile("dev")
@Import(DataAccessConfig.class)
public class TestDataAccessConfig {
	
	

	@Bean
	public DataSource dataSource(){
		return new EmbeddedDatabaseBuilder()
				.setType(H2)
				.generateUniqueName(true)
				.addScript("restaurant-test-schema.sql")
				.build();
				
	}
	
	
}
