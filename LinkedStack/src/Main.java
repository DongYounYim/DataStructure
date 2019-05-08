public class Main {
    public static void main(String args[]) {

        LinkedStack crates = new LinkedStack();
        crates.push("CARROTS");
        crates.push("ORANGES");
        crates.push("RAININS");
        crates.push("PICKLES");
        crates.push("BANANAS");

        System.out.println("crates.size: " + crates.size() + "\tcrates.peak: " + crates.peak());

        System.out.println("crates.pop: " + crates.pop());
        System.out.println("crates.pop: " + crates.pop());
        System.out.println("crates.pop: " + crates.pop());
        System.out.println("crates.size: " + crates.size() + "\tcrates.peak: " + crates.peak());

        crates.push("WALNUTS");
        crates.push("OYSTEPS");
        System.out.println("crates.size: " + crates.size() + "\tcrates.peak: " + crates.peak());

        System.out.println("crates.pop: " + crates.pop());
        System.out.println("crates.pop: " + crates.pop());
        System.out.println("crates.pop: " + crates.pop());
        System.out.println("crates.pop: " + crates.pop());
        System.out.println("crates.pop: " + crates.pop());
    }
}
