package basic_5.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect //Aspect로 사용할 클래스
public class ExeTimeAspect {

	//basic_5패키지와 그 하위 패키지에 위치한 타입의 public 메서드를 pointcut으로 설정
	@Pointcut("execution(public * basic_5..*(..))") 
	private void publicTarget() {
	}
	
	//publicTarget() 메서드에 정의한 Pointcut에 공통 기능을 적용
	@Around("publicTarget()")
	//ProceedingJoinPoint 타입 파라미터는 프록시 대상 객체의 메서드를 호출할 때 사용
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.nanoTime();
		try {
			//proceed로 대상 객체의 메서드를 호출한다.
			//이 코드를 입력하면 메서드가 실행 되므로 이전과 이후에 공통 기능을 위한 코드를 위치 시키면된다 (여기선 시간 계산 코드)
			Object result = joinPoint.proceed();
			return result;
		} finally {
			long finish = System.nanoTime();
			//getSignature() 메서드는 시그니처를 구할 때
			Signature sig = joinPoint.getSignature();
			//실행시간 출력 코드
			System.out.printf("%s.%s(%s) 실행 시간 : %d ns\n",
					//getTarget() 메서드는 대상객체를 구할 때
					joinPoint.getTarget().getClass().getSimpleName(),
					//getName() 메서드는 인자 목록을 구할 때
					sig.getName(),Arrays.toString(joinPoint.getArgs()),
					(finish - start));
		}
	}
}
