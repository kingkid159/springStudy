package basic_2;

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
	//세터 메서드는 MemberDao 타입의 객체와 MemberPrinter 타입의 객체데 대한 의존을 주입할 때 사용
	public void setMemberDao(MemberDao memberDao) {
		this.memDao = memberDao;
	}
	
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
}
