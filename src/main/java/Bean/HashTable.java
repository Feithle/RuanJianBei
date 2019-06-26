package Bean;

public class HashTable {
    public int data;
    public int isNull;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getIsNull() {
        return isNull;
    }

    public void setIsNull(int isNull) {
        this.isNull = isNull;
    }

    public HashTable(int data, int isNull) {
        this.data = data;
        this.isNull = isNull;
    }

    public HashTable() {
        super();
    }

}
