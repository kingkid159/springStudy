package basic_6;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberListPrinter {

	private MemberDao memberDao;
	private MemberSummaryPrinter printer;
	
	public MemberListPrinter() {
	}
	
	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		members.forEach(m -> printer.print(m));
	}
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	//자동주입 가능한 빈이 두개 이상이면 자동 주입할 빈을 Qualifier로 지정한다
	//하나는 Bean 설정하는 곳에 하나는 Autowired 사용하는곳에 총 두개 지정하면 된다
	@Autowired
	public void setMemberPrinter(MemberSummaryPrinter printer) {
		this.printer = printer;
	}
}
