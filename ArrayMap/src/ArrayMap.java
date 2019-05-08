import java.util.*;

public class ArrayMap implements Map {
    private int arraysize = 10;
    private Entry[] array = new Entry[arraysize];
    private int size;

    public String get(String key) {
        for(int i = 0; i < size; i++) {
            if(array[i].equals(key)) {
                return array[i].value;
            }
        }
        return null;
    }

    public String put(String key, String value) {
        int i = 0;
        for(i = 0; i < size; i++) {
            if(array[i].key.equals(key)) {                              //기존의 키가 있을때
                array[i].setValue(array[i].value + ", " + value);
                return value;
            }
            if(array[i].key.compareTo(key) > 0) break;                  //알파벳순서로 정렬하기위해 하나씩 비교 (정렬이 안되있으면 break를 실행해 재배열하러 간다.)
                                                                        //기본적으로 compareTo는 'A', 'B'비교시 A가 높으므로 양수가 나온다.
        }
        if(size == array.length)                                        //배열의 최대크기와 size가 같으면 배열의 크기를 늘려준다.
            resize();
        System.arraycopy(array, i, array, i+1, size-i);         //배열을 재배열하여 알파벳순서로 맞춰준다.
        Entry NewKey = new Entry(key, value);                           //기존의 키가 없을때
        array[i] = NewKey;
            size++;
            return value;

    }

    private void resize() {
        Entry[] array2 = new Entry[2*array.length];
        System.arraycopy(array, 0, array2, 0, array.length);
        array = array2;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i<size; i++) {
            buf.append(array[i] + "\n");
        }
        return buf.toString();
    }
}
