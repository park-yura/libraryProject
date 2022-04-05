package library;

public class BookUtil {

	private String bNo;		// 도서번호
	private String bTitle;	// 도서명
	private String bPublish;// 출판사
	private String bAuthor;	// 작가명
	private String bYear;	// 출판연도
	private boolean bRent;	// 대여 여부
	
	public BookUtil() {
		
	}

	public String getbNo() {
		return bNo;
	}

	public void setbNo(String bNo) {
		this.bNo = bNo;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbPublish() {
		return bPublish;
	}

	public void setbPublish(String bPublish) {
		this.bPublish = bPublish;
	}

	public String getbAuthor() {
		return bAuthor;
	}

	public void setbAuthor(String bAuthor) {
		this.bAuthor = bAuthor;
	}

	public String getbYear() {
		return bYear;
	}

	public void setbYear(String bYear) {
		this.bYear = bYear;
	}

	public boolean isbRent() {
		return bRent;
	}

	public void setbRent(boolean bRent) {
		this.bRent = bRent;
	}

	@Override
	public String toString() {
		return "도서목록 [도서번호=" + bNo + ", 도서명=" + bTitle + ", 출판사=" + bPublish + ", 작가명=" + bAuthor
				+ ", 출판년도=" + bYear + ", 대여여부=" + bRent + "]";
	}
	
	
}
