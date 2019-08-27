package collections.generic;

public class RoleStore implements Store<Role> {

    private final SimpleArray<Role> arr;
    private final int size;

    public RoleStore(int size) {
        arr = new SimpleArray<>(size);
        this.size = size;
    }

    @Override
    public void add(Role model) {
        arr.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
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
        Role u1 = findById(id);
        arr.remove(getIndex(id));
        return !(findById(id).getId().equals(u1.getId()));
    }

    @Override
    public Role findById(String id) {
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
            }
        }
        return res;
    }
}
