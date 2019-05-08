//CloseAddressingHashTable

public class Hashh {
    private class Entry{
        Object key;
        Object value;
        Entry next;

        public Entry(Object key, Object value, Entry n) {
            this.key = key;
            this.value = value;
            this.next = n;
        }
    }
    int SIZE = 100;
    private Entry[] entries = new Entry[SIZE];

    private int hash(Object key) {
        if(key == null) throw new IllegalArgumentException();
        return (key.hashCode() & 0x7FFFFFFF) % SIZE;
    }

    public Object get(Object key) {
        int h = hash(key);
        for(Entry e = entries[h]; e != null; e = e.next) {
                if(e.key.equals(key))
                return e.value;
        }
        return null;
    }

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
}
