package Bean;

public class HtmlBean {
	public String id;
	public String content;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public HtmlBean(String id, String content) {
		super();
		this.id = id;
		this.content = content;
	}
	public HtmlBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
