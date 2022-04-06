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
					System.out.println("대여 중이 아닙니다.\n");
				} else if (bookList.get(i).isbRent()) {
					System.out.println("반납 완료되었습니다.\n");
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

		try {
			
			System.out.println("===[ 도서 정보 수정 ]===");
			
			while(true) {
				
				
			if(bookList.size() != 0) { 
				int num = 0;
				
				System.out.println(String.valueOf(bookList));
				
				System.out.println("[1]도서번호 [2]도서명 [3]출판사 [4]작가명 [5]출판년도 [6]메인페이지\n");
				System.out.print("해당 도서의 수정할 목록의 번호를 입력하세요 => \n");
				num = sc.nextInt();
			
				switch (num) {
				
				case 1: 
					String bNo = br.readLine();
					boolean flag = false;
					int i = 0;
					
					System.out.println("수정할 도서번호를 입력하세요 => ");
					bNo = br.readLine();
					flag = false;
			
					for (i = 0; i < bookList.size(); i++) {
						if(bookList.get(i).getbNo().equals(bNo)) {
							System.out.print("새로운 도서번호를 입력하세요.");
							String bNo1 = br.readLine();
							bookList.get(i).setbTitle(bNo1);
							System.out.println("변경되었습니다.");
							flag = true;
							break;
						}
					}
					
				case 2:
					
					System.out.println("수정할 도서번호를 입력하세요 => ");
					bNo = br.readLine();
					flag = false;
					
					for (i = 0; i < bookList.size(); i++) {
						if(bookList.get(i).getbNo().equals(bNo)) {
							System.out.print("새로운 도서명을 입력하세요.");
							String bTitle = br.readLine();
							bookList.get(i).setbTitle(bTitle);
							System.out.println("변경되었습니다.");
							flag = true;
							break;
						}
					}
					
				case 3:
					
					System.out.println("수정할 도서번호를 입력하세요 => ");
					bNo = br.readLine();
					flag = false;
					
					for (i = 0; i < bookList.size(); i++) {
						if(bookList.get(i).getbNo().equals(bNo)) {
							System.out.print("새로운 출판사명을 입력하세요.");
							String bPublic = br.readLine();
							bookList.get(i).setbTitle(bPublic);
							System.out.println("변경되었습니다.");
							flag = true;
							break;
						}
					}
					
				case 4:
					
					System.out.println("수정할 도서번호를 입력하세요 => ");
					bNo = br.readLine();
					flag = false;
					
					for (i = 0; i < bookList.size(); i++) {
						if(bookList.get(i).getbNo().equals(bNo)) {
							System.out.print("새로운 작가명을 입력하세요.");
							String bAutor = br.readLine();
							bookList.get(i).setbTitle(bAutor);
							System.out.println("변경되었습니다.");
							flag = true;
							break;
						}
					}
					
				case 5:
					
					System.out.println("수정할 도서번호를 입력하세요 => ");
					bNo = br.readLine();
					flag = false;
					
					for (i = 0; i < bookList.size(); i++) {
						if(bookList.get(i).getbNo().equals(bNo)) {
							System.out.print("새로운 출판년도를 입력하세요.");
							String bYear = br.readLine();
							bookList.get(i).setbTitle(bYear);
							System.out.println("변경되었습니다.");
							flag = true;
							break;
						}
					}
					
				case 6:
					return;
					}
				break;
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
	}
}		
		
		/*
		
		
		System.out.println("===[ 도서 정보 수정 ]===");
		try {
//			BookUtil bu = new BookUtil();
			BookUtil bu = readBook(bookutil.getbNo());
			int num = 0;
			while(true) {
				if(bookList.size() != 0) { 
					do {
						System.out.println(String.valueOf(bookList));
							
						System.out.print("수정할 도서번호를 입력하세요.\n");
						String bNo = br.readLine();
						
						System.out.println("[1]도서번호 [2]도서명 [3]출판사 [4]작가명 [5]출판년도 [6]메인페이지\n");
						System.out.print("해당 도서의 수정할 목록의 번호를 입력하세요 => \n");
						num = sc.nextInt();
						
					} while(num < 1 || num > 6);
					
					switch (num) {
					case 1: 
						
						
						System.out.print("수정할 도서번호를 입력하세요.\n");
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
						return;
					}
					
					}
				}
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			*/
	

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
	
	@Override
	public void bookDel() {
		System.out.println("===[도서 삭제 시스템]===");
		 while (true) {
	            System.out.println("삭제할 도서번호를 입력해주세요");
	            String num = sc.nextLine();
	            int cnt = 0;

	            for (int i = 0; i < bookList.size(); i++) {
	                if (num.equals(bookList.get(i).getbNo())) {
	                    bookList.remove(i);
	                    cnt++;
	                    System.out.println("도서 삭제 완료");
	                    break;
	                }
	            } 
	            
	            if (cnt == 0) {
	                System.out.println("해당 도서가 존재하지 않습니다. 도서 번호를 다시 입력하세요.");
	            } else {
	                break;
	                
	            }
	        } 
	    }

	
	private BookUtil readBook(String bNo) {
		BookUtil bu = null;
		
		for(BookUtil data : bookList) {
			if(data.getbNo().equals(bNo)) {
				bu = data;
				break;
			}
		}
		return bu;
	}
}



