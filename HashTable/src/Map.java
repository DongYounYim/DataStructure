import java.util.Collection;
import java.util.Set;

public interface Map {
    public void clear();
    public boolean containsKey(Object key);
    public boolean containsValue(Object value);
    public Set entrySet();
    public boolean equals(Object object);
    public Object get(Object key);
    public boolean isEmpty();
    public Set keySet();
    public Object put(Object key, Object value);
    public void putAll(Map map);
    public Object remove(Object key);
    public int size();
    public Collection values();
    public interface Entry {
        public boolean equals(Object object);
        public Object getKey();
        public Object getValue();
        public Object setValue(Object value);
    }


}
