//OpenAddressingHashTable

public class Hash {
    private class  Entry{Object key; Object value;

        public Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }
    int SIZE = 100;

    private final Entry NIL = new Entry(null, null);
    private Entry[] entries = new Entry[SIZE];

    public Object get(Object key) {
        int h = hash(key);
        for(int i = 0; i < SIZE; i++) {
            int j = (h+i) % SIZE;
            if(entries[j] == null)
                break;
            if(entries[j] == NIL)
                continue;
            if(entries[j].key.equals(key)) {
                return entries[j].value;
            }
        }
        System.out.println("찾으려는 키가 없다.");
        return null;
    }

    public Object put(Object key, Object value) {
        int h = hash(key);
        for(int i = 0; i < SIZE; i++) {
            int j = (h+i) % SIZE;
            if(entries[j] == null) {
                entries[j] = new Entry(key, value);
                return null;
            }
        }
        System.out.println("추가 실패");
        return null;
    }

    public Object remove(Object key) {
        int h = hash(key);
        for(int i = 0; i < SIZE; i++) {
            int j = (h+i) % SIZE;
            if(entries[j].key.equals(key)) {
                Object temp = entries[j].value;
                entries[j] = NIL;
                return temp;
            }
        }
        System.out.println("삭제할 키 값이 없습니다.");
        return null;
    }

    private int hash(Object key) {
        return (key.hashCode() & 0x7FFFFFFF) % SIZE;
    }
}
