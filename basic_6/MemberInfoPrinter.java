package basic_6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberInfoPrinter {

	private MemberDao memDao;
	private MemberPrinter printer;
	
	public void printMemberInfo(String email) {
		Member member = memDao.selectByEmail(email);
		if(member == null) {
			System.out.println("데이터 없음 \n");
			return;
		}
		printer.print(member);;
		System.out.println();
	}
	//Autowired 애노테이션은 메서드에도 붙일 수 있다.
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memDao = memberDao;
	}
	
	@Autowired
	//자동주입 가능한 빈이 두개 이상이면 자동 주입할 빈을 Qualifier로 지정한다
	//하나는 Bean 설정하는 곳에 하나는 Autowired 사용하는곳에 총 두개 지정하면 된다
	@Qualifier("printer")
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
}
