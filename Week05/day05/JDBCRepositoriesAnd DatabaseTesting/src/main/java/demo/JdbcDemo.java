/*
 * Copyright 2016-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import config.DataAccessConfig;
import domain.User;
import repository.UserMapper;

public class JdbcDemo {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(DataAccessConfig.class);

		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

		// Start by emptying the table; only for demo/testing purposes
		String sql = "delete from users";
		jdbcTemplate.update(sql);

		// Create new users
		sql = "insert into users(first_name, last_name, age) values(?,?,?)";
		jdbcTemplate.update(sql, "John", "Smith", 25);
		jdbcTemplate.update(sql, "Jane", "Smith", 28);

		// Query for a String
		// sql = "select first_name from users where age=28";
		sql = "select first_name from users where age=?";
		int age = 28;
		String firstName = jdbcTemplate.queryForObject(sql, String.class, age);
		System.out.println("First name: " + firstName);

		// Query for an integer
		sql = "select age from users where first_name=? and last_name=?";
		age = jdbcTemplate.queryForObject(sql, Integer.class, "Jane", "Smith");
		System.out.println("Age: " + age);

		// Aggregation functions: count, min, max, avg, etc.
		int numUsers = jdbcTemplate.queryForObject("select count(*) from users", Integer.class);
		System.out.println("Num users: " + numUsers);

		// Update a user's age
		sql = "update users set age=? where first_name=? and last_name=?";
		jdbcTemplate.update(sql, 99, "John", "Smith");

		// Search for user by ID
		sql = "select id from users where first_name=? and last_name=?";
		int id = jdbcTemplate.queryForObject(sql, Integer.class, "Jane", "Smith");

		// Delete user by ID
		sql = "delete from users where id=?";
		jdbcTemplate.update(sql, id);

		numUsers = jdbcTemplate.queryForObject("select count(*) from users", Integer.class);
		System.out.println("Num users after deletion: " + numUsers);

		// --- Query for Map ---------------------------------------------------
		System.out.println("\n=== Query for Map ===============================");

		sql = "select * from users where first_name=? and last_name=?";
		Map<String, Object> map = jdbcTemplate.queryForMap(sql, "John", "Smith");
		System.out.println("Map: " + map);

		// --- Query for List --------------------------------------------------
		System.out.println("\n=== Query for List ==============================");

		sql = "insert into users(first_name, last_name, age) values(?,?,?)";
		jdbcTemplate.update(sql, "Jane", "Smith", 28);
		List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from users");
		System.out.println("List: " + list);

		// --- RowMapper -------------------------------------------------------
		System.out.println("\n=== RowMapper ===================================");

		// Anonymous inner class
		User user = jdbcTemplate.queryForObject("select * from users where first_name=?", //
			new RowMapper<User>() {

				@Override
				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				// @formatter:off
				return new User(
						rs.getInt("id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getInt("age"));
				// @formatter:on
				}
			}, "John");
		System.out.println(user);

		// Lambda expression
		user = jdbcTemplate.queryForObject("select * from users where first_name=?", //
			(rs, rowNum) ->
			// @formatter:off
				new User(
						rs.getInt("id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getInt("age"))
				// @formatter:on
			, "John");
		System.out.println(user);

		UserMapper userMapper = new UserMapper();

		// Query for all users with a custom RowMapper
		sql = "select * from users";
		List<User> users = jdbcTemplate.query(sql, userMapper);
		System.out.println(users);

		extraCredit(jdbcTemplate);
	}

	private static void extraCredit(JdbcTemplate jdbcTemplate) {

		System.out.println("\n=== Extra Credit ===================================");

		// Make sure the author table does exist
		jdbcTemplate.update("drop table author if exists");

		String createAuthorTable = //
			"CREATE TABLE author(id INTEGER NOT NULL IDENTITY, first_name VARCHAR(50) NOT NULL)";
		jdbcTemplate.execute(createAuthorTable);

		jdbcTemplate.update("insert into author(first_name) values(?)", "Sarah");
		int count = jdbcTemplate.queryForObject("select count(*) from author", Integer.class);
		System.out.println("Number of authors: " + count);
	}

}
