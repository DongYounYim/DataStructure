public class Main {
    public static void main(String args[]) {
        BigInt a = new BigInt(20);
        BigInt b = new BigInt(556);
        BigInt c = new BigInt("20");

        BigInt f1 = a.plus(b);
        System.out.println(f1.intValue());
        BigInt ff = b.minus(c);
        System.out.println(ff.intValue());

        System.out.println(b.equals(a));
        System.out.println(a.numdigits());
        BigInt f2 = c.times(100);
        System.out.println(f2.intValue());
    }
}
