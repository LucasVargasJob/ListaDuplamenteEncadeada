
public interface Iterador {
	boolean hasNext();
    Object next();
    void insertAfter(Object o);
    void insertBefore(Object o);
    void remove();
    // A partir daqui, é opcional!
    boolean hasPrevious();
    Object previous();
}
