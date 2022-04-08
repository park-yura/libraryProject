package library;

import java.io.*;
import java.util.*;

public class BookMenu implements Book {
//public void bookRent 책 대여/반납
//public void printList  책 리스트 출력
//public void bookUpdate 책 수정
//public void bookAdd 책 추가
//public void bookDel 책 삭제
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private ArrayList<BookUtil> bookList = new ArrayList<>();
	private BookUtil bookutil;
	private boolean flag = true;
	Scanner sc = new Scanner(System.in);
	
	//도서 대여/반납 시스템
	@Override
	public void bookRent() { 
		while (true) {
			System.out.println("\n=====[ 도서 대여/반납 ]=====");
			System.out.println(String.valueOf(bookList)); //도서 정보 조회
			
            System.out.println("해당 도서 번호를 입력해주세요");
            String num = sc.nextLine();
            int cnt = 0;
            for (int i = 0; i < bookList.size(); i++) {
                if (num.equals(bookList.get(i).getbNo())) {
                    cnt++;
                    boolean bStatus = bookList.get(i).isbRent();
 
                    if (bStatus) {
                    	bStatus = false;
                        System.out.println("도서가 반납되었습니다.");
                    } else {
                    	bStatus = true;
                        System.out.println("도서가 대여되었습니다.");
                    }
                    bookList.get(i).setbRent(bStatus);
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

	// 도서 조회 시스템
	@Override
	public void printBookList() {
		System.out.println("\n=====[ 도서목록 ]=====");
		System.out.println("전체 도서 수: " + bookList.size());
		for(BookUtil data: bookList) {
			System.out.println("[ " + data + " ]\n");
		}
		
		System.out.println();
	}
	
	// 도서 수정 시스템
	@Override
	public void bookUpdate() {
		
		if(bookList == null) {
			System.out.println("\n수정가능한 도서가 없습니다.");
			System.out.println();
			return;
		}

		try {
			
			System.out.println("\n=====[ 도서 정보 수정 ]=====");
			
			while(true) {
				
				
			if(bookList.size() != 0) { 
				int num = 0;
				int i = 0;
				for(BookUtil data: bookList) {
					System.out.println("[ " + data + " ]\n");
				}
				do {
				System.out.println("\n[1]도서명  [2]출판사  [3]작가명  [4]출판년도  [5]메인페이지");
				System.out.print("해당 도서의 수정할 목록의 번호를 입력하세요 => ");
				num = sc.nextInt();
				
				} while(num < 1 || num > 6);
				switch (num) {
				
				case 1: 
					
					System.out.print("수정할 도서번호를 입력하세요 => ");
					String bNo = br.readLine();
	
					for (i = 0; i < bookList.size(); i++) {
						if(bookList.get(i).getbNo().equals(bNo)) {
							System.out.print("새로운 도서명을 입력하세요 => ");
							String bTitle = br.readLine();
							bookList.get(i).setbTitle(bTitle);
							System.out.println("변경되었습니다.\n");
							flag = true;
							
						}
					}
					break;
					
				case 2:
					
					System.out.print("수정할 도서번호를 입력하세요 => ");
					bNo = br.readLine();
					flag = false;
					
					for (i = 0; i < bookList.size(); i++) {
						if(bookList.get(i).getbNo().equals(bNo)) {
							System.out.print("새로운 출판사명을 입력하세요 => ");
							String bPublic = br.readLine();
							bookList.get(i).setbPublish(bPublic);
							System.out.println("변경되었습니다.");
							flag = true;
							
						}
					}
					break;
					
				case 3:
					
					System.out.print("수정할 도서번호를 입력하세요 => ");
					bNo = br.readLine();
					flag = false;
					
					for (i = 0; i < bookList.size(); i++) {
						if(bookList.get(i).getbNo().equals(bNo)) {
							System.out.print("새로운 작가명을 입력하세요 => ");
							String bAuthor = br.readLine();
							bookList.get(i).setbAuthor(bAuthor);
							System.out.println("변경되었습니다.");
							flag = true;
							
						}
					}
					break;
					
				case 4:
					
					System.out.print("수정할 도서번호를 입력하세요 => ");
					bNo = br.readLine();
					flag = false;
					
					for (i = 0; i < bookList.size(); i++) {
						if(bookList.get(i).getbNo().equals(bNo)) {
							System.out.print("새로운 출판년도를 입력하세요 => ");
							String bYear = br.readLine();
							bookList.get(i).setbYear(bYear);
							System.out.println("변경되었습니다.");
							flag = true;
							
						}
					}
					break;
					
				case 5:
					return;
					}
				break;
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
	}
}		
	

	@Override
	public void bookAdd() {
		System.out.println("\n=====[ 도서 등록 ]=====");
		
		try {			
			BookUtil bu = new BookUtil();
			FileWriter fw = new FileWriter("BookInfo.txt", false);

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
			System.out.print("출판년도: ");
			bu.setbYear(br.readLine());
			
			fw.write("도서번호: " + bu.getbNo() + ", 도서명: " + bu.getbTitle() + ", 출판사: " + bu.getbTitle() + ", 작가명: " + bu.getbAuthor() + ", 출판년도: " + bu.getbYear()+"\r\n");
	
			fw.close();
			
			bookList.add(bu);
			System.out.println("책이 등록되었습니다.\n");
			}catch(IOException e) {
				e.printStackTrace();
			}
		
}
	
	@Override
	public void bookDel() {
		try {
			
		System.out.println("\n======[ 도서 삭제 ]======");
		 
		while (true) {
			for(BookUtil data: bookList) {
				System.out.println("[ " + data + " ]\n");
			}
	            System.out.print("\n삭제할 도서번호를 입력해주세요 => ");
	            String bNo = br.readLine();
	            int cnt = 0;

	            for (int i = 0; i < bookList.size(); i++) {
	                if (bookList.get(i).getbNo().equals(bNo)) {
	                    bookList.remove(i);
	                    cnt++;
	                    System.out.println("도서 삭제가 완료되었습니다.\n");
	                    break;
	                }
	            } 
	            
	            if (cnt == 0) {
	                System.out.println("해당 도서가 존재하지 않습니다. 도서 번호를 다시 입력하세요.\n");
	            } else {
	                break;
	                
	            }
	        } 
	} catch (Exception e) {
		System.out.println(e.toString());
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



