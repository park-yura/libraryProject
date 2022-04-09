package library;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class UserMenu implements User {

	Scanner sc = new Scanner(System.in);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private ArrayList<UserUtil> userList = new ArrayList<UserUtil>();
	private UserUtil userutil;
	
	//public void join 회원가입
	//public void login 로그인
	//public void logout 로그아웃
	//public void printUserList  회원 리스트 출력
	//public void userUpdate 회원 정보 수정
	//public void userDel 회원 탈퇴	
	
	// 관리자 아이디 입력시켜서 관리자 로그인
	public UserMenu() {
		UserUtil ut = new UserUtil();
		ut.setName("관리자");
		ut.setId("admin");
		ut.setPwd("admin");
		ut.setSocialNum("null");
		userList.add(ut);	
	}
	
	@Override
	public void join() {
		System.out.println("\n=====[ 회원가입 ]=====");
		try {
			UserUtil ut = new UserUtil();
			
			System.out.print("이름: ");
			ut.setName(br.readLine());
			
			System.out.print("주민등록번호: ");
			ut.setSocialNum(br.readLine());
			
			if (readUser(ut.getSocialNum()) != null) {
				System.out.println("이미 등록된 사용자입니다.\n");
				return;
			}
				
			System.out.print("아이디: ");
			ut.setId(br.readLine());
			if(readUser(ut.getId()) != null) {
				System.out.println("이미 등록된 아이디입니다.\n");
				return;
			}
			
			System.out.print("비밀번호: ");
			ut.setPwd(br.readLine());
			
			userList.add(ut);
			System.out.println("회원가입이 완료되었습니다.");
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	@Override
	public void login() {
		System.out.println("\n=====[ 로그인 ]=====");
		String id, pwd;
		
		try {
			System.out.print("아이디: ");
			id = br.readLine();
			
			System.out.print("비밀번호: ");
			pwd = br.readLine();
			
			// 아이디, 비밀번호가 회원리스트 정보와 일치하는지 확인
			UserUtil ut = readUser(id);
			if(ut != null) {
				if(ut.getPwd().equals(pwd)) {
					userutil = ut;
					return;
				}
			}
			System.out.println("아이디 또는 패스워드가 일치하지 않습니다.");
			
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	@Override
	public void logout() {
		userutil = null;
		System.out.println("로그아웃이 완료되었습니다.\n");
		
	}

	@Override
	public void printUserList() {
		System.out.println("\n=====[ 회원명단 ]=====");
		System.out.println("전체 회원 수: " + userList.size());

		for(UserUtil data: userList) {
			System.out.println("[ " + data + " ]\n");
			
		} 
	}

	@Override
	public void userUpdate() {
		if(userutil == null) {
			System.out.println("\n로그인이 필요합니다.");
			return;
		}
		
		System.out.println("\n=====[ 비밀번호 수정 ]=====");
		try {
			UserUtil ut = readUser(userutil.getId());
			System.out.print("기존 비밀번호를 입력하세요 => ");
			String pwd = br.readLine();
			
			if(!ut.getPwd().equals(pwd)) {
				System.out.print("비밀번호가 일치하지 않습니다.\n");
				return;
			}
			
			System.out.print("변경할 비밀번호를 입력하세요 => ");
			ut.setPwd(br.readLine());
			
			System.out.print("비밀번호 수정이 완료되었습니다.\n");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	@Override
	public void userDel() {
		System.out.println("\n=====[ 회원 탈퇴 ]=====");
		try {
			UserUtil ut = readUser(userutil.getId());
			if(userutil.getId() != "admin") {
				System.out.print("탈퇴하시겠습니까?(예: y 아니오: n) => ");
				String answer = br.readLine();
					if(answer.equals("y") || answer.equals("Y")) {
						System.out.print("비밀번호 입력: ");
						String pwd = br.readLine();
						if(!ut.getPwd().equals(pwd)) {
							System.out.print("비밀번호가 일치하지 않습니다.\n");
							return;
						}
						userList.remove(userutil.getId());
					} else if (answer.equals("n") || answer.equals("N")) {
						System.out.print("회원 탈퇴 시스템을 취소하셨습니다.\n");
						System.out.println();
						return;
					} else {
						System.out.println("y나 n을 입력해주세요.\n");
						System.out.println();
						return;
					}
			
					System.out.println("회원 탈퇴가 완료되었습니다.\n");
					System.exit(0);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	private UserUtil readUser(String id) {
		UserUtil ut = null;
		
		for(UserUtil data : userList) {
			if(data.getId().equals(id)) {
				ut = data;
				break;
			}
		}
		return ut;
	}
	
	public UserUtil loginMember() {
		return userutil;
	}
	
}
