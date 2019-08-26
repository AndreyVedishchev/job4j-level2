package collections.generic;

public class RoleStore<T extends Base> implements Store<T> {

    private final SimpleArray<Role> arr;

    public RoleStore(int size) {
        arr = new SimpleArray<>(size);
    }

    @Override
    public void add(T model) {
        arr.add((Role) model);
    }

    @Override
    public boolean replace(String id, T model) {
        arr.set(Integer.valueOf(id), (Role) model);
        return findById(id).getId().equals(model.getId());
    }

    @Override
    public boolean delete(String id) {
        T u1 = findById(id);
        arr.remove(Integer.valueOf(id));
        return !(findById(id).getId().equals(u1.getId()));
    }

    @Override
    public T findById(String id) {
        return (T) arr.get(Integer.valueOf(id));
    }
}
