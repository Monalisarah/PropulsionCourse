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

// import java.util.logging.Level;
// import java.util.logging.Logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingDemo {

	// JUL:
	// private static final Logger logger = Logger.getLogger(LoggingDemo.class.getName());

	// Log4J:
	private static final Logger logger = LogManager.getLogger(LoggingDemo.class);

	public static void main(String[] args) {
		logger.info("My first log message!");

		try {
			logger.debug("Trying before blowing up...");
			blowUp();
		}
		catch (Exception ex) {
			// JUL:
			// logger.warning("Something went wrong");
			// logger.log(Level.WARNING, "Something went wrong", ex);

			// Log4J:
			// logger.warn("Something went wrong");
			logger.warn("Something went wrong", ex);
		}

	}

	private static void blowUp() {
		throw new RuntimeException("Boom!");
	}

}
