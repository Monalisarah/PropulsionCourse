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
public class Account {

	private static final AtomicInteger idGenerator = new AtomicInteger();

	private final String id = String.valueOf(idGenerator.incrementAndGet());
	private final Customer customer;
	private double balance;

	public Account(Customer customer, double balance) {
		this.customer = customer;
		this.balance = balance;

		this.customer.setAccount(this);
	}

	/**
	 * @param amount the amount to credit; must be greater than 0
	 *
	 * @throws IllegalArgumentException if supplied amount is negative
	 */
	public void credit(double amount) throws IllegalArgumentException {
		if (amount < 0) {
			throw new IllegalArgumentException("Cannot credit a negative amount");
		}
		this.balance += amount;
	}

	/**
	 * @param amount the amount to debit; must be greater than 0
	 *
	 * @throws IllegalArgumentException if supplied amount is negative
	 */
	public void debit(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Cannot debit a negative amount");
		}
		this.balance -= amount;
	}

	@Override
	public String toString() {
		return "Account [ID=" + this.id + ", Customer ID=" + (this.customer == null ? null : this.customer.getId())
				+ ", Balance=" + this.balance + "]";
	}

}
