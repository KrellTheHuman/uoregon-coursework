import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class OccurenceSet<T> implements Set<T> {

    private HashMap<T, Integer> map;

    public OccurenceSet() {
        map = new HashMap<>();
    }



    @Override
    public int size() {
        return map.size(); //todo should i track size in private var rather than check with method?
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public Iterator<T> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0]; //todo implement this
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null; //todo implement this
    }

    @Override
    public boolean add(T t) {
        boolean isNewKey = map.get(t) == null;
        map.put(t, isNewKey ? 0 : map.get(t) + 1); //todo see if this can be simplified
        return isNewKey;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
