public class Main {
    public static void levelorder() {               //레벨순회(level_traversal)

    }

    public static void preorder() {                 //전위순회

    }

    public static void postorder() {                //후위순회

    }

    public static void infixorder() {               //중위순회

    }

    public static void main(String args[]) {
        char ch[] = {'F', 'B', 'G', 'A', 'D', 'C', 'E', 'I', 'H'};
        TreeNode tn = new TreeNode();
        for(int i = 0; i < ch.length; i++) {                                    //트리 모양 완성
            tn.insertBST(ch[i]);
        }
    }
}
