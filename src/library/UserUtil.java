package library;

public class UserUtil {

	private String id; //회원 아이디
	private String pwd; //회원 비밀번호
	private String name; //회원 이름
	private String socialNum; //회원 주민등록번호
	
	public UserUtil(String name, String socialNumber, String id, String pwd) {
		super();
		this.name = name;
		this.socialNum = socialNum;
		this.id = id;
		this.pwd = pwd;
	}
	
	public UserUtil() {
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSocialNum() {
		return socialNum;
	}
	public void setSocialNum(String socialNum) {
		this.socialNum = socialNum;
	}
	
	@Override
	public String toString() {
		return "[아이디=" + id + ", 비밀번호=" + pwd + ", 이름=" + name + ", 주민등록번호=" + socialNum + "]\n";
	}
	
}
