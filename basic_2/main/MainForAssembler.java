package basic_2.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import basic_2.ChangePasswordService;
import basic_2.DuplicateMemberException;
import basic_2.MemberNotFoundException;
import basic_2.MemberRegisterService;
import basic_2.RegisterRequest;
import basic_2.WrongIdPasswordException;
import basic_2.assembler.Assembler;

//메인 메서드
public class MainForAssembler {

	public static void main(String[] args) throws IOException{
		//콘솔에서 입력받기 위해 System.in을 이용해서 BufferedReader를 생성
		BufferedReader reader =
				new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("명령어를 입력하세요");
			//BufferReader#readLine()메서드를 이용해서 콘솔에서 한 줄을 입력받는다
			String command = reader.readLine();
			//입력한 문자열이 exit면 프로그램을 종료
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("종료합니다.");
				break;
			}
			//입력한 문자열이 new로 시작하면 processNewCommand()메서드를 실행한다
			if(command.startsWith("new ")) {
				processNewCommand(command.split(" ")); //공백을 구분자로 문자열을 배열로 만든다
				continue;
			//입력한 문자열이 change로 시작하면 processChangeCommand()메서드를 실행한다
			} else if (command.startsWith("change ")) {
				processChangeCommand(command.split(" ")); //공백을 구분자로 문자열을 배열로 만든다
				continue;
			}
			//명령어를 잘못 입력한 경우 도움말을 출력해주는 printHelp()메서드를 실행한다
			printHelp();
		}
	}
	//Assembler를 사용하는 코드
	private static Assembler assembler = new Assembler();
	
	private static void processNewCommand(String[] arg) {
		//입력한 값이 5개가 아닐경우
		if(arg.length != 5) {
			printHelp();
			return;
		}
		MemberRegisterService regSvc = assembler.getMemberRegisterService();
		RegisterRequest req = new RegisterRequest();
		req.setEmail(arg[1]);
		req.setName(arg[2]);
		req.setPassword(arg[3]);
		req.setConfirmPassword(arg[4]);
		
		//입력한 암호 값이 올바르지 않을 때
		if(!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("암호와 확인이 일치하지 않습니다.\n");
			return;
		}
		try {
			regSvc.regist(req);
			System.out.println("등록했습니다.\n");
			
		//동일한 이메일을 가진 회원이 이미 있을때
		} catch (DuplicateMemberException e) {
			System.out.println("이미 존재하는 이메일입니다.\n");
		}
	}
	
	private static void processChangeCommand(String[]arg) {
		//입력값이 4개가 아닐 때
		if(arg.length != 4) {
			printHelp();
			return;
		}
		ChangePasswordService changePwdSvc =
				assembler.getChangePasswordService();
		try {
			changePwdSvc.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("암호를 변경했습니다.\n");
			
		//변경을 원하는 회원의 이메일이 없을때
		} catch (MemberNotFoundException e) {
			System.out.println("존재하지 않는 이메일입니다.\n");
			
		//변경을 원하는 회원의 이메일이나 암호가 일치하지 않을 때
		} catch (WrongIdPasswordException e) {
			System.out.println("이메일과 암호가 일치하지 않습니다.");
		}
	}
	//나머지코드
	private static void printHelp() {
		System.out.println();
		System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요.");
		System.out.println("명령어 사용법.");
		System.out.println("new 이메일 이름 암호 암호확인.");
		System.out.println("change 이메일 현재비번 변경비번.");
		System.out.println();
	}
}
