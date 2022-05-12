package basic_5.main;

import basic_5.ExeTimeCalculator;
import basic_5.ImpeCalculator;
import basic_5.RecCalculator;

public class MainProxy {

	public static void main(String[] args) {
		//ExeTimeCalculator 클래스를 통해 ImpeCalculator 실행 시간 출력
		ExeTimeCalculator ttCal1 = new ExeTimeCalculator(new ImpeCalculator());
		System.out.println(ttCal1.factorial(20));
		
		//ExeTimeCalculator 클래스를 통해 ImpeCalculator 실행 시간 출력
		ExeTimeCalculator ttCal2 = new ExeTimeCalculator(new RecCalculator());
		System.out.println(ttCal2.factorial(20));
	}
}
