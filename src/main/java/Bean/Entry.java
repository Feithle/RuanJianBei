package Bean;

public class Entry<T> {
    int key;
    T item;
    Entry<T> next;

    public Entry(int key, T item, Entry<T> next) {
        this.key = key;
        this.item = item;
        this.next = next;
    }
}
