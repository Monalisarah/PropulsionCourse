/*
 * Copyright 2010-2017 the original author or authors.
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

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * Domain entity for Spring events.
 *
 * @author Sam Brannen
 * @since 1.0
 */
@Entity
@Data
@EqualsAndHashCode(exclude = "id")
public class Event implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(AccessLevel.PRIVATE)
	private Long id;

	@NotNull(message = "{errors.required}")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate eventDate = LocalDate.now();

	@NotNull(message = "{errors.required}")
	@Size(min = 5, max = 30, message = "{errors.range}")
	private String name;

	@NotNull(message = "{errors.required}")
	@Size(min = 5, max = 30, message = "{errors.range}")
	private String location;


	public Event() {
	}

	public Event(Long id) {
		this();
		this.id = id;
	}

}
