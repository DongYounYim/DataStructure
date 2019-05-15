public class BinaryTree {
    private Object root;
    private BinaryTree left ,right;

    public BinaryTree(Object root) {
        this.root = root;
    }

    public BinaryTree(Object root, BinaryTree left, BinaryTree right) {
        this(root);
        if(left != null) this.left = left;
        if(right != null) this.right = right;
    }

    public BinaryTree(BinaryTree that) {
        this.root = that.root;
        if(that.left != null) this.left = new BinaryTree(that.left);
        if(that.right != null) this.right = new BinaryTree(that.right);
    }

    public BinaryTree() {

    }

    public Object getRoot() {
        return this.root;
    }

    public Object setRoot(Object root) {
        Object oldroot = this.root;
        this.root = root;
        return oldroot;
    }

    public BinaryTree getLeft() {
        return this.left;
    }

    public BinaryTree setLeft(BinaryTree left) {
        BinaryTree oldleft = this.left;
        this.left = left;
        return oldleft;
    }

    public BinaryTree getRight() {
        return this.right;
    }

    public BinaryTree setRight(BinaryTree right) {
        BinaryTree oldright = this.right;
        this.right = right;
        return oldright;
    }
}
