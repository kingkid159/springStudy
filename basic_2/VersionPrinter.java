package basic_2;

public class VersionPrinter {
	//int, long, string같은 타입의 값은 일반 코드처럼 값을 설정하면 된다
	private int majorVersion;
	private int minorVersion;
	
	public void print() {
		System.out.printf("이 프로그램의 버전은 %d.%d입니다.\n\n",
				majorVersion, minorVersion);
	}
	
	public void setMajorVersion(int majorVersion) {
		this.majorVersion = majorVersion;
	}
	
	public void setMinorVersion(int minorVersion) {
		this.minorVersion = minorVersion;
	}
}
