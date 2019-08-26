package collections.generic;

/**
 * @author Andrey Vedishchev (avedishchev@list.ru)
 * @version $Id$
 * @since 0.1
 */
public abstract class Base {
    private final String id;

    protected Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}