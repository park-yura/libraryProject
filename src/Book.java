package library;

public interface Book {

	public void borrow();     // 책 대여
	public void back();       // 책 반납
	public void bookList();   // 책 리스트 출력
	public void bookUpdate(); // 책 수정
	public void bookAdd();    // 책 추가
	public void bookDel();    // 책 삭제
}
