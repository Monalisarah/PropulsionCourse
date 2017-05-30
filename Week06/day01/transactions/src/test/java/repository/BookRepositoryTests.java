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

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.transaction.annotation.Transactional;

import config.TestDataAccessConfig;
import domain.Book;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { TestDataAccessConfig.class, RepositoryConfig.class })
@ActiveProfiles("dev")
@Sql("/test-data.sql")
@Transactional
public class BookRepositoryTests {

	/**
	 * Number of books inserted in test-data.sql
	 */
	private static final int NUM_BOOKS = 100;

	@Autowired
	BookRepository bookRepository;

	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * "Can't Wait for Summer" is assigned ID #1 in test-data.sql.
	 */
	Book summer = new Book(1, "978-3-16-148410-0", "Angelica", "Can't Wait for Summer", 120);
	Book spring = new Book("978-0-59-680193-9", "Sam Brannen", "Spring in a Nutshell", 700);

	@BeforeTransaction
	public void assertNumBooksBeforeTransaction() {
		System.out.println("Before transaction: "+ JdbcTestUtils.countRowsInTable(jdbcTemplate, "book"));
//		assertNumBooks(0);
	}
	
	@Before
	public void assertNumBooksBefore() {
		System.out.println("Before: "+ JdbcTestUtils.countRowsInTable(jdbcTemplate, "book"));
//		assertNumBooks(NUM_BOOKS);
	}
	
	@AfterTransaction
	public void assertNumBooksAfterTransaction() {
		System.out.println("After Transaction: "+ JdbcTestUtils.countRowsInTable(jdbcTemplate, "book"));
	}
	
	@After
	public void assertNumBooksAfter() {
		System.out.println("After: "+ JdbcTestUtils.countRowsInTable(jdbcTemplate, "book"));
//		assertNumBooks(NUM_BOOKS);
	}
	
	@Test
	public void save() {
		assertNumBooks(NUM_BOOKS);

		bookRepository.save(spring);
		assertNumBooks(NUM_BOOKS + 1);
	}

	@Test
//	@Sql(statements = "delete from book")
	public void count() {
		assertNumBooks(NUM_BOOKS);

		assertThat(bookRepository.count()).isEqualTo(NUM_BOOKS);
	}

	@Test
	public void deleteById() {
		assertNumBooks(NUM_BOOKS);

		bookRepository.deleteById(summer.getId());
		assertNumBooks(NUM_BOOKS - 1);
	}

//	@Test
//	@Sql(statements = "insert into book(isbn, author, title, num_pages) values('111', 'Angelica', 'Cannot Wait for Summer', 120)")
//	@Sql(statements = "insert into book(isbn, author, title, num_pages) values('222', 'Bart', 'Cannot Wait for Springfield', 10)")
////	@Sql(statements = "delete from book", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
//	public void deleteByIsbn() {
//		assertNumBooks(2);
//		assertThat(bookRepository.findByIsbn("111")).isNotNull();
//		assertThat(bookRepository.findByIsbn("222")).isNotNull();
//
//		bookRepository.deleteByIsbn("111");
//		assertNumBooks(1);
//		bookRepository.deleteByIsbn("222");
//		assertNumBooks(0);
//	}

	@Test
	public void findById() {
		assertNumBooks(NUM_BOOKS);

		assertThat(bookRepository.findById(summer.getId())).isEqualTo(summer);
	}

	@Test
	public void findByIsbn() {
		assertNumBooks(NUM_BOOKS);

		assertThat(bookRepository.findByIsbn(summer.getIsbn())).isEqualTo(summer);
	}

	@Test
	public void findAll() {
		assertNumBooks(NUM_BOOKS);
		bookRepository.save(spring);
		assertNumBooks(NUM_BOOKS + 1);

		assertThat(bookRepository.findAll()).contains(summer, spring);
	}

	@Test
	public void findAllByAuthor() {
		assertNumBooks(NUM_BOOKS);
		bookRepository.save(spring);
		assertNumBooks(NUM_BOOKS + 1);

		assertThat(bookRepository.findAllByAuthor(summer.getAuthor())).containsExactly(summer);
	}

	private void assertNumBooks(int expected) {
		assertThat(JdbcTestUtils.countRowsInTable(jdbcTemplate, "book")).isEqualTo(expected);
	}

}
