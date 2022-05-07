package basic_2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import basic_2.ChangePasswordService;
import basic_2.MemberDao;
import basic_2.MemberRegisterService;

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
}
