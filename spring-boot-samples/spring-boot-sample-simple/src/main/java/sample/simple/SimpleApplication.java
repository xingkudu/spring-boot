package sample.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;


@PropertySource("classpath:app.properties")
@EnableAspectJAutoProxy
@SpringBootApplication
public class SimpleApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SimpleApplication.class, args);
		SpringApplication application = new SpringApplication(SimpleApplication.class);
		ConfigurableApplicationContext context = application.run(args);
		context.publishEvent(new SpringApplicationEvent(application, args){});
		System.out.println(context.getEnvironment().getProperty("password"));
		System.out.println(context.getEnvironment().getProperty("sample.name2"));

	}

}
