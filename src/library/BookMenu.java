package library;

import java.io.*;
import java.util.*;
import java.text.*;

public class BookMenu implements Book {
//public void bookBorrow 책 대여
//public void bookReturn 책 반납
//public void printList  책 리스트 출력
//public void bookUpdate 책 수정
//public void bookAdd 책 추가
//public void bookDel 책 삭제
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private ArrayList<BookUtil> bookList = new ArrayList<>();
	private BookUtil bookutil;
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void bookBorrow() {
		System.out.println("===[도서 대여 시스템]===");
		System.out.println(String.valueOf(bookList));
			
		if(bookList == null) {
			System.out.println("대여 가능한 도서가 없습니다.\n");
			System.out.println();
			return;
			}
			
		System.out.print("대여할 도서번호를 입력해주세요.\n");
			String no = sc.nextLine();
			
			for(int i = 0; i < bookList.size(); i++) {
				if (no != bookList.get(i).getbNo()) { 
					if (bookList.get(i).isbRent()) {
						System.out.println("이미 대여 중인 도서입니다.\n");
					} else if (!bookList.get(i).isbRent()) {
						System.out.println("대여 완료되었습니다.\n");
						bookList.get(i).setbRent(true);
					}
				}			
			}
	}
	
	@Override
	public void bookReturn() {
		System.out.print("반납할 도서번호를 입력해주세요.\n");
		String no = sc.nextLine();
		
		for(int i = 0; i < bookList.size(); i++) {
			if (no == bookList.get(i).getbNo()) { 
				if (!bookList.get(i).isbRent()) {
					System.out.println("대여 중이 아닙니다.");
				} else if (bookList.get(i).isbRent()) {
					System.out.println("반납 완료되었습니다.");
					bookList.get(i).setbRent(false);
				}
			} 
			System.out.println("반납 가능한 도서가 없습니다.");
		}
	}
	
	@Override
	public void printBookList() {
		System.out.println("\n===[ 도서목록 ]===");
		System.out.println("전체 도서 수: " + bookList.size());
		System.out.println(String.valueOf(bookList));
		
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
						System.out.println(String.valueOf(bookList));
							
						System.out.println("[1]도서번호 [2]도서명 [3]출판사 [4]작가명 [5]출판년도 [6]메인페이지\n");
						System.out.print("수정할 번호를 입력하세요 => \n");
						num = sc.nextInt();
						System.out.println();
						
					} while(num < 1 || num > 6);
					
					switch (num) {
					case 1: 
						String bNo = getbNo("수정할 도서번호를 입력하세요.\n");
						String bNo = br.readLine();
						
						if(!bu.getbNo().equals(bNo)) {
							System.out.print("도서번호가 일치하지 않습니다.\n");
							return;
						}
						
						System.out.print("변경할 도서번호를 입력하세요.\n");
						bu.setbNo(br.readLine());
						
						System.out.print("도서번호 수정이 완료되었습니다.\n");
						break;
					
					case 2:
//						
//						System.out.print("도서명: ");
//						bookList.set(2, )
//						bu.setbTitle(br.readLine());
//						System.out.print("도서명 수정이 완료되었습니다.\n");
//						break;
						
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
						break;
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
			bu.setbRent(true);
			
			bookList.add(bu);
			System.out.println("책이 등록되었습니다.\n");
		} catch (Exception e) {
			System.out.println(e.toString());
		} 
		
	}
	
	@Override
	public void bookDel() {
		System.out.println("===[도서 삭제 시스템]===");
		 while (true) {
	            System.out.println("삭제할 도서번호를 입력해주세요");

	            String temp = sc.nextLine();

	            int cnt = 0;

	            for (int i = 0; i < bookList.size(); i++) {
	                if (temp.equals(bookList.get(i).getbNo())) {
	                    bookList.remove(i);

	                    cnt++;

	                    System.out.println("도서 삭제 완료");

	                    break;

	                }

	            } // end for

	            if (cnt == 0) {
	                System.out.println("해당 도서가 존재하지 않습니다. 도서 번호를 다시 입력하세요.");

	            } else {
	                break;

	            }

	        } 

	    }
}
	
	private BookUtil readBook(String bNo) {
		BookUtil bu = null;
		return bu;
	}
	
}



