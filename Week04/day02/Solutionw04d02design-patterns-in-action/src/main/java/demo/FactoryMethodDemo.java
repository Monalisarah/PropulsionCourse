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

package demo;

import static service.MessageFormatterFactory.createHtmlFormatter;

import domain.Customer;
import service.MessageFormatter;

public class FactoryMethodDemo {

	public static void main(String[] args) {
		integers();
		customers();
		messages();
	}

	private static void integers() {
		// Always creates a new Integer
		Integer newNum = new Integer(1);

		// Returns cached object for integers from -128 to 127.
		Integer num1 = Integer.valueOf(1);
		Integer num2 = Integer.valueOf(1);

		System.out.println("newNum.equals(num1): " + newNum.equals(num1));
		System.out.println("newNum == num1: " + (newNum == num1));

		System.out.println("num1.equals(num2): " + num1.equals(num2));
		System.out.println("num1 == num2: " + (num1 == num2));
	}

	private static void customers() {
		String name = "John Smith";
		int balance = 1000;

		Customer customer = Customer.create(name, balance);
		System.out.println(customer);
	}

	private static void messages() {
		// MessageFormatter messageFormatter = MessageFormatterFactory.createConsoleFormatter();
		MessageFormatter messageFormatter = createHtmlFormatter();
		System.out.println(messageFormatter.format("Hello"));
	}

}
