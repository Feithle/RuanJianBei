package Bean;

//locate the position in a cell
public class LengthTarget {
    public int row;
    public int order;//the position of the mark in a sentence.

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public LengthTarget(int row, int order) {
        this.row = row;
        this.order = order;
    }

    public LengthTarget() {
        super();
        // TODO Auto-generated constructor stub
    }
}
