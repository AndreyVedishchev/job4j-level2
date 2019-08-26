package collections.generic;

public abstract class AbstractStore<T extends Base> implements Store{

    private final SimpleArray<T> arr;

    public AbstractStore(int size) {
        arr = new SimpleArray<>(size);
    }

    public abstract void add(Base model);

    public abstract boolean replace(String id, Base model);

    public abstract boolean delete(String id);

    public abstract Base findById(String id);
}
