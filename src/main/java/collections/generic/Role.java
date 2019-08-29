package collections.generic;

public class Role extends Base {

    Role(String id) {
        super(id);
    }

    @Override
    public String toString() {
        return "Role id = " + getId();
    }
}
