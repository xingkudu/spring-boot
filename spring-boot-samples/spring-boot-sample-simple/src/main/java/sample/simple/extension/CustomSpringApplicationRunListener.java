package sample.simple.extension;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @ClassName CustomSpringApplicationRunListener
 * @Description 自定义 spring application run listener
 * @Author hugo
 * @Date 2019-03-18 14:36
 * @Version 1.0
 **/
public class CustomSpringApplicationRunListener implements SpringApplicationRunListener, Ordered {

	public CustomSpringApplicationRunListener(SpringApplication application, String[] args) {
		System.out.println("spring application main class is: " + application.getMainApplicationClass().getName());
		System.out.println("spring application main class args: " + args);
	}

	@Override
	public void starting() {
		System.out.println("spring application starting");
	}

	@Override
	public void environmentPrepared(ConfigurableEnvironment environment) {
		System.out.println("spring environment Prepared");
		System.out.println("environment default profiles: " + environment.getDefaultProfiles());
		System.out.println("environment active profiles: " + environment.getActiveProfiles());
	}

	@Override
	public void contextPrepared(ConfigurableApplicationContext context) {
		System.out.println("spring context Prepared");
		System.out.println("spring context application name is: " + context.getApplicationName());
		System.out.println("spring context is active: " + context.isActive());
	}

	@Override
	public void contextLoaded(ConfigurableApplicationContext context) {
		System.out.println("spring context loaded");
		System.out.println("spring context application name is: " + context.getApplicationName());
		System.out.println("spring context is active: " + context.isActive());
	}

	@Override
	public void started(ConfigurableApplicationContext context) {
		System.out.println("spring started");
		System.out.println("spring context application name is: " + context.getApplicationName());
		System.out.println("spring context is active: " + context.isActive());
	}

	@Override
	public void running(ConfigurableApplicationContext context) {
		System.out.println("spring running");
		System.out.println("spring context application name is: " + context.getApplicationName());
		System.out.println("spring context is active: " + context.isActive());
	}

	@Override
	public void failed(ConfigurableApplicationContext context, Throwable exception) {
		System.out.println("spring start failed");
		System.out.println("spring start failed error: " + exception.getMessage());
	}

	@Override
	public int getOrder() {
		return 1;
	}
}
