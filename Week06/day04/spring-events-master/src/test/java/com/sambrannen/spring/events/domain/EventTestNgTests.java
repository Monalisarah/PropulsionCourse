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

import static com.sambrannen.spring.events.domain.EventTestUtils.createEvent;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.util.ReflectionTestUtils.getField;
import static org.springframework.test.util.ReflectionTestUtils.setField;

import org.testng.annotations.Test;

/**
 * Copy of {@link EventTests} that replaces JUnit with TestNG.
 *
 * @author Sam Brannen
 * @author Nicolas Frankel
 * @since 1.0
 */
class EventTestNgTests {

	@Test
	void lombokShouldSetCorrectly() {
		Event event = new Event(99L);
		event.setName("Test Event");
		event.setLocation("Unit Test");

		assertThat(getField(event, "id")).isEqualTo(99L);
		assertThat(getField(event, "name")).isEqualTo("Test Event");
		assertThat(getField(event, "location")).isEqualTo("Unit Test");
	}

	@Test
	void lombokShouldGetCorrectly() {
		Event event = new Event(99L);
		setField(event, "name", "Test Event");
		setField(event, "location", "Unit Test");

		assertThat(event.getId()).isEqualTo(99L);
		assertThat(event.getName()).isEqualTo("Test Event");
		assertThat(event.getLocation()).isEqualTo("Unit Test");
	}

	@Test
	void eventsShouldBeEqualWithDifferentIdsButTheSameName() {
		Event event1 = createEvent(1L);
		Event event2 = createEvent(2L);

		assertThat(event1).isEqualTo(event1);
		assertThat(event2).isEqualTo(event2);
		assertThat(event1).isEqualTo(event2);
	}

	@Test
	void eventsShouldNotBeEqualWithTheSameIdButDifferentNames() {
		Event event3 = createEvent("event 3");
		Event event4 = createEvent("event 4");

		assertThat(event3).isEqualTo(event3);
		assertThat(event4).isEqualTo(event4);
		assertThat(event3).isNotEqualTo(event4);
	}

	@Test
	void eventsShouldHaveSameHashCodeWithDifferentIdsButTheSameName() {
		Event event1 = createEvent(1L);
		Event event2 = createEvent(2L);

		assertThat(event1.hashCode()).isEqualTo(event1.hashCode());
		assertThat(event2.hashCode()).isEqualTo(event2.hashCode());
		assertThat(event1.hashCode()).isEqualTo(event2.hashCode());
	}

	@Test
	void eventsShouldNotHaveSameHashCodeWithTheSameIdButDifferentNames() {
		Event event3 = createEvent("event 3");
		Event event4 = createEvent("event 4");

		assertThat(event3.hashCode()).isEqualTo(event3.hashCode());
		assertThat(event4.hashCode()).isEqualTo(event4.hashCode());
		assertThat(event3.hashCode()).isNotEqualTo(event4.hashCode());
	}

}
