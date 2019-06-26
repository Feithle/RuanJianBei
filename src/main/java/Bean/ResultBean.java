package Bean;

public class ResultBean {
	public String name;
	public String value;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public ResultBean(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}
	public ResultBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
