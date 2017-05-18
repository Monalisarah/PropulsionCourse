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

package domain;

import java.util.concurrent.atomic.AtomicInteger;

import lombok.Data;

@Data
public class Customer {

	private static final AtomicInteger idGenerator = new AtomicInteger();

	private final String id = String.valueOf(idGenerator.incrementAndGet());
	private final String name;
	private Account account;

	public static Customer create(String name, int balance) {
		Customer customer = new Customer(name);
		Account account = new Account(customer, balance);
		customer.setAccount(account);
		// Some additional logic here that doesn't belong in a constructor.
		return customer;
	}

	/**
	 * Create a new {@code Customer} without an {@link Account}.
	 */
	public Customer(String name) {
		this.name = name;
	}

}
