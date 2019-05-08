public class Main {
    public static void main(String args[]) {
        HanoiTop ht = new HanoiTop();
        System.out.println("x(A)에서 y(B)로 옮긴다.");
        ht.move(3, 'A', 'B', 'C');

        System.out.println("x(A)에서 z(C)로 옮긴다.");
        ht.move2(3, 'A', 'B', 'C');
    }
}
