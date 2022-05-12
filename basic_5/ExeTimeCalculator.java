package basic_5;

//프록시 (엄밀히 말하면 프록시 보다는 데코레이터 객체에 가깝다.)
//프록시는 접근 제어 관점에 초점이 맞춰져 있다면,데코레이터는 기능 추가와 확장에 초점이 맞춰져 있기 때문
public class ExeTimeCalculator implements Calculator {

	private Calculator delegate;
	
	public ExeTimeCalculator(Calculator delegate) {
		this.delegate = delegate;
	}
	
	@Override
	public long factorial(long num) {
		// TODO Auto-generated method stub
		long start = System.nanoTime();
		 //factorial() 기능 자체를 직접 구현하기 보다는 다른 객체에 factorial()의 실행을 위임한다.
		long result = delegate.factorial(num);
		long end = System.nanoTime();
		System.out.printf("%s.factorial(%d) 실행 시간 =%d\n",
				delegate.getClass().getSimpleName(),
				num, (end - start));
		return result;
	}

}
