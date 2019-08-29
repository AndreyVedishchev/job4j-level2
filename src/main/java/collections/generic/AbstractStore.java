package collections.generic;

public abstract class AbstractStore<T extends Base> implements Store<T>{

    private final SimpleArray<T> arr;
    private final int size;

    public AbstractStore(int size) {
        arr = new SimpleArray<>(size);
        this.size = size;
    }

    @Override
    public void add(T model) {
        arr.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        if (getIndex(id) == -1) {
            return false;
        }
        arr.set(getIndex(id), model);
        return findById(id).getId().equals(model.getId());
    }

    @Override
    public boolean delete(String id) {
        if (getIndex(id) == -1) {
            return false;
        }
        T u1 = (T) findById(id);
        arr.remove(getIndex(id));
        return !(findById(id).getId().equals(u1.getId()));
    }

    @Override
    public T findById(String id) {
        if (getIndex(id) == -1) {
            return null;
        }
        return arr.get(getIndex(id));
    }

    public int getIndex(String id) {
        int res = -1;
        for (int i = 0; i < size; i++) {
            if (id.equals(arr.get(i).getId())) {
                res = i;
                break;
            }
        }
        return res;
    }

    public void print() {
        arr.print();
    }
}
