package deque;

public interface Deque<T> {

    public void addFirst(T i);
    public void addLast(T i);
    default public boolean isEmpty()
    {
        return size() == 0;
    }
    public int size();
    public void printDeque();
    public T removeFirst();
    public T removeLast();
    public T get(int index);
}
