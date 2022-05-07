package basic_2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import basic_2.ChangePasswordService;
import basic_2.MemberDao;
import basic_2.MemberInfoPrinter;
import basic_2.MemberListPrinter;
import basic_2.MemberPrinter;
import basic_2.MemberRegisterService;
import basic_2.VersionPrinter;

@Configuration	//스프링 설정클래스를 의미, 이 애노테이션을 붙여야 스프링 설정 클래스로 사용할 수 있다.
public class AppCtx {

	@Bean	//해당 메서드가 생성한 객체를 스프링 빈이라고 설정
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}
	
	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao());
		return pwdSvc;
	}
	
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter(memberDao(), memberPrinter());
	}
	//세터 매서드를 사용한 의존 주입
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemberDao(memberDao());
		infoPrinter.setPrinter(memberPrinter());
		return infoPrinter;
	}
	
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
}
