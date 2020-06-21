package cn.neyzoter.datastructure.heap;

/**
 * 基于大顶堆的优先级队列
 * @author Charles Song
 * @date 2020-6-21
 */
public class MaxPriorityQueue <E extends Comparable<E>> {
    private E[] array;

    /**
     * 元素个数
     */
    private int num;

    @SuppressWarnings("unchecked")
    public MaxPriorityQueue (int cap) {
        array = (E[]) new Comparable[cap + 1];
        num = 0;
    }

    /**
     * 删除大顶堆的元素，也就是最大的一个
     * @return 最大的元素
     */
    public E delete () {
        E e = array[1];
        array[1] = array[num];
        num --;
        sink(1);
        return e;
    }
    /**
     * 插入元素
     * @param e 元素
     */
    public void insert (E e) {
        num ++;
        // 添加元素
        array[num] = e;
        // 上浮
        swim(num);
    }
    /**
     * 元素下沉
     * @param i 元素位置
     */
    public void sink (int i) {
        while ( left(i) <= num) {
            int left = left(i);
            int right = right(i);
            int bigger = bigger(left, right);
            // 如果比左右大者小，则需要下沉
            if (less(i, bigger)) {
                exchange(i, bigger);
                i = bigger;
            } else {
                return;
            }
        }
    }

    /**
     * 元素上浮
     * @param i 元素位置
     */
    public void swim (int i) {
        //	如果浮到堆顶或者比父亲小,就不能再上浮了
        while (i > 1 && less(getFatherIdx(i), i)) {
            exchange(i, getFatherIdx(i));
            i = getFatherIdx(i);
        }
    }

    public void exchange (int i, int j) {
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public E getFather (int i) {
        return array[getFatherIdx(i)];
    }
    public int getFatherIdx (int i) {
        return i / 2;
    }

    public int left (int i) {
        return 2 * i;
    }

    public int right (int i) {
        return 2 * i + 1;
    }
    /**
     * 比较大小
     * @param i 参数1 下标
     * @param j 参数2 下标
     * @return 参数1是否小于参数2
     */
    public boolean less (int i, int j) {
        return array[i].compareTo(array[j]) < 0;
    }

    /**
     * 得到一个较大的
     * @param i 参数1 下标
     * @param j 参数2 下标
     * @return 较大的参数下标
     */
    public int bigger (int i, int j) {
        int bigger = array[i].compareTo(array[j]) > 0 ? i : j;
        return bigger;
    }


    public static void main (String[] args) {

    }
}
