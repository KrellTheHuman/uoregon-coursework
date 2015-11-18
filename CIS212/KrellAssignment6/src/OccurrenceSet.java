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

    private HashMap<T, Integer> _map;

    public OccurrenceSet() {
        _map = new HashMap<>();
    }

    public HashMap<T, Integer> getMap() {
        return _map;
    }

    @Override
    public int size() {
        return _map.size();
    }

    @Override
    public boolean isEmpty() {
        return _map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return _map.containsKey(o);
    }

    @Override
    public Iterator<T> iterator() {
        return _map.keySet().iterator();
    }

    /**
     * toArray() sort by value inspired by examples from Carter Page found at:
     * http://stackoverflow.com/questions/109383/how-to-sort-a-mapkey-value-on-the-values-in-java
     */
    @Override
    public Object[] toArray() {
        ArrayList<T> list = new ArrayList<>();
        Stream<Map.Entry<T, Integer>> stream = _map.entrySet().stream();
        stream.sorted(Comparator.comparing(Map.Entry::getValue)).forEachOrdered(entry -> list.add(entry.getKey()));
        return list.toArray();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E> E[] toArray(E[] a) {
        if (a.length < _map.size())
            return (E[]) Arrays.copyOf(toArray(), _map.size(), a.getClass());
        System.arraycopy(toArray(), 0, a, 0, _map.size());
        if (a.length > _map.size())
            a[_map.size()] = null;
        return a;
    }

    @Override
    public boolean add(T t) {
        return _map.put(t, _map.get(t) == null ? 1 : _map.get(t) + 1) == null;
    }

    @Override
    public boolean remove(Object o) {
        return _map.remove(o) != null;
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
            // if adding an instance of OccurrenceSet, adds the multiple occurrences of each entry
            if (c instanceof OccurrenceSet) {
                for (T entry : c) {
                    for (int i = 0; i < (int) ((OccurrenceSet) c).getMap().get(entry); i++) {
                        add(entry);
                    }
                }
                return true;
                // otherwise, just adds each entry
            } else {
                for (T entry : c) {
                    add(entry);
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (c.size() > 0) {
            boolean setChanged = false;
            for (Map.Entry entry : _map.entrySet()) {
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
        _map.clear();
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
        return _map.equals(that._map);
    }

    @Override
    public int hashCode() {
        return _map.hashCode();
    }
}
