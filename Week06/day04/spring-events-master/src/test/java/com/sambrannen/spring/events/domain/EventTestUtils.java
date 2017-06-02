/*
 * Copyright 2010-2016 the original author or authors.
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

package com.sambrannen.spring.events.domain;

/**
 * Collection of test utilities for working with the {@link Event} entity.
 *
 * @author Sam Brannen
 * @since 1.0
 */
class EventTestUtils {

	static Event createEvent(Long id) {
		return createEvent(id, "Test Event");
	}

	static Event createEvent(String name) {
		return createEvent(99L, name);
	}

	static Event createEvent(Long id, String name) {
		Event event = new Event(id);
		event.setName(name);
		event.setLocation("Unit Test");
		return event;
	}

}
