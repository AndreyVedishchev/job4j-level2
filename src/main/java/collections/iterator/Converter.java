package collections.iterator;

import java.util.Arrays;
import java.util.Iterator;

public class Converter {

    private int index = 0;

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return it.next().hasNext();
            }

            @Override
            public Integer next() {
                final Integer res;
                it.forEachRemaining(obj -> {
                    if (obj.hasNext()) {
                        res = obj.next();
                    }
                });
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
