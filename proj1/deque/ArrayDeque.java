package deque;


import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T>{
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;
    private int fixedSize;

    public ArrayDeque()
    {
        fixedSize = 8;
        items = (T[]) new Object[fixedSize];
        size = 0;
        nextFirst = 3;
        nextLast = 4;
    }
    public ArrayDeque(T i)
    {
        fixedSize = 8;
        items = (T[]) new Object[fixedSize];
        size = 1;
        items[3] = i;
        nextFirst = 2;
        nextLast = 4;
    }
    @Override
    public void addFirst(T i)
    {
        if(isFull())
        {
            this.resize(size * 2);
        }
        items[nextFirst] = i;
        size += 1;
        nextFirst = Math.floorMod(nextFirst - 1, fixedSize);
    }
    @Override
    public void addLast(T i)
    {
        if(isFull())
        {
            this.resize(size *2);
        }
        items[nextLast] = i;
        size += 1;
        nextLast = Math.floorMod(nextLast + 1, fixedSize);
    }
    @Override
    public int size()
    {
        return size;
    }
    public int fixedSize()
    {
        return fixedSize;
    }
    @Override
    public T removeFirst()
    {
        if(isEmpty())
        {
            return null;
        }
        nextFirst = Math.floorMod(nextFirst +  1, fixedSize);
        T result = items[nextFirst];
        items[nextFirst]  = null;
        size -= 1;
        if(4 * size < fixedSize)
        {
            resize(fixedSize / 2);
        }
        return result;
    }
    @Override
    public T removeLast()
    {
        if(isEmpty())
        {
            return null;
        }
        nextLast = Math.floorMod(nextLast -  1, fixedSize);
        T result = items[nextLast];
        items[nextLast] = null;
        size -= 1;
        if(4 * size < fixedSize)
        {
            resize(fixedSize / 2);
        }
        return result;
    }
    public boolean isFull()
    {
        return size == fixedSize;
    }
    public void resize(int capacity)
    {

        T[] temp = (T[]) new Object[capacity];
        int preFirst = Math.floorMod(nextFirst + 1,fixedSize);
        nextFirst = capacity / 2 -1;
        nextLast = capacity / 2;
        for(int i = preFirst, j = nextLast , k = 0; k < size; i = Math.floorMod(i + 1,fixedSize),j = Math.floorMod(j + 1, capacity),k++ )
        {
            temp[j] = items[i];
        }
        nextLast = Math.floorMod(nextLast + fixedSize,capacity);
        items = temp;
        fixedSize = capacity;
    }
    @Override
    public T get(int index)
    {
        if(index < 0 || index >= size)
        {
            return null;
        }
        int current = Math.floorMod(nextFirst + 1 + index,fixedSize);
        return items[current];
    }
    // printDeque
    @Override
    public void printDeque()
    {
        if(size == 0)
        {
            return;
        }
        for(int i = Math.floorMod(nextFirst + 1,fixedSize), j = 0; j < size;i = Math.floorMod(i + 1,fixedSize),j++)
        {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }


    private class arrayDequeIterator implements Iterator<T>
    {
       private int winPos;

       public arrayDequeIterator()
       {
           winPos = 0;
       }
       public boolean hasNext()
       {
           return winPos < size;
       }
       public T next()
       {
           T returnItem = get(winPos);
           winPos += 1;
           return returnItem;
       }
    }
    public Iterator<T> iterator()
    {
        return new arrayDequeIterator();
    }

    public boolean equals(Object o)
    {
        if(o instanceof ArrayDeque)
        {
            ArrayDeque<T> temp = (ArrayDeque<T>) o;
            if(temp.size() < this.size())
            {
                return false;
            }
            for(int i = 0; i < this.size(); i++)
            {
                if(temp.get(i) != this.get(i))
                {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
