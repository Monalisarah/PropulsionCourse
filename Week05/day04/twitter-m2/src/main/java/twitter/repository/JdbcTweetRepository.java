package twitter.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.mockito.internal.stubbing.answers.ThrowsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import twitter.domain.Tweet;

@Repository
public class JdbcTweetRepository implements TweetRepository {
	
	private final JdbcTemplate jdbcTemplate;


	@Autowired
	public JdbcTweetRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		
	}

	@Override
	public int count() {
		String sql = "select count(*) from tweet";
//		Integer numTweets = jdbcTemplate.queryForObject(sql, Integer.class);
//		return numTweets;
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public void save(Tweet tweet) {
		String sql = "INSERT INTO tweet(author, text) values(?,?)";
		this.jdbcTemplate.update(sql, tweet.getAuthor(), tweet.getText());
	}

	@Override
	public void deleteById(Integer id) {
		String sql = "Delete from tweet where id=?";
		jdbcTemplate.update(sql, id);
		
	}

	@Override
	public void deleteAll() {
		String sql = "DELETE from tweet";
		jdbcTemplate.update(sql);
		
	}

	@Override
	public Tweet findById(Integer id) {
		String sql = "Select * from tweet";
		Tweet tweet = jdbcTemplate.queryForObject(sql, new RowMapper<Tweet>(){
			
			public Tweet mapRow(ResultSet rs, int rowNum) throws SQLException{
			return new Tweet(
				rs.getInt("id"),
				rs.getString("text"),
				rs.getString("author")
				);
			};
		});
		return tweet;	
	}

	@Override
	public List<Tweet> findAll() {
		String sql = "Select * from tweet";
		List<Tweet> tweetsList = jdbcTemplate.query(sql, new RowMapper<Tweet>(){
			
			public Tweet mapRow(ResultSet rs, int rowNum) throws SQLException{
			return new Tweet(
				rs.getInt("id"),
				rs.getString("text"),
				rs.getString("author")
				);
			};
		});
		return tweetsList;
	}
	


	@Override
	public List<Tweet> findAllByUsername(String username) {
		String sql = "select * from tweet where author =?";
		List<Tweet> tweetList = jdbcTemplate.query(sql, new RowMapper<Tweet>(){
			public Tweet mapRow(ResultSet rs, int rowNum) throws SQLException{
				return new Tweet(
						rs.getInt("id"),
						rs.getString("text"),
						rs.getString("author")
						);
				
			};
		},username);
		return tweetList;
	}

	@Override
	public List<Tweet> findAllContaining(String searchText) {
		String sql = "select * from tweet where text like ?";
		List<Tweet> tweetList = jdbcTemplate.query(sql, new RowMapper<Tweet>(){
			public Tweet mapRow(ResultSet rs, int rowNum) throws SQLException{
				return new Tweet(
						rs.getInt("id"),
						rs.getString("text"),
						rs.getString("author")
						);
				
			};
		},"%"+searchText+"%");
		return tweetList;
	}

	@Override
	public List<String> findAllUsernames() {
		String sql = "SELECT author FROM tweet";
		List<String> list = jdbcTemplate.queryForList(sql, String.class);
		return list;
	
	}
	

}
