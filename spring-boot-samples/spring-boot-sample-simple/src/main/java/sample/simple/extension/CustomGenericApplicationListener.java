package sample.simple.extension;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.GenericApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.ResolvableType;

/**
 * @ClassName CustomApplicationListener
 * @Description custom application listener
 * @Author hugo
 * @Date 2019-03-18 16:17
 * @Version 1.0
 **/
public class CustomGenericApplicationListener implements GenericApplicationListener {

	@Override
	public boolean supportsEventType(ResolvableType resolvableType) {
		System.out.println(resolvableType.getType().getTypeName());
		return true;
	}

	@Override
	public void onApplicationEvent(ApplicationEvent applicationEvent) {
		System.out.println(applicationEvent.getClass().getName());
	}

	@Override
	public boolean supportsSourceType(Class<?> sourceType) {
		return true;
	}

	@Override
	public int getOrder() {
		return 0;
	}
}
