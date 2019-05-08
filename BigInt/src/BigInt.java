public class BigInt {
    private Node start;

    @Override
    public String toString() {                                              //배열 그대로 String형으로 출력하는 메소드
        Node p = start;
        String tS = "";
        while(p != null) {
            tS = tS + p.digit + "";                                         //13579순서의 빅인트를 "97531"로 출력한다.
            p=p.next;
        }
        return tS;
    }

    public BigInt (int n) {                                                 //int n을 받아 BigInt로 변환
        if(n < 0) throw new IllegalArgumentException();                     // n이 음수일 경우의 예외처리
        start = new Node(n%10);
        Node p = start;
        n /= 10;
        while (n > 0) {
            p = p.next = new Node(n%10);
            n /= 10;
        }
    }

    public BigInt (String s) {                                              //String s를 받아 BigInt로 변환
        if(s.length() == 0) throw new IllegalArgumentException("empty String");         //문자열의 길이가 0일 경우 예외처리
        start = new Node(digit(s, s.length()-1));                        //digit이라는 함수 사용
        Node p = start;
        for (int i = s.length()-2; i >= 0; i--) {
            p = p.next = new Node(digit(s, i));
        }

    }

    private int digit(String s, int i) {                                    //스트링형을 받아 그것의 한 글자(숫자)씩 int형으로 변환한다.
        String ss = s.substring(i, i+1);
        return Integer.parseInt(ss);
    }

    public BigInt plus (BigInt y) {
        Node p = start;                                                     //1번 BigInt
        Node q = y.start;                                                   //2번 BigInt
        int n = p.digit + q.digit;                                          //더해주었을때 n에 저장
        BigInt z = new BigInt(n%10);                                    //10으로 모듈러 연산을 하여 한자리 수만 저장
        Node r = z.start;                                                   //새로운 BigInt z를 연결하는 Node r
        p = p.next;
        q = q.next;
        while (p != null && q != null) {
            n = n/10 + p.digit + q.digit;                                   // n/10을 함으로써 올림수(carry)를 받아줌
            r.next = new Node(n%10);                                 //모듈러 연산으로 한자리 수만 저장
            p = p.next;
            q = q.next;
            r = r.next;
        }
        while (p != null) {                                                 //p의 BigInt자리수가 q보다 길 때
            n = n/10 + p.digit;
            r.next = new Node(n%10);
            p = p.next;
            r = r.next;
        }
        while (q != null) {                                                 //q의 BigInt자리수가 p보다 길 때
            n = n/10 + q.digit;
            r.next = new Node(n%10);
            q = q.next;
            r = r.next;
        }
        if(n > 9)                                                           //마지막 덧셈이 두자리수로 넘어갔을때의 처리
            r.next = new Node(n/10);
        return z;
    }

    public BigInt minus (BigInt y) {                                        //마이너스시 1번BigInt가 2번BigInt보다 클 때를 가정하는 것이 중요하다. ;;
        Node p = start;                                                     //1번 BigInt
        Node q = y.start;                                                   //2번 BigInt
        int n = p.digit - q.digit;
        BigInt z = null;                                                    //결과값 BigInt z 의 초기화
        if(n >= 0) {
            z = new BigInt(n);
        } else if (n < 0 && p.next != null){                                //그 자릿수에서 뺄셈이 음수에 나올시 다음 수에서 10을 가져오는 과정
            p.next.digit -= 1;
            if(p.next.digit == -1)
                p.next.digit = 9;
            else if(p.next.digit == 0 && p.next.next == null)               //자릿수 내림시 그 자리가 마지막 자리이고 그것이 0이되면 없애준다.
                p.next = null;
            z = new BigInt(10+n);
        } else if (p.next == null) {                                       //이런식으로 2번BigInt가 음수일 경우 처리하기 곤란하다(-표현이 어렵기 때문)
            System.out.println("음수입니다만?");
            System.exit(0);
        }
        Node r = z.start;                                                   //z를 가르키는 Node r
        p = p.next;
        q = q.next;
        while(p != null && q != null) {                                     //위과정을 반복해서 뺄셈을 진행한다.
            n = p.digit - q.digit;
            if(n >= 0)
                r.next = new Node(n);
            else if(n < 0 && p.next != null) {
                p.next.digit -= 1;
                if(p.next.digit == -1) {
                    p.next.digit = 9;
                    p.next.next.digit -= 1;
                }
                else if(p.next.digit == 0 && p.next.next == null)
                    p.next = null;
                r.next = new Node(10+n);
            } else if(p.next == null) {
                System.out.println("음수입니다만?");
                System.exit(0);
            }
            p = p.next;
            q = q.next;
            r = r.next;
        }
        while(p != null) {
            if(p.next != null) {
                if (p.next.digit == -1) {
                    p.next.digit = 9;
                    p.next.next.digit -= 1;
                } else if (p.next.digit == 0 && p.next.next == null)
                    p.next = null;
            }
            r.next = new Node(p.digit);
            p = p.next;
            r = r.next;
        }
        while(q != null) {
            r.next = new Node(q.digit);
            q = q.next;
            r = r.next;
            System.out.println("음수입니다만?");
            System.exit(0);
        }
        return z;
    }

    Boolean equals (BigInt y) {                                                     //두 BigInt값이 동일한지 확인
        Node p = start;
        Node q = y.start;
        while ( p != null && q != null) {
            if(p.digit == q.digit) {                                                //모든 자리의 수 값이 맞으면 반복문이 끝날때까지 else로 가지않는다.
                p = p.next;
                q = q.next;
            } else                                                                  //한 자리라도 틀리면 false반환
                return false;
        }
        return true;                                                                //반복문이 무사히 끝나면 true반환
    }

    int intValue () {                                                               //BigInt의 value값을 int형으로 반환하는 메소드
        String s = "";
        Node p = start;
        while (p != null) {
            s = p.digit + s + "";
            p = p.next;
        }
        int value = Integer.parseInt(s);                                            //Integer.parseInt(String s) 스트링형 s를 int형으로 변환한다.
        return value;
    }

    int numdigits () {                                                              //자릿수가 몇자리수인지 세는 메소드
        Node p = start;
        int count = 0;
        while (p != null) {                                                         //p 한칸에 count 1개 증가
            count++;
            p = p.next;
        }
        return count;
    }

    BigInt times(int n) {
        Node p = start;
        int num, carry;                                                             //num은 곱셈의 총값을 저장 carry는 다음으로 올려주는 올림 수
        num = (p.digit * n) % 10;
        carry = (p.digit * n) / 10;
        BigInt z = new BigInt(num);                                                 //BigInt z는 곱셈 후의 되는 BigInt의 값
        Node r = z.start;                                                           //z를 연결하는 Node r
        p = p.next;
        while(p != null) {
            num = (p.digit * n + carry) % 10;
            carry = (p.digit * n + carry) / 10;
            r.next = new Node(num);
            p = p.next;
            r = r.next;
        }
        r.next = new Node(carry);                                                   //곱셈이 끝난 후 마지막 올림을 수행한다.
        return z;
    }
}
