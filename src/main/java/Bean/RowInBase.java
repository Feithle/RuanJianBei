package Bean;

public class RowInBase {
    public int id;
    public int mod;//relying this to sort
    public int hashvalue;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMod() {
		return mod;
	}
	public void setMod(int mod) {
		this.mod = mod;
	}
	public int getHashvalue() {
		return hashvalue;
	}
	public void setHashvalue(int hashvalue) {
		this.hashvalue = hashvalue;
	}
	public RowInBase(int id, int mod, int hashvalue) {
		super();
		this.id = id;
		this.mod = mod;
		this.hashvalue = hashvalue;
	}
	public RowInBase() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    }

