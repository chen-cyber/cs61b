package deque;


import java.util.Iterator;

public class LinkedListDeque <T> implements Iterable<T>{

    private class Node{
        private T item;
        private Node pre;
        private Node next;

        Node(T i,Node p, Node n){
            item = i;
            pre = p;
            next = n;
        }
    }
    private Node sentinel;
    private Node lastNode;
    int size;

    public LinkedListDeque()
    {
        sentinel = new Node(null,null,null);
        lastNode = sentinel;
        size = 0;
    }

    public LinkedListDeque(T x)
    {
        sentinel = new Node(null, null, null);
        sentinel.next = new Node(x, sentinel,null);
        lastNode = sentinel.next;
        size = 1;
    }

    public void addFirst(T item)
    {
        Node n = new Node(item,sentinel,sentinel.next);
        size += 1;
        if(size == 1)
        {
            sentinel.next = n;
            lastNode = sentinel.next;
        }
        else
        {
            sentinel.next.pre = n;
            sentinel.next = n;
        }

    }

    public void addLast(T item)
    {
        lastNode.next = new Node(item, lastNode,null);
        lastNode = lastNode.next;
        size += 1;
    }
    public boolean isEmpty()
    {
        if(size == 0)
        {
            return true;
        }
        return false;
    }
    public int size()
    {
        return size;
    }
    public void printDeque()
    {
        Node current = sentinel.next;
        if (current == null)
        {
            return;
        }
        while(current != lastNode)
        {
            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.print(current.item);
        System.out.println();
    }
    public T removeFirst()
    {
        Node first = sentinel.next;
        if(size == 0)
        {
            return null;
        }
        if(size == 1)
        {
            sentinel.next = null;
            lastNode = sentinel.next;
        }
        else
        {
            first.next.pre = sentinel;
            sentinel.next = first.next;
        }
        size -= 1;
        return first.item;
    }

    public T removeLast()
    {
        if(lastNode == sentinel)
            return null;
        Node last = lastNode;
        lastNode.pre.next = null;
        lastNode = lastNode.pre;
        size -= 1;
        return last.item;
    }
    public T get(int index)
    {
        if(isEmpty())
            return null;
        Node current = sentinel.next;
        int j = 0;
        while(current != null && j <= index)
        {
            current = current.next;
            j += 1;
        }
        if (j == index + 1 && current != null) return current.item;
        return null;
    }


    private class LinkedListedDequeIterator implements Iterator<T>
    {
        private int wisPos;
        public LinkedListedDequeIterator()
        {
            wisPos = 0;
        }
        public boolean hasNext()
        {
            return wisPos < size;
        }
        public T next()
        {
            T returnItem = get(wisPos);
            wisPos += 1;
            return returnItem;
        }

    }
    public Iterator<T> iterator()
    {
        LinkedListedDequeIterator temp = new LinkedListedDequeIterator();
        return temp;
    }
    @Override
    public boolean equals(Object o)
    {
        if(o instanceof LinkedListDeque)
        {
            LinkedListDeque<T> o2 = (LinkedListDeque<T>) o;
            if(o2.size() != this.size())
            {
                return false;
            }
            for(int i = 0; i < this.size(); i++)
            {
                if(this.get(i) != o2.get(i))
                {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    public T getRecursive(int index)
    {
        if(index < 0 || index >= this.size())
        {
            return null;
        }
        return getRecursive(sentinel.next,index);
    }
    private T getRecursive(Node n, int index)
    {
        if(index == 0)
        {
            return n.item;
        }
        else
        {
            int i = index - 1;
            return getRecursive(n.next,i);
        }
    }
}
