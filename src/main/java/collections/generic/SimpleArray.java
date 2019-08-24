package collections.generic;

import java.util.Arrays;
import java.util.Iterator;

public class SimpleArray<T> implements Iterable<T>{

    private Object[] arr;

    public SimpleArray(int size) {
        this.arr = new Object[size];
    }

    public void add(T model) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                arr[i] = model;
                break;
            }
        }
    }

    public void set(int index, T model) {
        for (int i = 0; i < arr.length; i++) {
            if (i == index) {
                arr[i] = model;
            }
        }
    }

    public void remove(int index) {
        for (int i = 0; i < arr.length; i++) {
            if (i == index) {
                if (i == arr.length - 1) {
                    arr[i] = null;
                } else {
                    for (int j = i; j < arr.length - 1; j++) {
                        arr[j] = arr[j + 1];
                        if (arr[j] == arr[arr.length - 1]) {
                            arr[j + 1] = null;
                        }
                    }
                }
            }
        }
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
                return arr.length > index;
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
        sim.remove(2);
        System.out.println(sim.toString());
        sim.set(5, 99);
        System.out.println(sim.toString());
    }
}
