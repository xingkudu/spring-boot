package sample.simple.extension;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @ClassName CustomApplicationListenerAduience
 * @Description CustomApplicationListener 切面
 * @Author hugo
 * @Date 2019-03-18 17:41
 * @Version 1.0
 **/
@Aspect
@Component
public class CustomApplicationListenerAduience {

//	@Pointcut("execution(* sample.simple.extension.CustomApplicationListener.onApplicationEvent(..))")
	@Pointcut("execution(* sample.simple.service.HelloWorldService.getHelloMessage(..))")
	public void onApplicationEvent(){
	}

	/**
	 * 前置通知，目标方法调用前被调用
	 * @param joinPoint
	 */
	@Before("onApplicationEvent()")
	public void beforeAdvice(JoinPoint joinPoint){
		System.out.println("- - - - - 前置通知 - - - - -");
		Signature signature = joinPoint.getSignature();
		System.out.println("返回目标方法的签名："+signature);
		System.out.println("代理的是哪一个方法："+signature.getName());
		Object[] obj = joinPoint.getArgs();
		System.out.println("获取目标方法的参数信息："+ Arrays.asList(obj));
	}

	/**
	 * 后置最终通知，目标方法执行完执行
	 */
	@After("onApplicationEvent()")
	public void afterAdvice(){
		System.out.println("- - - - - 后置最终通知- - - - -");
	}
	/**
	 * 后置返回通知
	 * 如果参数中的第一个参数为JoinPoint，则第二个参数为返回值的信息
	 * 如果参数中的第一个参数不为JoinPoint，则第一个参数为returning中对应的参数
	 * returning 只有目标方法返回值与通知方法相应参数类型时才能执行后置返回通知，否则不执行
	 * @param joinPoint
	 * @param order
	 */
	@AfterReturning(value = "execution(* sample.simple.extension.CustomApplicationListener.getOrder(..))",returning = "order")
	public void afterReturningAdvice(JoinPoint joinPoint,int order){
		System.out.println("- - - - - 后置返回通知- - - - -");
		System.out.println("后置返回通知 返回值："+order);
	}

}
