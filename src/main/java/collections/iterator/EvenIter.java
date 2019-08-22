package collections.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIter implements Iterator {
    private final int[] values;
    private int index = 0;

    public EvenIter(final int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        for (int i = index; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        if (values[index] % 2 == 0) {
            return values[index++];
        }
        return null;
    }
}
