package collections.generic;

public class UserStore implements Store<User> {

    private final SimpleArray<User> arr;
    private final int size;

    public UserStore(int size) {
        arr = new SimpleArray<>(size);
        this.size = size;
    }

    @Override
    public void add(User model) {
        arr.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
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
        User u1 = findById(id);
        arr.remove(getIndex(id));
        return !(findById(id).getId().equals(u1.getId()));
    }

    @Override
    public User findById(String id) {
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
