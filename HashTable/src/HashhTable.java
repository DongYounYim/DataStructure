import java.util.Collection;
import java.util.Set;

//CloseAddressing
public class HashhTable implements Map {
    private Entry[] entries = new Entry[50000];
    private int size = 0;

    private int hash(Object key) {
        return (key.hashCode() & 0x7FFFFFFF) % entries.length;
    }

    @Override
    public void clear() {
        for(int i = 0; i < entries.length; i++) {
            entries[i] = new Entry(null, null, null);
        }
        size = 0;
    }

    @Override
    public boolean containsKey(Object key) {
        int h = hash(key);
        for(Entry e = entries[h]; e != null; e = e.next) {
            if(e.key.equals(key))
                return true;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for(int i = 0; i < entries.length; i++) {
            for(Entry e = entries[i]; e != null; e = e.next) {
                if(e.value.equals(value))
                    return true;
            }
        }
        return false;
    }

    @Override
    public Set entrySet() {
        Set set = null;
        for(int i = 0; i < entries.length; i++) {
            if(entries[i].key.equals(null)) {
                continue;
            }
            else {
                for (Entry e = entries[i]; e != null; e = e.next) {
                    set.add(e.key);
                    set.add(e.value);
                }
            }
        }
        return null;
    }

    @Override
    public Object get(Object key) {
        int h = hash(key);
        for(Entry e = entries[h]; e != null; e = e.next) {
            if(e.key.equals(key))
                return e.value;
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
            if(entries[i].key.equals(null)) {
                continue;
            }
            else {
                for (Entry e = entries[i]; e != null; e = e.next)
                    set.add(e.key);
            }
        }
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        int h = hash(key);
        for(Entry e = entries[h]; e != null; e = e.next) {
            if(e.key.equals(key)) {
                Object temp = e.value;
                e.value = value;
                return temp;
            }
        }
        entries[h] = new Entry(key,value,entries[h]);
        return null;
    }

    @Override
    public void putAll(Map map) {

    }

    @Override
    public Object remove(Object key) {
        int h = hash(key);
        for(Entry e = entries[h], prev = null; e != null; prev = e, e=e.next) {
            if(e.key.equals(key)) {
                Object temp = e.value;
                if(prev == null)
                    entries[h] = e.next;
                else
                    prev.next = e.next;
                return temp;
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
        Entry next;


        public Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
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
