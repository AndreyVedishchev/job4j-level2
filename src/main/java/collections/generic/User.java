package collections.generic;

public class User extends Base {

    User(String id) {
        super(id);
    }

    @Override
    public String toString() {
        return "User id = " + getId();
    }
}
