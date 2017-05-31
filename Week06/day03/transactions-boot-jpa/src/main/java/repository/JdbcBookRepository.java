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

package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import domain.Book;

@Repository
public class JdbcBookRepository implements BookRepository {

	private final BookMapper bookMapper = new BookMapper();

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcBookRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int count() {
		return jdbcTemplate.queryForObject("select count(*) from book", Integer.class);
	}

	@Override
	public void save(Book book) {
		jdbcTemplate.update("insert into book(isbn, author, title, num_pages) values(?,?,?,?)", //
			book.getIsbn(), book.getAuthor(), book.getTitle(), book.getNumPages());
	}

	@Override
	public void deleteAll() {
		jdbcTemplate.update("delete from book");
	}

	@Override
	public void deleteById(Integer id) {
		jdbcTemplate.update("delete from book where id=?", id);
	}

	@Override
	public void deleteByIsbn(String isbn) {
		jdbcTemplate.update("delete from book where isbn=?", isbn);
	}

	@Override
	public Book findById(Integer id) {
		return jdbcTemplate.queryForObject("select * from book where id=?", bookMapper, id);
	}

	@Override
	public Book findByIsbn(String isbn) {
		return jdbcTemplate.queryForObject("select * from book where isbn=?", bookMapper, isbn);
	}

	@Override
	public List<Book> findAll() {
		return jdbcTemplate.query("select * from book", bookMapper);
	}

	@Override
	public List<Book> findAllByAuthor(String author) {
		return jdbcTemplate.query("select * from book where author=?", bookMapper, author);
	}

	private static class BookMapper implements RowMapper<Book> {

		@Override
		public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
			// @formatter:off
			return new Book(
				rs.getInt("id"),
				rs.getString("isbn"),
				rs.getString("author"),
				rs.getString("title"),
				rs.getInt("num_pages")
			);
			// @formatter:on
		}
	}

}
