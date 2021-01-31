学习笔记

PriorityQueue源码分析

public class PriorityQueue<E> extends AbstractQueue<E> implements java.io.Serializable {

    private static final long serialVersionUID = -7720805057305804111L;

    private static final int DEFAULT_INITIAL_CAPACITY = 11;

    //队列中元素存放在数组中
    transient Object[] queue; // non-private to simplify nested class access
    //保存队列元素个数
    private int size = 0;
    //设置堆调整时的比较方式
    private final Comparator<? super E> comparator;
    //记录队列变更次数，用于iterator遍历中防止并发修改
    transient int modCount = 0; 
    
    //add同offer
    public boolean add(E e) {
        return offer(e);
    }
    
    public boolean offer(E e) {
        //入队元素为空则抛出空指针
        if (e == null)
            throw new NullPointerException();
        modCount++;
        int i = size;
        //当前队列已满则先扩容
        if (i >= queue.length)
            //传入当前容量+1作为扩容依据
            grow(i + 1);
        size = i + 1;
        //若队列为空，则直接入队
        if (i == 0)
            queue[0] = e;
        else
            //调整堆，改变元素在队列中的顺序
            siftUp(i, e);
        return true;
    }
    //扩容
    private void grow(int minCapacity) {
        int oldCapacity = queue.length;
        // 容量小于64时，扩容容量翻倍，否则扩容50%
        int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                                         (oldCapacity + 2) :
                                         (oldCapacity >> 1));
        // 若扩容后的容量大于数组的最大安全容量
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            //重新确定扩容后的容量
            newCapacity = hugeCapacity(minCapacity);
        //数组元素拷贝到新数组
        queue = Arrays.copyOf(queue, newCapacity);
    }
    private static int hugeCapacity(int minCapacity) {
        //传入的最小容量已经溢出变为负值，抛出OOM异常
        if (minCapacity < 0) 
            throw new OutOfMemoryError();
            //若最小容量比数组的最大安全容量更大，则返回Integer最大值作为扩容容量
            //但这在部分VM中可能导致OOM异常
        return (minCapacity > MAX_ARRAY_SIZE) ?
            Integer.MAX_VALUE :
            MAX_ARRAY_SIZE;
    }
    
    public E peek() {
        //取队头元素
        return (size == 0) ? null : (E) queue[0];
    }
    
    public E poll() {
        //队列为空则返回null
        if (size == 0)
            return null;
        //获取队尾数组下标
        int s = --size;
        modCount++;
        //获取队头元素用于返回
        E result = (E) queue[0];
        //获取队尾元素
        E x = (E) queue[s];
        //将队尾置空
        queue[s] = null;
        if (s != 0)
            //调整堆
            siftDown(0, x);
        return result;
    }
    
    public void clear() {
        modCount++;
        //遍历数组元素全部置空
        for (int i = 0; i < size; i++)
            queue[i] = null;
        size = 0;
    }
}