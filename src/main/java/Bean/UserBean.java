package Bean;

public class UserBean {
    public String markContent;//the watermark
    public String key;
    public int N;

    public String getMarkContent() {
        return markContent;
    }

    public void setMarkContent(String markContent) {
        this.markContent = markContent;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getN() {
        return N;
    }

    public void setN(int n) {
        N = n;
    }

    public UserBean(String markContent, String key, int n) {
        this.markContent = markContent;
        this.key = key;
        N = n;
    }

    public UserBean() {
        super();
        // TODO Auto-generated constructor stub
    }
}
