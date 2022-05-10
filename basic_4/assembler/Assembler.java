package basic_4.assembler;

import basic_4.ChangePasswordService;
import basic_4.MemberDao;
import basic_4.MemberRegisterService;

public class Assembler {

	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	
	//의존 주입
	public Assembler() {
		//의존 객체를 변경하려면 조립기의 코드만 수정하면 됨
		memberDao = new MemberDao(); //ex memberDao = new CacheMemberDao();
		//생성자를 통해 의존 주입
		regSvc = new MemberRegisterService(memberDao);
		pwdSvc = new ChangePasswordService();
		//세터를 통해 의존주입
		pwdSvc.setMemberDao(memberDao);
	}
	
	public MemberDao getMemberDao() {
		return memberDao;
	}
	
	public MemberRegisterService getMemberRegisterService() {
		return regSvc;
	}
	
	public ChangePasswordService getChangePasswordService() {
		return pwdSvc;
	}
}
