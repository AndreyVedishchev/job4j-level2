package collections.iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {

    private int index = 0;

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {

            Iterator<Integer> curr;

            @Override
            public boolean hasNext() {
                boolean res = false;

                if (!it.hasNext() && it.next() == null) {
                    throw new NoSuchElementException();
                } else {
                    curr = it.next();
                }

                if (curr.hasNext()) {
                    res = true;
                }

                return res;
            }

            @Override
            public Integer next() {
                int res;

                if (it.hasNext()) {
                    curr = it.next();
                }

                if (curr.hasNext()) {
                    res = curr.next();
                } else throw new NoSuchElementException();

                return res;
            }
        };
    }

    public static void main(String[] args) {

        Iterator<Integer> it1 = Arrays.asList(1, 2, 3).iterator();
        Iterator<Integer> it2 = Arrays.asList(4, 5, 6).iterator();
        Iterator<Integer> it3 = Arrays.asList(7, 8, 9).iterator();
        Iterator<Iterator<Integer>> its = Arrays.asList(it1, it2, it3).iterator();

        Converter cnv = new Converter();
        Iterator<Integer> it = cnv.convert(its);

        System.out.println(it.toString());

    }
}
