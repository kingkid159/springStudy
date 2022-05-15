package basic_5.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import basic_5.Calculator;
import basic_5.config.AppCtx;

public class MainAspect {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(AppCtx.class);
		
		Calculator cal = ctx.getBean("calculator", Calculator.class);
		long fiveFact = cal.factorial(5);
		System.out.println("cal.factorial(5) =" + fiveFact);
		System.out.println(cal.getClass().getName());
		ctx.close();
	}
}
