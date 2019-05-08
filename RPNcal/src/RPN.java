public class RPN {

    public RPN() {

    }

    public double RPNcal(String[] cal) {                                              //계산
        Stack stack = new ArrayStack(cal.length);
        double result = 0;
        for (int i = 0; i < cal.length; i++) {
            String input = cal[i];
            try {                                                        //'(', ')'는 array에 포함이 되지 않아 Nullpointer가 나와 예외처리
                if (isAnOperator(input)) {
                    //System.out.println(input + "...pop");
                    double y = Double.parseDouble((String) stack.pop());
                    double x = Double.parseDouble((String) stack.pop());
                    result = evaluate(x, y, input);
                    stack.push("" + result);
                    //System.out.println("...push");
                }
                else stack.push(input);
                //System.out.println(input + "...push");
            } catch (NullPointerException e) {

            }
        }
        return result;
    }

    private boolean isAnOperator(String s) {
        return (s.length() == 1 && "+-*/".indexOf(s) >=0);
    }
    private double evaluate(double x, double y, String op) {
        double z = 0;
        if(op.equals("+"))
            z = x+y;
        else if(op.equals("-"))
            z = x-y;
        else if(op.equals("*"))
            z = x*y;
        else
            z = x/y;
        System.out.println(x + " " + op + " " + y + " " + "=" + z);
        return z;
    }

    public String[] toPosfix(String scan) {                    //후위식으로 바꾸는 메소드
        String[] posfix = new String[scan.length()];              //()가 안들어가서 null이 나옴 try-catch로 잡기
        Stack OpStack = new ArrayStack(10);             //넉넉하게 사이즈 10
        int index = 0;
        int count = 0;                                          //'('만났을 때의 처리하기 위함의 count
        String c;
        for(int i = 0; i < scan.length(); i++) {
            c = String.valueOf(scan.charAt(i));
            //c를 검사해서 후위식을 만든다.
            if("+-*/()".indexOf(String.valueOf(scan.charAt(i))) >= 0) {
                if(c.equals("*") || c.equals("/")) {                      //곱하기 나누기는 우선 연산자 Stack에 추가
                    if(((ArrayStack) OpStack).isEmpty() == false) {     //스택이 비었는지 확인
                        if (OpStack.peek().equals("*") || OpStack.peek().equals("/")) { //연산자 스택 최고위에 */있을 pop후에 push
                            posfix[index] = (String) OpStack.pop();
                            index++;
                            OpStack.push(c);
                        } else
                            OpStack.push(c);
                    }
                    else
                        OpStack.push(c);
                }
                else if(c.equals("+") || c.equals("-")) {                  //연산자 스택 최고위에 */있을 pop후에 push
                    if(((ArrayStack) OpStack).isEmpty() == false) {     //스택이 비었는지 확인
                        if(OpStack.peek().equals("*") || OpStack.peek().equals("/")) {
                            posfix[index] = (String) OpStack.pop();
                            index++;
                            OpStack.push(c);
                        } else
                            OpStack.push(c);
                    }
                    else
                        OpStack.push(c);
                }
                else if(c.equals("(")) {
                    count = OpStack.size();
                }
                else if(c.equals(")")) {
                    for(int p = count; count < OpStack.size();) {               //pop을하면 size가 줄기때문에 증감식 필요 x
                        posfix[index] = (String) OpStack.pop();
                        index++;
                    }
                }
            }
            else {                                          //숫자넣는 공간
                posfix[index] = c;
                index++;
            }
        }                                                   //반복문이 끝나면
        for(int q = 0; q < OpStack.size();) {           //OpStack에 남은 연산자들 모두 배열에 넣음
            posfix[index] = (String) OpStack.pop();
            index++;
        }
        return posfix;
    }
}
