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
		System.out.println("도서 대여 시스템입니다.");
		System.out.println("대여하고자 하는 도서번호를 입력해주세요.");
		try {
			// 도서 전체 리스트 출력
			// 도서 번호 선택
			// 
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
		System.out.println("\n===[ 도서목록 ]===");
		System.out.println("전체 도서 수: " + bookList.size());
		for(BookUtil bu : bookList) {
			System.out.println("========================================");
			System.out.println("도서번호\t도서명\t출판사\t작가명\t출판년도");
			System.out.println("========================================");
			System.out.println(bookutil.getbNo() + "\t" + bookutil.getbTitle() + "\t" + bookutil.getPublish() 
			+ "\t" + bookutil.getbAutor() + "\t" + bookutil.getbYear());
		}
		System.out.println();
	}
	
	@Override
	public void bookUpdate() {
		if(bookutil == null) {
			System.out.println("\n수정가능한 도서가 없습니다.");
			return;
		}
		
		System.out.println("===[ 도서 정보 수정 ]===");
		try {
			BookUtil bu = readBook(bookutil.getId());
			System.out.print("기존 비밀번호를 입력하세요.\n");
			String pwd = br.readLine();
			
			if(!ut.getPwd().equals(pwd)) {
				System.out.print("비밀번호가 일치하지 않습니다.\n");
				return;
			}
			
			System.out.print("수정할 정보를 입력하세요.\n");
			ut.setPwd(br.readLine());
			
			System.out.print("도서 정보 수정이 완료되었습니다.\n");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
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


