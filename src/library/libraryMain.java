package library;

import java.util.Scanner;

public class libraryMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserMenu user = new UserMenu();
		BookMenu book = new BookMenu();
		int num;
		
		while(true) {
			//로그인하기 전
			if(user.loginMember() == null) { 
				do {
					System.out.println("[1]로그인 \t[2]회원가입\t[3]종료");
					System.out.print("이용하고자 하는 서비스 번호를 입력하세요 => ");
					num = sc.nextInt();
				} while(num < 1 || num > 3);
				
				switch (num) {
				case 1: 
					user.login();
					System.out.println();
					break;
					
				case 2:
					user.join();
					System.out.println();
					break;
					
				case 3: 
					System.out.println("프로그램이 종료됩니다.");
					System.exit(0);
			}
			
		// 관리자 계정으로 로그인한 경우	
		} else if(user.loginMember().getId() == "admin") {
			do {
				System.out.println("[1]도서관리\t[2]회원관리\t[3]로그아웃\t[4]종료");
				System.out.print("이용하고자 하는 서비스 번호를 입력하세요 => ");
				num = sc.nextInt();
			} while (num < 1 || num > 4);
			
			switch (num) {
			case 1: do {
				System.out.println("[1]도서등록\t[2]도서수정\t[3]도서삭제\t[4]도서조회\t[5]메인페이지");
				System.out.print("이용하고자 하는 서비스 번호를 입력하세요 => ");
				num=sc.nextInt();
				
			} while (num < 1 || num > 5);
			
			switch (num) {
			
				case 1:
					book.bookAdd();
					break;
					
				case 2:
					book.bookUpdate();
					break;
					
				case 3:
					book.bookDel();
					break;
					
				case 4:
					book.printBookList();
					break;
					
				case 5:
					break;
				} 
				break;
		
		
			case 2: do {
				System.out.println("[1]회원 리스트\t[2]메인페이지");
				System.out.print("이용하고자 하는 서비스 번호를 입력하세요 => ");
				num = sc.nextInt();
			} while(num < 1 || num > 2);
			switch(num) {
			case 1: //회원리스트
				user.printUserList();
				break;
		
			case 2:
				break;
			}
			break;
			
			case 3: 
				user.logout();
				break;
			}
		}
		
		// 일반 사용자 로그인
		else {
			do {
				System.out.println("[1]도서대여\t[2]도서반납\t[3]도서조회\t[4]비밀번호 변경\t[5]로그아웃\t[6]탈퇴");
				System.out.print("이용하고자 하는 서비스 번호를 입력하세요 => ");
				num = sc.nextInt();
				
			} while(num < 1 || num > 6);
			switch(num) {
			case 1:
				book.bookRent();
				break;
			
			case 2:
				book.bookRent();
				break;
				
			case 3:
				book.printBookList();
				break;
				
			case 4:
				user.userUpdate();
				break;
				
			case 5:
				user.logout();
				break;
				
			case 6:
				user.userDel();
				break;
			}
		
			}
		}
	}
}
	

