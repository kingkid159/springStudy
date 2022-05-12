package basic_5;

//프록시의 대상객체
public class ImpeCalculator implements Calculator {

	//for 문을 이용한 값 구하기
	@Override
	public long factorial(long num) {
		// TODO Auto-generated method stub
		//메서드 시작시간
		long start = System.currentTimeMillis();
		long result = 1;
		for (long i = 1; i <= num; i++) {
			result *= i;
		}
		//메서드 끝 시간
		long end = System.currentTimeMillis();
		/*
		 * System.out.printf("ImpeCalculator.factorial(%d) 실행 시간 = %d\n",
		 * num,(end-start));
		 *///runtime 구하기
		return result;
	}

}
