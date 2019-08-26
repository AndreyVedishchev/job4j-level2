package collections.generic;

import java.util.Arrays;
import java.util.Iterator;

public class SimpleArray<T> implements Iterable<T>{

    private Object[] arr;
    private int position = 0;

    public SimpleArray(int size) {
        this.arr = new Object[size];
    }

    public void add(T model) {
        this.arr[position++] = model;
    }

    public void set(int index, T model) {
        if (index <= position) {
            arr[index] = model;
        }
    }

    public void remove(int index) {
        System.arraycopy(arr, index + 1, arr, index,position - index);
        arr[arr.length - 1] = null;
    }

    public T get(int index) {
        return (T) arr[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return arr.length - 1 > index;
            }

            @Override
            public T next() {
                return (T) arr[index++];
            }
        };
        return it;
    }

    public static void main(String[] args) {
        SimpleArray<Integer> sim = new SimpleArray<>(7);
        sim.add(1);
        sim.add(7);
        sim.add(5);
        sim.add(8);
        sim.add(9);

        System.out.println(sim.toString());
        sim.remove(4);
        System.out.println(sim.toString());
        sim.set(5, 99);
        System.out.println(sim.toString());
    }
}
