public class TreeNode {
    int data;
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
}
