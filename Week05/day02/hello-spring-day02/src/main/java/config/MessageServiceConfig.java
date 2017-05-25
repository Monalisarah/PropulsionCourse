package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("service")
//@Profile("dev")
public class MessageServiceConfig {

//	@Bean
//	public TrimmingMessageFormatter trimmingMessageFormatter() {
//		return new TrimmingMessageFormatter();
//	}
//
//	@Bean
//	public UpperCaseMessageFormatter upperCaseMessageFormatter() {
//		return new UpperCaseMessageFormatter();
//	}
//
//	@Bean
//	public HtmlMessageFormatter htmlMessageFormatter() {
//		return new HtmlMessageFormatter();
//	}
//	@Bean
//	public CompositeMessageFormatter compositeMessageFormatter(){
//		List<MessageFormatter> formatters = Arrays.asList(
//				trimmingMessageFormatter(),
//				upperCaseMessageFormatter(),
//				htmlMessageFormatter()
//				);
//		return new CompositeMessageFormatter(formatters);
//		
//	}
//
//	@Bean
//	public MessageService messageService(CompositeMessageFormatter compositeMessageFormatter){
//		return new MessageService(compositeMessageFormatter);
//	}
	
//	@Bean
//	public MessageService messageService(){
//		List<MessageFormatter> formatters = Arrays.asList(
//				trimmingMessageFormatter(),
//				upperCaseMessageFormatter(),
//				htmlMessageFormatter()
//				);
//		CompositeMessageFormatter compositeMessageFormatter = new CompositeMessageFormatter(formatters);
//		return new MessageService(compositeMessageFormatter);
//	}
	
}
