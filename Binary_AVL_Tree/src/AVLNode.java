public class AVLNode {
    AVLNode left, right;
    int key;
    int height;

    public AVLNode() {
        left = null;
        right = null;
        key = 0;
        height = 0;
    }

    public AVLNode(int n) {
        left = null;
        right = null;
        key = n;
        height = 0;
    }
}
