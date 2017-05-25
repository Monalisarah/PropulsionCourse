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

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.subethamail.wiser.Wiser;
import org.subethamail.wiser.WiserMessage;

import config.MailConfig;
import config.MessageServiceConfig;
import config.TestMailConfig;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { MessageServiceConfig.class, TestMailConfig.class })
@ActiveProfiles("dev")
public class MessageServiceTests {
	
	@Autowired
	MessageService messageService;
	// wiring the bean 
	
	@Autowired
	Wiser wiser;
	
//	@Autowired
//	HtmlMessageFormatter htmlFormatter;
	
//	@Autowired 
//	ApplicationContext context;
//	// wiring the box 
		

	
	

	@Test
	public void compositeFormatter() throws Exception {
		assertThat(messageService.generateMessage()).isEqualTo("<strong>HELLO, WORLD</strong>");
//		assertThat(context.getBean(MessageService.class)).isEqualTo("<strong>HELLO, WORLD</strong>");
//		assertThat(context.getBean(HtmlMessageFormatter.class).format("hello sam")).isEqualTo("<strong>hello sam</strong>");
//		
//		System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
		assertThat(wiser.getMessages()).hasSize(1);
		
		MimeMessage mimeMessage =
			    wiser.getMessages().get(0).getMimeMessage();
			String from = mimeMessage.getFrom()[0].toString();
			String to = mimeMessage.getRecipients(RecipientType.TO)[0].toString();
			String subject = mimeMessage.getSubject();
			String body = mimeMessage.getContent().toString().trim();

			// assert expected values...
			assertThat(from).isEqualTo("system@example.com");
			assertThat(to).isEqualTo("test@example.com");
			assertThat(subject).isEqualTo("My Subject");
			assertThat(body).isEqualTo("<strong>HELLO, WORLD</strong>");

			// good idea to clear sent messages
			wiser.getMessages().clear();
		
	}
	
	

}
