package basic_5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import basic_5.Calculator;
import basic_5.RecCalculator;
import basic_5.aspect.CacheAspect;
import basic_5.aspect.ExeTimeAspect;

@Configuration
//@Aspect 애노테이션을 붙인 클래스를 공통 기능으로 적용하려면
//@EnableAspectJAutoProxy 애노테이션을 설정 클래스에 붙여야한다
@EnableAspectJAutoProxy
public class AppCtx {
	
	//ExeTimeAspect 클래스에서 basic_5 패키지 아래 public 메서드를 설정하므로
	//calculator 빈에 ExeTimeAspect 클래스에 정의한 공통기능인 measure()를 적용한다.
	@Bean
	public CacheAspect cacheAspect() {
		return new CacheAspect();
	}
	
	@Bean
	public ExeTimeAspect exeTimeAspect() {
		return new ExeTimeAspect();
	}

	@Bean
	public Calculator calculator() {
		return new RecCalculator();
	}
}
