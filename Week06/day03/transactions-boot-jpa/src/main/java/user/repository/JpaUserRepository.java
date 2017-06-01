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

package user.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import user.domain.User;

@Repository
public class JpaUserRepository implements UserRepository {

//	private final UserMapper userMapper = new UserMapper();

//	private final JdbcTemplate jdbcTemplate;
	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public long count() {
		String query = "select count(*) from User";

		return //long count = 
		   entityManager
		  .createQuery(query, Long.class)
		  .getSingleResult();
		
	}

	@Override
	public void save(User user) {
		entityManager.persist(user);
		
	}

	@Override
	public List<User> findAll() {
	
		return entityManager
				  .createQuery("from User", User.class)
				  .getResultList();
	}

	@Override
	public User findById(Long id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public User findByFirstNameAndLastName(String firstName, String lastName) {
		String query = "from User u where u.firstName = :firstName and u.lastName = :lastName";
				return entityManager.createQuery(query, User.class)
						 .setParameter("firstName", firstName)
						  .setParameter("lastName", lastName)
						  .getSingleResult();
	}

	@Override
	public void deleteAll() {
		entityManager
		  .createQuery("delete from User")
		  .executeUpdate();
		
	}

	@Override
	public void deleteById(Long id) {
		String query = "delete from User u where u.id = :id ";
		
		entityManager.createQuery(query)
		  .setParameter("id", id)
		  .executeUpdate();
		
	}
	
	@Override
	public User findFirstByLastName(String lastName) {
		String query = "from User u where u.lastName = :lastName order by firstName asc";
		return entityManager.createQuery(query, User.class)
				.setParameter("lastName", lastName)
				.setMaxResults(1)
				.getSingleResult();
				
		
	}

	@Override
	public List<User> findFirst10ByLastName(String lastName) {
		String query = "from User u where u.lastName = :lastName order by firstName asc";
		return entityManager.createQuery(query, User.class)
				.setParameter("lastName", lastName)
				.setMaxResults(10)
				.getResultList();
		
	}
}
	
	
	

//	@Autowired
//	public JpaUserRepository(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}
//
//	@Override
//	public long count() {
//		return jdbcTemplate.queryForObject("select count(*) from users", Long.class);
//	}
//
//	@Override
//	public void save(User user) {
//		String sql = "insert into users(first_name, last_name, age) values(?,?,?)";
//		jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getAge());
//	}
//
//	@Override
//	public List<User> findAll() {
//		return jdbcTemplate.query("select * from users", userMapper);
//	}
//
//	@Override
//	public User findById(Long id) {
//		String sql = "select * from users where id=?";
//		return jdbcTemplate.queryForObject(sql, userMapper, id);
//	}
//
//	@Override
//	public User findByFirstNameAndLastName(String firstName, String lastName) {
//		String sql = "select * from users where first_name=? and last_name=?";
//		return jdbcTemplate.queryForObject(sql, userMapper, firstName, lastName);
//	}
//
//	@Override
//	public void deleteAll() {
//		jdbcTemplate.update("delete from users");
//	}
//
//	@Override
//	public void deleteById(Long id) {
//		jdbcTemplate.update("delete from users where id=?", id);
//	}

//	private static class UserMapper implements RowMapper<User> {
//
//		@Override
//		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//			return new User(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getInt("age"));
//		}
//	}


