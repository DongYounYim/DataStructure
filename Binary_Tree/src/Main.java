import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void levelorder(TreeNode tn) {               //레벨순회(level_traversal)
        AbstractQueue<TreeNode> q = new LinkedBlockingQueue<>();

        q.add(tn);
        while(!q.isEmpty()) {
            if(tn.left != null) {
                q.add(tn.left);
            }
            if(tn.right != null) {
                q.add(tn.right);
            }
            System.out.print(q.remove().data + " ");
            tn = q.peek();
        }


    }

    public static void preorder(TreeNode tn) {                 //전위순회
        Stack<TreeNode> s = new Stack<TreeNode>();

        s.push(tn);
        while (!s.empty()) {
            tn = s.pop();
            System.out.print(tn.data + " ");

            if (tn.right != null) {

                s.push(tn.right);
            }
            if (tn.left != null) {
                s.push(tn.left);
            }
        }
    }

    public static void postorder(TreeNode tn) {                //후위순회
        Stack<TreeNode> s = new Stack<TreeNode>();

        Stack<TreeNode> o = new Stack<TreeNode>();

        Stack<TreeNode> p = new Stack<TreeNode>();

        s.push(tn);
        while (!s.empty()) {

            tn = s.pop();
            o.push(tn);

            if (tn.left != null) {
                s.push(tn.left);
            }
            if (tn.right != null) {
                s.push(tn.right);
            }

            while (!o.empty()) {
                tn = o.pop();
                p.push(tn);
            }
        }
        while (!p.empty()) {
            tn = p.pop();
            System.out.print(tn.data + " ");
        }
    }

    public static void infixorder(TreeNode tn) {               //중위순회
        Stack<TreeNode> s = new Stack<TreeNode>();

        s.push(tn);
        while (!s.empty()) {

            while (tn.left != null) {

                tn = tn.left;
                s.push(tn);
            }

            tn = s.pop();
            System.out.print(tn.data + " ");

            if (tn.right != null) {
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
