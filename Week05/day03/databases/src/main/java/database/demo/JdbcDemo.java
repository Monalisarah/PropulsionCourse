package database.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import database.config.DataAccessConfig;
import database.domain.TimeZoneClass;
import database.domain.User;

public class JdbcDemo {
	
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(DataAccessConfig.class);
		
		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
		
//		String sql = "insert into users(first_name, last_name, age) values(?,?,?)";
//		jdbcTemplate.update(sql, "John", "Smith", 25);
//		jdbcTemplate.update(sql, "Jane", "Schiffer", 24);
//		jdbcTemplate.update(sql, "Noah", "Wale", 23);
		
		
		String sql = "select count(*) from users";
		Integer numUsers = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println(numUsers);
		
		sql = "update users set age=22 WHERE id=11";
		Integer age1 = jdbcTemplate.update(sql);
	
		sql = "select age FROM users where id= 11";
		Integer age2 = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println(age2);
		
		sql = "select first_name FROM users where id= 11";
		String name1 = jdbcTemplate.queryForObject(sql, String.class);
		System.out.println(name1);
		
		sql = "select last_name FROM users where id= 4";
		String last = jdbcTemplate.queryForObject(sql, String.class);
		System.out.println(last);
		
//		sql = "delete FROM users WHERE id=10";
//		jdbcTemplate.update(sql);
				
		
		sql = "select * from users where first_name=?";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql, "Bla");
		System.out.println(map);
		
		
		
		sql = "select * from users where first_name=?";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, "John");
		System.out.println(list);
		for (Map<String, Object> forEachElementInTheList : list) {
			System.out.println(forEachElementInTheList);		
		}
		
		sql = "select * from users where first_name=?";
		User user = jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
		
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException{
			return new User (
					rs.getInt("id"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getInt("age")
					);
		};
	}, "Bla");
		
		System.out.println(user);
		
		
//		sql = "select * from users";
//		List<User> usersList = jdbcTemplate.query(sql, new RowMapper<User>() {
//		
//		@Override
//		public User mapRow(ResultSet rs, int rowNum) throws SQLException{
//			return new User (
//					rs.getInt("id"),
//					rs.getString("first_name"),
//					rs.getString("last_name"),
//					rs.getInt("age")
//					);
//		};
//	});
//	
//		for (User elementInUserList : usersList) {
//			System.out.println(elementInUserList);
//		}
//		
		
		
		sql = "select * from users";
		List<User> usersList = jdbcTemplate.query(sql, (rs, num) ->{
			return new User (
					rs.getInt("id"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getInt("age")
					);
	});
		
		for (User elementInUserList : usersList) {
			System.out.println(elementInUserList);
		}
		
		
//		sql= "CREATE TABLE timeStamp ( id INTEGER NOT NULL IDENTITY,timeCreated TIMESTAMP WITH TIME ZONE NOT NULL)";
//		jdbcTemplate.update(sql);
//		
		String sql2 = "insert into timeStamp(timeCreated) values(?)";
		jdbcTemplate.update(sql2, LocalDateTime.now());	
		
		sql = "select * from timeStamp";
		List<TimeZoneClass> timeZonelist = jdbcTemplate.query(sql2, new RowMapper<TimeZoneClass>(){
			@Override
			public TimeZoneClass mapRow(ResultSet rs, int rowNum) throws SQLException{
				return new TimeZoneClass(
						rs.getInt("id"),
						rs.getTimestamp("timeZone")
						);
				};
			});
	
		
	}
	
	

}
