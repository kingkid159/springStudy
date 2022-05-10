package basic_4.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import basic_4.ChangePasswordService;
import basic_4.MemberDao;
import basic_4.MemberInfoPrinter;
import basic_4.MemberListPrinter;
import basic_4.MemberPrinter;
import basic_4.MemberRegisterService;
import basic_4.MemberSummaryPrinter;
import basic_4.VersionPrinter;


@Configuration	//스프링 설정클래스를 의미, 이 애노테이션을 붙여야 스프링 설정 클래스로 사용할 수 있다.
//Component를 붙인 클래스를 검색해서 빈으로 등록해주기 때문에 설정코드가 줄어듦
@ComponentScan(basePackages = {"basic_4"})//basePackage 속성은 스캔 대상 패키지 목록을 지정
public class AppCtx {

	@Bean
	@Qualifier("printer")
	public MemberPrinter memberPrinter1() {
		return new MemberPrinter();
	}
	
	@Bean
	@Qualifier("summaryPrinter")
	public MemberSummaryPrinter memberPrinter2() {
		return new MemberSummaryPrinter();
	}
	
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
}
