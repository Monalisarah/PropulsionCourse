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

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


import config.TestDataAccessConfig;
import domain.Book;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { TestDataAccessConfig.class, RepositoryConfig.class })
@ActiveProfiles("dev")
public class BookRepositoryTests {

	@Autowired
	BookRepository bookRepository;

	@Before
	public void clearBookTable() {
		bookRepository.deleteAll();
		assertNumBooks(0);
	}

	@Test
	public void save() throws Exception {
		Book book = new Book("978-3-16-148410-0", "Angelica", "Can't Wait for Summer", 120);

		bookRepository.save(book);
		assertNumBooks(1);
	}

	@Test
	public void findById() throws Exception {
		Book book = new Book("978-3-16-148410-0", "Angelica", "Can't Wait for Summer", 120);

		bookRepository.save(book);
		assertNumBooks(1);

		Integer id = bookRepository.findAll().get(0).getId();
		assertThat(bookRepository.findById(id)).isEqualTo(book);
	}

	private void assertNumBooks(int expected) {
		assertThat(bookRepository.count()).isEqualTo(expected);
	}

}
