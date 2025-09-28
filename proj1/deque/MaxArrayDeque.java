package deque;

import java.util.Comparator;
public class MaxArrayDeque<T> extends ArrayDeque<T>{

    private Comparator<T> comparator;
    public MaxArrayDeque(Comparator<T> c)
    {
        super();
        comparator = c;
    }

    public T max()
    {
        if(isEmpty())
            return null;
        return max(comparator);
    }
    public T max(Comparator<T> c)
    {
        if(isEmpty())
            return null;
        T maxItem = this.get(0);
        for(int i = 0; i < this.size(); i++)
        {
            T current = this.get(i);
            if(c.compare(current, maxItem) > 0)
            {
                maxItem = current;
            }
        }
        return maxItem;
    }
}
