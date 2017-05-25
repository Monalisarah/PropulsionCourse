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

package bank.app;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import bank.config.BankConfig;
import bank.domain.Customer;
import bank.service.BankService;

/**
 * Command-line application that serves as a facade to the {@link BankService}.
 */
@Service
public class BankApp {

	private static final Logger logger = LogManager.getLogger(BankApp.class);
//	private static final BankService bankService; //=new BankService();
	@SuppressWarnings("resource")
	static
	ApplicationContext context = new AnnotationConfigApplicationContext(BankConfig.class);
	static BankService bankService = context.getBean(BankService.class);

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
	

		
		while (true) {
			Operation operation = getOperationFromUser();

			switch (operation) {
				case EXIT: {
					banner("Exiting... 👋");
					System.exit(0);
				}
				case CUSTOMER_LIST: {
					printCustomers();
					break;
				}
				case NEW_CUSTOMER: {
					createNewCustomer();
					break;
				}
				case FIND_CUSTOMER: {
					findCustomer();
					break;
				}
				case DELETE_CUSTOMER: {
					deleteCustomer();
					break;
				}
				case CREDIT_ACCOUNT: {
					creditAccount();
					break;
				}
				case DEBIT_ACCOUNT: {
					debitAccount();
					break;
				}
				default:
					System.err.printf("Unsupported operation: %s%n%n", operation.ordinal());
					break;
			}
		}
	}

	private static void printCustomer(Customer customer) {
		System.out.println(customer.getName());
		System.out.println("\tCustomer ID:      " + customer.getId());
		System.out.println("\tAccount ID:       " + customer.getAccount().getId());
		System.out.println("\tAccount Balance:  " + customer.getAccount().getBalance());
	}

	private static void printCustomers() {
		banner("Customers");
		System.out.println();

		List<Customer> customers = bankService.findAll();
		if (customers.isEmpty()) {
			System.out.println("The bank has no customers.");
		}
		else {
			customers.forEach(BankApp::printCustomer);
		}
	}

	private static void createNewCustomer() {
		banner("Create New Customer");

		prompt("Customer name");
		String name = scanner.nextLine();

		prompt("Account balance");
		double balance = scanner.nextDouble();

		bankService.save(new Customer(name, balance));
	}

	private static void findCustomer() {
		banner("Find Customer");

		prompt("Customer ID");
		String id = scanner.nextLine();

		System.out.println();
		Customer customer = bankService.findById(id);
		if (customer == null) {
			System.err.println("Could not find customer with ID: " + id);
		}
		else {
			printCustomer(customer);
		}
	}

	private static void deleteCustomer() {
		banner("Delete Customer");

		prompt("Customer ID");
		String id = scanner.nextLine();

		bankService.delete(id);

		// We assume the customer got deleted, but we don't
		// actually know if the operation succeeded.
		// For example, if there is no such customer, the
		// BankService doesn't inform us of that. :(
		System.out.println("Deleted customer with ID: " + id);
	}

	private static void creditAccount() {
		banner("Credit Account");

		prompt("Customer ID");
		String id = scanner.nextLine();
		Customer customer = bankService.findById(id);

		if (customer == null) {
			System.err.println("Could not find customer with ID: " + id);
		}
		else {
			prompt("Credit amount");
			double amount = scanner.nextDouble();

			try {
				customer.getAccount().credit(amount);
				System.out.println("Credited account with: " + amount);
				printCustomer(customer);
			}
			catch (IllegalArgumentException ex) {
				// Log the exception at the warn level.
				logger.warn("Failed to credit account for customer with ID " + customer.getId(), ex);
				// Use System.err to inform the user that the amount is
				// invalid by printing the message of the exception.
				System.err.println("Error: " + ex.getMessage());
				// Swallow the exception (i.e., do not rethrow it), thereby
				// allowing the program to continue running.
			}
		}
	}

	private static void debitAccount() {
		banner("Debit Account");

		prompt("Customer ID");
		String id = scanner.nextLine();
		Customer customer = bankService.findById(id);

		if (customer == null) {
			System.err.println("Could not find customer with ID: " + id);
		}
		else {
			prompt("Debit amount");
			double amount = scanner.nextDouble();

			try {
				customer.getAccount().debit(amount);
				System.out.println("Debited account by: " + amount);
				printCustomer(customer);
			}
			catch (IllegalArgumentException ex) {
				// Log the exception at the warn level.
				logger.warn("Failed to debit account for customer with ID " + customer.getId(), ex);
				// Use System.err to inform the user that the amount is
				// invalid by printing the message of the exception.
				System.err.println("Error: " + ex.getMessage());
				// Swallow the exception (i.e., do not rethrow it), thereby
				// allowing the program to continue running.
			}
		}
	}

	private static Operation getOperationFromUser() {
		banner("Menu");

		while (true) {
			printMenu();
			prompt("Operation");
			if (scanner.hasNextInt()) {
				int input = scanner.nextInt();
				scanner.nextLine();
				Operation operation = Operation.fromOrdinal(input);
				if (operation == null) {
					System.err.println("Invalid operation: " + input);
				}
				else {
					return operation;
				}
			}
			else {
				if (scanner.hasNextLine()) {
					System.err.println("Invalid operation: " + scanner.nextLine());
				}
			}
		}
	}

	private static void printMenu() {
		System.out.println();
		for (Operation current : Operation.values()) {
			System.out.println(current);
		}
	}

	private static void prompt(String label) {
		System.out.printf("%nEnter %s: ", label);
	}

	private static void banner(String header) {
		System.out.println();
		System.out.println("=================================================");
		System.out.println("=== " + header);
		System.out.println("=================================================");
	}

}
