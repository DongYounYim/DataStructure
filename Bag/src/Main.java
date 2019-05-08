public class Main {
    public static void main(String args[]) {

        Set set = new Set();
        set.add("CA");
        set.add("US");
        set.add("MX");
        set.add("RU");
        set.add("US");
        set.add("MX");

        printBag(set);
       /* Bag bag = new ArrayBag();
        bag.add("CA");
        bag.add("US");
        bag.add("MX");
        bag.add("RU");
        bag.add("US");
        bag.add("MX");

        printBag(bag);

        /*String item = (String) bag.getFirst();
        System.out.println(item);

        while( (item = (String) bag.getNext()) != null) {
            System.out.println(item);
        }

        if (bag.remove( "US")) {

            System.out.println("Remove Success");
        }

        item = (String) bag.getFirst();
        System.out.println(item);

        while( (item = (String) bag.getNext()) != null) {
            System.out.println(item);
        } */
    }

    public static void printBag(Bag b) {
        String temp = (String) b.getFirst();
        System.out.print(temp);
        while ((temp = (String) b.getNext()) != null) {
            System.out.print(", " + temp);
        }
    }
}
