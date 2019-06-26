package Bean;

public class DataBeansForSort {
	public int id;
	public String content;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public DataBeansForSort(int id, String content) {
		super();
		this.id = id;
		this.content = content;
	}
	public DataBeansForSort() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
