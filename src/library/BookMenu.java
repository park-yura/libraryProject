package library;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class BookMenu implements Book {
//public void bookBorrow 책 대여
//public void bookReturn 책 반납
//public void printList  책 리스트 출력
//public void bookUpdate 책 수정
//public void bookAdd 책 추가
//public void bookDel 책 삭제
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//private ArrayList<BookUtil> bookutil = new ArrayList<BookUtil>();
	private ArrayList<BookUtil> bookList = new ArrayList<BookUtil>();
	private BookUtil bookutil;
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void bookBorrow() {
		System.out.println("===[도서 대여 시스템]===");
		
		try {
			String bNo;
			System.out.print("대여하고자 하는 도서번호를 입력해주세요.\n");
			bNo = br.readLine();
			boolean isbRent = false;
			
			for(int i = 0; i < bookList.size(); i++) {
				if (bNo)
			}
			System.out.print("대여하고자 하는 도서번호를 입력해주세요.");
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	@Override
	public void bookReturn() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void printBookList() {
		System.out.println("\n===[ 도서목록 ]===");
		System.out.println("전체 도서 수: " + bookList.size());
		System.out.println(bookList.toString());
		
		System.out.println();
	}
	
	@Override
	public void bookUpdate() {
		if(bookList == null) {
			System.out.println("\n수정가능한 도서가 없습니다.");
			System.out.println();
			return;
		}
		
		System.out.println("===[ 도서 정보 수정 ]===");
		try {
			BookUtil bu = new BookUtil();
			int num = 0;
			while(true) {
				if(bookList.size() != 0) { 
					do {
							
							System.out.println("========================================");
							System.out.println(bookList.toString());
							
						System.out.println("[1]도서번호\t[2]도서명\t[3]출판사\t[4]작가명\t[5]출판년도\t[6]종료\n");
						System.out.print("수정할 번호를 입력하세요 => \n");
						num = sc.nextInt();
						System.out.println();
						
					} while(num < 1 || num > 6);
					
					switch (num) {
					case 1: 
						System.out.print("수정할 정보를 입력하세요.\n");
						System.out.print("도서번호: ");
						bu.setbNo(br.readLine());
						if(readBook(bu.getbNo()) != null) {
							System.out.println("이미 등록된 도서입니다.\n");
							return;
						}
						System.out.print("도서 정보 수정이 완료되었습니다.\n");
						break;
					
					case 2:
						System.out.print("도서명: ");
						bu.setbTitle(br.readLine());
						System.out.print("도서명 수정이 완료되었습니다.\n");
						break;
						
					case 3: 
						System.out.print("출판사: ");
						bu.setbPublish(br.readLine());
						System.out.print("출판사 수정이 완료되었습니다.\n");
						break;
					case 4: 
						System.out.print("작가명: ");
						bu.setbAuthor(br.readLine());
						System.out.print("작가명 수정이 완료되었습니다.\n");
						break;
					case 5: 
						System.out.print("출판년도: ");
						bu.setbYear(br.readLine());
						System.out.print("출판연도 수정이 완료되었습니다.\n");
						break;
					case 6: 
						System.out.println("프로그램이 종료됩니다.");
						System.exit(0);
					}
					
					}
				}
			} catch (Exception e) {
				System.out.println(e.toString());
			}
	}
	
	@Override
	public void bookAdd() {
		System.out.println("\n===[도서 등록]===");

		try {
			BookUtil bu = new BookUtil();
			System.out.print("도서번호: ");
			bu.setbNo(br.readLine());
			if(readBook(bu.getbNo()) != null) {
				System.out.println("이미 등록된 도서입니다.\n");
				return;
			}
			
			System.out.print("도서명: ");
			bu.setbTitle(br.readLine());
			System.out.print("출판사: ");
			bu.setbPublish(br.readLine());
			System.out.print("작가명: ");
			bu.setbAuthor(br.readLine());
			System.out.print("출판연도: ");
			bu.setbYear(br.readLine());
			
			bookList.add(bu);
			System.out.println("책이 등록되었습니다.\n");
		} catch (Exception e) {
			System.out.println(e.toString());
		} 
		
	}
	
//	@Override
//	public void bookDel() {
//		System.out.println("===[도서 삭제 시스템]===");
//		try {
//			System.out.println("삭제할 책의 id를 입력하세요");
//			int num = sc.nextInt();
//			for (int i = 0; i < bookList.size(); i++) {
//
//				if (s == readBooklist.get(i).getId())
//
//					readCarlist.remove(i);
//
//			}
//
//			System.out.println("삭제 되었습니다.");
//			break;
//			} catch (Exception e) {
//			System.out.println(e.toString());
//		}
//	}

	private BookUtil readBook(String bNo) {
		BookUtil bu = null;
		return bu;
	}
	@Override
	public void bookDel() {
		// TODO Auto-generated method stub
		
	}
		
}


