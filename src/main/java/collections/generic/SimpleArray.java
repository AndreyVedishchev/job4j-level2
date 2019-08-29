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
        arr[position] = model;
        position++;
    }

    public void set(int index, T model) {
        if (index < position) {
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

    public void print() {
        System.out.println(Arrays.toString(this.arr));
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return position > index;
            }

            @Override
            public T next() {
                return (T) arr[index++];
            }
        };
        return it;
    }

    public static void main(String[] args) {
        UserStore us = new UserStore(4);
        us.add(new User("111"));
        us.add(new User("222"));
        us.add(new User("333"));

        us.print();
    }
}
