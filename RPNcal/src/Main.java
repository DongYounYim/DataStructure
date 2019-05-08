import java.util.*;

public class Main {
    public static void main(String args[]) {
        String input;                                           //중위식을 받는 String
        String [] pos;                                         //후위식을 받는 String 배열
        Scanner sc = new Scanner(System.in);
        RPN aa = new RPN();                                 //RPN class에 있는 함수를 쓰기 위함

        System.out.println("RPN Calculator");
        System.out.println("Input : ");
        input = sc.next();
        System.out.println(".......Chnage to posfix notation");
        pos = aa.toPosfix(input);
        for(int i = 0; i < pos.length; i++) {
            System.out.print(pos[i] + " ");
        }
        System.out.println();
        System.out.println("Start RPN Calculator");
        System.out.println(aa.RPNcal(pos));                     //후위식 계산과 프린트
        System.out.println("End RPN Calculator");
    }
}
