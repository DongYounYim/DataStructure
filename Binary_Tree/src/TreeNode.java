//새로 만든 LinkedList로 구현한 이진트리
public class TreeNode {
    char data;
    TreeNode left, right;
    TreeNode root;

    public TreeNode() {
        this.left = null;
        this.right = null;
    }

    public TreeNode(char data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Object getData() {
        return data;
    }

    public TreeNode insertKey(TreeNode root, char x) {
        TreeNode p = root;
        TreeNode newNode = new TreeNode(x);

        if(p == null) {
            return newNode;
        } else if(p.data > newNode.data) {
            p.left = insertKey(p.left, x);
            return p;
        } else if(p.data < newNode.data) {
            p.right = insertKey(p.right, x);
            return p;
        } else
            return p;
    }

    public void insertBST(char x) {
        root = insertKey(root, x);
    }

}
