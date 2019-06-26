package Bean;

public class UserMassage {
	public String userkey;
	public String content;
	public String time_comment;
	public String getUserkey() {
		return userkey;
	}
	public void setUserkey(String userkey) {
		this.userkey = userkey;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime_comment() {
		return time_comment;
	}
	public void setTime_comment(String time_comment) {
		this.time_comment = time_comment;
	}
	public UserMassage(String userkey, String content, String time_comment) {
		super();
		this.userkey = userkey;
		this.content = content;
		this.time_comment = time_comment;
	}
	public UserMassage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
