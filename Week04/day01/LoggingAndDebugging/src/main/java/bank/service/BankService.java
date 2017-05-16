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

package bank.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import bank.domain.Customer;

public class BankService {
	
	private static final Logger logger = LogManager.getLogger(BankService.class);
			
	private final Map<String, Customer> database = new HashMap<>();

	public List<Customer> findAll() {
		
		return new ArrayList<>(this.database.values());
	}

	public Customer findById(String id) {
		logger.trace("Finding Customer with ID "+ id );
		return this.database.get(id);
	}

	public void save(Customer customer) {
		
		try {
			this.database.put(customer.getId(), customer);
			logger.trace("New customer saved into the database: "+ customer.getId());	
		} catch (Exception e) {
			// warn or error depends on business requirements
			logger.warn("Failed to save customer into the database: " + customer.getId(), e);
		}
	}

	public void delete(String id) {
		logger.trace("Deleting Customer with ID "+ id );
		this.database.remove(id);
	}

}
