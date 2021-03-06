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

package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Book;
import repository.BookRepository;
@Service
@Transactional(readOnly = true)
public class DefaultBookService implements BookService {

	private final BookRepository bookRepository;

	@Autowired
	public DefaultBookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	@Transactional(readOnly = false)
	public void saveBook(Book book) {
		this.bookRepository.save(book);
	}

	@Override
	public Book findById(Integer id) {
		return this.bookRepository.findById(id);
	}

	@Override
	public Book findByIsbn(String isbn) {
		return this.bookRepository.findByIsbn(isbn);
	}

	@Override
	public List<Book> findAllByAuthor(String author) {
		return this.bookRepository.findAllByAuthor(author);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteById(Integer id) {
		this.bookRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteByIsbn(String isbn) {
		this.bookRepository.deleteByIsbn(isbn);
	}

}
