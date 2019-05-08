import java.util.Collection;
import java.util.Set;

//OpenAddressing
public class HashTable implements Map {
    private Entry[] entries =  new Entry[500000];
    private int size=0;
    private final Entry NIL = new Entry(null, null);

    private int hash(Object key) {
        return (key.hashCode() & 0x7FFFFFFF) % entries.length;
    }

    @Override
    public void clear() {               //HashMap에 저장된 모든 객체를 지운다.
        for(int i = 0; i < entries.length; i++) {
            entries[i] = new Entry(null, null);
        }
        size = 0;
    }

    @Override
    public boolean containsKey(Object key) {
        int h = hash(key);
        for (int i = 0; i < entries.length; i++) {
            int j = (h+i) % entries.length;
            Entry entry = entries[j];
            if(entry == null)
                break;
            if(entry == NIL)
                continue;
            if(entry.key.equals(key))
                return true;
        }
            return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for(int i = 0; i < entries.length; i++) {
            if(entries[i].value.equals(value))
                return true;
        }
        return false;
    }

    @Override
    public Set entrySet() {
        Set set = null;
        for(int i = 0; i < entries.length; i++) {
            if(entries[i].key.equals(null)|| entries[i].key.equals(NIL)) {
                continue;
            }
            else {
                set.add(entries[i].key);
                set.add(entries[i].value);
            }
        }
        return null;
    }

    @Override
    public Object get(Object key) {
        int h = hash(key);
        for (int i = 0; i < entries.length; i++) {
            int j = (h+i) % entries.length;
            Entry entry = entries[j];
            if(entry == null)
                break;
            if(entry == NIL)
                continue;
            if(entry.key.equals(key))
                return entry.value;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Set keySet() {
        Set set = null;
        for(int i = 0; i < entries.length; i++) {
            if(entries[i].key.equals(null)|| entries[i].key.equals(NIL)) {
                continue;
            }
            else
                set.add(entries[i].key);
        }
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        int h = hash(key);
        for(int i = 0; i < entries.length; i++) {
            int j = (h + i) % entries.length;
            Entry entry = entries[j];
            if(entry == null) {
                entries[j] = new Entry(key, value);
                ++size;
                return null;
            }
            if(entry == NIL)
                continue;
            if(entry.key.equals(key)) {
                Object oldValue = entry.value;
                entries[j].value = value;
                return oldValue;
            }
        }
        return null;
    }

    @Override
    public void putAll(Map map) {       }

    @Override
    public Object remove(Object key) {
        int h = hash(key);
        for(int i = 0; i < entries.length; i++) {
            int j = (h + i) % entries.length;
            Entry entry = entries[j];
            if(entry == null)
                break;
            if(entry == NIL)
                continue;
            if(entry.key.equals(key)) {
                Object oldValue = entry.value;
                entries[j] = NIL;
                --size;
                return oldValue;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Collection values() {
        return null;
    }

    public class Entry implements Map.Entry {
        Object key, value;
        Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
        Entry entry;

        @Override
        public Object getKey() {
            return entry.key;
        }

        @Override
        public Object getValue() {
            return entry.value;
        }

        @Override
        public Object setValue(Object value) {
            Object temp = entry.value;
            entry.value = value;
            return temp;
        }
    }
}