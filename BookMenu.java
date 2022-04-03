package library;

import java.io.*;
import java.util.*;

public class BookMenu implements Book {
//public void borrow 책 대여
//public void back 책 반납
//public void printList  책 리스트 출력
//public void bookUpdate 책 수정
//public void bookAdd 책 추가
//public void bookDel 책 삭제
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private ArrayList<BookUtil> butil = new ArrayList<BookUtil>();
	private ArrayList<BookMenu> bookList = new ArrayList<BookMenu>();
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void borrow() {
		try {
		
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	@Override
	public void back() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void bookList() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void bookUpdate() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void bookAdd() {
		System.out.print("\n===[도서 등록]===");

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
			
		} catch (Exception e) {
			System.out.println(e.toString());
		} 
		
		
	}
	@Override
	public void bookDel() {
		// TODO Auto-generated method stub
		
	}

	private BookUtil readBook(String bNo) {
		BookUtil bu = null;
		return bu;
	}	
		
}


