public class main {
    static Integer[] testArray = new Integer[500000];
    Integer[] values = new Integer[4990];

    public static void main(String args[]) {
        HashTable ht_open = new HashTable();
        HashhTable ht_close = new HashhTable();
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = i;
        }

        //OpenAddressingTest

        long start = System.nanoTime();
        for(Integer integer : testArray) {
            ht_open.put(integer, integer);
        }
        long end = System.nanoTime();

        System.out.println("HashTable(OpenAddressing)");
        System.out.println("입력 소요시간 : " + (end - start) % Math.pow(10,9)+ "초");

        start = System.nanoTime();
        for(Integer integer : testArray)  {
            ht_open.get(integer);
        }
        end = System.nanoTime();

        System.out.println("HashTable(OpenAddressing)");
        System.out.println("탐색 소요시간 : " + (end - start) % Math.pow(10,9) + "초");

        start = System.nanoTime();
        for(Integer integer : testArray)  {
            ht_open.remove(integer);
        }
        end = System.nanoTime();

        System.out.println("HashTable(CloseAddressing)");
        System.out.println("삭제 소요시간 : " + (end - start) % Math.pow(10,9)+ "초");

        //CloseAddressing Test

        start = System.nanoTime();
        for(Integer integer : testArray) {
            ht_close.put(integer, integer);
        }
        end = System.nanoTime();

        System.out.println("HashTable(CloseAddressing)");
        System.out.println("입력 소요시간 : " + (end - start) % Math.pow(10,9)+ "초");

        start = System.nanoTime();
        for(Integer integer : testArray)  {
            ht_close.get(integer);
        }
        end = System.nanoTime();

        System.out.println("HashTable(CloseAddressing)");
        System.out.println("탐색 소요시간 : " + (end - start) % Math.pow(10,9)+ "초");

        start = System.nanoTime();
        for(Integer integer : testArray)  {
            ht_close.remove(integer);
        }
        end = System.nanoTime();

        System.out.println("HashTable(CloseAddressing)");
        System.out.println("삭제 소요시간 : " + (end - start) % Math.pow(10,9)+ "초");
    }
}
