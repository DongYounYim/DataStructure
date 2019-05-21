import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {                                         //tree를 만들고 순회는 반복문으로 구현함
    public static void levelorder(TreeNode tn) {                 //레벨순회(level_traversal)
        AbstractQueue<TreeNode> q = new LinkedBlockingQueue<>(); //큐를 이용한다.

        q.add(tn);                                              //초기 root를 큐에 넣는다
        while(!q.isEmpty()) {                                   //큐가 비워질 때까지 반복
            if(tn.left != null) {                               //루트를 기준으로 왼쪽, 오른쪽 순서로 있는대로 큐에 넣는다.
                q.add(tn.left);
            }
            if(tn.right != null) {
                q.add(tn.right);
            }
            System.out.print(q.remove().data + " ");            //큐의 특성으로 처음들어간 원소 값을 뺀다.(처음에는 초기루트)
            tn = q.peek();                                      //큐의 제일 앞에 있는 값을 루트로 설정한다.
        }


    }

    public static void preorder(TreeNode tn) {                 //전위순회
        Stack<TreeNode> s = new Stack<TreeNode>();                    //스택을 이용한다.

        s.push(tn);                                             //초기 root를 스택에 넣는다.
        while (!s.empty()) {                                    //스택이 비워질 때까지 반복한다.
            tn = s.pop();                                       //스택의 맨 위에 있는 원소를 pop하여 root로 설정한다.
            System.out.print(tn.data + " ");                    //방문 / 그 값을 출력

            if (tn.right != null) {                             //루트 기준의 오른쪽 서브트리가 있으면 서브트리 푸쉬

                s.push(tn.right);
            }
            if (tn.left != null) {                              //루트 기준의 왼쪽 서브트리가 있으면 서브트리 푸쉬
                s.push(tn.left);
            }
        }
    }

    public static void postorder(TreeNode tn) {                //후위순회
        Stack<TreeNode> s = new Stack<TreeNode>();                    //스택을 3개를 이용한다.

        Stack<TreeNode> o = new Stack<TreeNode>();

        Stack<TreeNode> p = new Stack<TreeNode>();

        s.push(tn);                                             //스택 s에 초기 root를 푸쉬한다.
        while (!s.empty()) {                                    //스택 s가 비워질 때까지 반복한다.

            tn = s.pop();                                       //s의 원소를 pop한 뒤 root로 설정한다.
            o.push(tn);                                         //root값을 o스택에 넣어준다.

            if (tn.left != null) {                              //root기준으로 왼쪽에 원소가 있으면 스택 s에 푸쉬
                s.push(tn.left);
            }
            if (tn.right != null) {                             //root기준으로 오른쪽에 원소가 있으면 스택 s에 푸쉬
                s.push(tn.right);
            }

            while (!o.empty()) {                                //o스택이 비어질때 까지 pop하여 순서대로 p스택에 푸쉬한다.
                tn = o.pop();
                p.push(tn);
            }
        }
        while (!p.empty()) {                                    //p스택을 차례대로 pop하여 출력한다.
            tn = p.pop();
            System.out.print(tn.data + " ");
        }
    }

    public static void infixorder(TreeNode tn) {               //중위순회
        Stack<TreeNode> s = new Stack<TreeNode>();              //스택을 이용한다.

        s.push(tn);                                             //초기 root를 스택 s에 push한다.
        while (!s.empty()) {                                    //스택 s가 비워질 때 까지 반복

            while (tn.left != null) {                           //root를 기준으로 왼쪽의 서브트리 가 없을 때까지

                tn = tn.left;                                   //tn = tn.left로 왼쪽 서브트리로 이동하며 원소를 스택에 넣는다.
                s.push(tn);
            }

            tn = s.pop();                                       //스택s에서 하나를 pop하여 root로 설정하고
            System.out.print(tn.data + " ");                    //그 값을 출력한다.

            if (tn.right != null) {                             //root를 기준으로 오른쪽 서브트리로 이동하며 원소를 스택에 넣는다.
                s.push(tn.right);
                tn = tn.right;
            }
        }
    }

    public static void main(String args[]) {
        char ch[] = {'F', 'B', 'G', 'A', 'D', 'C', 'E', 'I', 'H'};
        TreeNode tn = new TreeNode();
        for(int i = 0; i < ch.length; i++) {                                    //트리 모양 완성
            tn.insertBST(ch[i]);
        }
        System.out.println("전위 순회");
        preorder(tn.root);
        System.out.println();
        System.out.println("후위 순회");
        postorder(tn.root);
        System.out.println();
        System.out.println("중위 순회");
        infixorder(tn.root);
        System.out.println();
        System.out.println("레벨 순회");
        levelorder(tn.root);
        System.out.println();
    }
}
