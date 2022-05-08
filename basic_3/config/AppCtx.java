package basic_3.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import basic_3.ChangePasswordService;
import basic_3.MemberDao;
import basic_3.MemberInfoPrinter;
import basic_3.MemberListPrinter;
import basic_3.MemberPrinter;
import basic_3.MemberRegisterService;
import basic_3.MemberSummaryPrinter;
import basic_3.VersionPrinter;


@Configuration	//스프링 설정클래스를 의미, 이 애노테이션을 붙여야 스프링 설정 클래스로 사용할 수 있다.
public class AppCtx {

	@Bean	//해당 메서드가 생성한 객체를 스프링 빈이라고 설정
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService();
	}
	
	@Bean
	public ChangePasswordService changePwdSvc() {
		return new ChangePasswordService();
	}
	//자동주입 가능한 빈이 두개 이상이면 자동 주입할 빈을 Qualifier로 지정한다
	//하나는 Bean 설정하는 곳에 하나는 Autowired 사용하는곳에 총 두개 지정하면 된다
	@Bean
	@Qualifier("printer")
	public MemberPrinter memberPrinter1() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberSummaryPrinter memberPrinter2() {
		return new MemberSummaryPrinter();
	}
	
	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter();
	}
	//Autowired를 통한 의존 주입
	@Bean
	public MemberInfoPrinter infoPrinter() {
		return new MemberInfoPrinter();
	}
	
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
}
