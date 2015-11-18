import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class OccurrenceSet<T> implements Set<T> {

    private HashMap<T, Integer> map;

    public OccurrenceSet() {
        map = new HashMap<>();
    }

    @Override
    public int size() {
        return map.size();
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

    /**
     * toArray() sort by value inspired by examples from Carter Page found at:
     * http://stackoverflow.com/questions/109383/how-to-sort-a-mapkey-value-on-the-values-in-java
     */
    @Override
    public Object[] toArray() {
        ArrayList<T> list = new ArrayList<>();
        Stream<Map.Entry<T, Integer>> stream = map.entrySet().stream();
        stream.sorted(Comparator.comparing(Map.Entry::getValue)).forEachOrdered(entry -> list.add(entry.getKey()));
        return list.toArray();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E> E[] toArray(E[] a) {
        if (a.length < map.size())
            return (E[]) Arrays.copyOf(toArray(), map.size(), a.getClass());
        System.arraycopy(toArray(), 0, a, 0, map.size());
        if (a.length > map.size())
            a[map.size()] = null;
        return a;
    }

    @Override
    public boolean add(T t) {
        return map.put(t, map.get(t) == null ? 1 : map.get(t) + 1) == null;
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) != null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (c.size() > 0) {
            for (Object entry : c) {
                if (!contains(entry)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c.size() > 0) {
            for (T entry : c) {
                add(entry);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (c.size() > 0) {
            boolean setChanged = false;
            for (Map.Entry entry : map.entrySet()) {
                if (!c.contains(entry)) {
                    remove(entry);
                    setChanged = true;
                }
            }
            return setChanged;
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c.size() > 0) {
            for (Object entry : c) {
                remove(entry);
            }
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public String toString() {
        String outputString = "[";
        for (Object element : toArray()) {
            outputString += element.toString() + ", ";
        }
        outputString = outputString.substring(0, outputString.length() - 2) + "]";
        return outputString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OccurrenceSet<?> that = (OccurrenceSet<?>) o;
        return map.equals(that.map);
    }

    @Override
    public int hashCode() {
        return map.hashCode();
    }
}
