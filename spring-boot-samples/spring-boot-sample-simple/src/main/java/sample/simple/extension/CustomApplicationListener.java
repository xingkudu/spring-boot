package sample.simple.extension;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;

/**
 * @ClassName CustomApplicationListener
 * @Description custom application listener
 * @Author hugo
 * @Date 2019-03-18 16:17
 * @Version 1.0
 **/
public class CustomApplicationListener implements ApplicationListener<ApplicationEvent>, Ordered {

	@Override
	public void onApplicationEvent(ApplicationEvent applicationEvent) {
		System.out.println(applicationEvent.getClass().getName());
	}

	@Override
	public int getOrder() {
		return 0;
	}
}
