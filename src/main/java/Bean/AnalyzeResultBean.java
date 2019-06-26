package Bean;

public class AnalyzeResultBean {
	public String Mac;
	public String Watermarkcontent;
	public String Result;
	public String getMac() {
		return Mac;
	}
	public void setMac(String mac) {
		Mac = mac;
	}
	public String getWatermarkcontent() {
		return Watermarkcontent;
	}
	public void setWatermarkcontent(String watermarkcontent) {
		this.Watermarkcontent = watermarkcontent;
	}
	public String getResult() {
		return Result;
	}
	public void setResult(String result) {
		Result = result;
	}
	public AnalyzeResultBean(String mac, String watermarkcontent, String result) {
		super();
		Mac = mac;
		this.Watermarkcontent = watermarkcontent;
		Result = result;
	}
	public AnalyzeResultBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
