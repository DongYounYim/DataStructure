public class HanoiTop {
    public static int cnt = 0;
    public static void move(int n, char x, char y, char z) {
        if (n == 0) {
            return ;
        } else {
            move(n-1, x, z, y);
            System.out.println(x + "→" + y);
            move(n-1, z, y, x);
        }
    }
    public static void move2(int n, char x, char y, char z) {           //과제
        if (n == 0) {
            return ;
        } else {
            move2(n-1, x, y, z);
            System.out.println(x + "→" + z);
            move2(n-1, y, z, x);
        }
    }
}
