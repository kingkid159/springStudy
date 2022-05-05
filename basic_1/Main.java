package basic_1;
//AnnotationConfigApplicationContext는 자바 설정에서 정보를 일겅와 빈 객체를 생성하고 관리
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		/*
		 * AnnotationConfigApplicationContext를 생성할 때 AppContext클래스를 생성자 파라미터로 전달
		 * AnnotationConfigApplicationContext는 AppContext에 정의한 @Bean 설정 정보를 읽어와
		 * Greeter객체를 생성하고 초기화
		 */
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(AppContext.class);
		/*
		 * getBean메서드는 AnnotationConfigApplicationContext가 자바 설정을 읽어와 생성한 빈을 검색할 때 사용
		 * getBean()메서드의 첫번째 파라미터는 @Bean 어노테이션의 메서드의 이름,두번째 파라미터는 검색할 빈 객체의 타입
		 * 
		 */
		Greeter g = ctx.getBean("greeter", Greeter.class);
		String msg = g.greet("스프링");
		System.out.println(msg);
		ctx.close();
	}
}
