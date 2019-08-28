package collections.list;

import java.util.Arrays;
import java.util.Iterator;

public class DynamicList<E> implements Iterable<E> {

    private Object[] container;
    //private int modCount;
    //private int expectedmodCount;
    private int size;
    private int position;

    public DynamicList() {
        this.size = 5;
        this.position = 0;
        this.container = new Object[size];

    }

    public void add(E value) {
        checkCntElem();
        container[position++] = value;
    }

    public E get(int index) {
        return (E) container[index];
    }

    private void checkCntElem() {
        if (position == size) {
            Object[] copyArr = new Object[size += size];
            System.arraycopy(this.container, 0, copyArr, 0, position);
            this.container = copyArr;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public String toString() {
        return Arrays.toString(container);
    }

    public static void main(String[] args) {
        DynamicList<Integer> dl = new DynamicList<>();
        System.out.println(dl.toString());
        dl.add(1);
        dl.add(1);
        dl.add(1);
        System.out.println(dl.toString());
        dl.add(1);
        dl.add(1);
        dl.add(1);
        System.out.println(dl.toString());
    }
}
