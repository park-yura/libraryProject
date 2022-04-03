package library;
// 사용자 인터페이스 구현
public interface User {
	public void join(); // 회원가입
	public void login(); // 로그인
	public void logout(); // 로그아웃
	public void printUserList();  // 회원 리스트 출력
	public void userUpdate(); // 회원 정보 수정
	public void userDel(); // 회원 삭제	
}
