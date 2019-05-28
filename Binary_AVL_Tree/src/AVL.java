public class AVL {

    private AVLNode root;

    public void insert(int data) {
        //노드 삽입을 위한 공개함수?
        root = new AVLNode(data);
    }

    private AVLNode insert(int x, AVLNode t) {
        if(t == null) {
            return (new AVLNode(x));
        }

        if (x < t.key) {
            t.left = insert(x, t.left);
        } else if (x > t.key) {
            t.right = insert(x, t.right);
        } else
            return t;

        t.height = 1 + Math.max(t.left.height, t.right.height);

        int balance = t.left.height - t.right.height;

        //left left case
        if (balance > 1 && x < t.left.key) {
            rotateRight();
        }
        //right right case
        if (balance < -1 && x > t.right.key) {
            rotateLeft();
        }

        return t;
    }

    private void rotateLeft() {
        AVLNode x = root.right;
        AVLNode T2 = x.left;

        x.left = root;
        root.right = T2;

        root.height = Math.max(root.left.height, root.right.height) + 1;
        x.height = Math.max(x.left.height, x.right.height) + 1;
    }

    private void rotateRight() {
        AVLNode x = root.left;
        AVLNode T2 = x.right;

        //Perform rotation
        x.right = root;
        root.left = T2;

        //Update heights
        root.height = Math.max(root.left.height, root.right.height) + 1;
        x.height = Math.max(x.left.height, x.right.height) + 1;
    }

    public boolean search(int val) {
        while(root != null) {
            if(root.key == val) {
                return true;
            }
            if(root.key < val) {
                if(root.left != null) {
                    if(root.left.key == val) {
                        return true;
                    }
                    root = root.left;
                } else
                    return false;
            }
            if (root.key > val) {
                if(root.right != null) {
                    if(root.right.key == val) {
                        return true;
                    }
                    root = root.right;
                }else
                    return false;
            }
        }
        return false;
    }

    public void inorder(AVLNode node) {
        if(node != null) {
            inorder(node.left);
            System.out.println(node.key + " ");
            inorder(node.right);
        }
    }

    public void preorder(AVLNode node) {
        if(node != null) {
            preorder(node.left);
            System.out.println(node.key + " ");
            preorder(node.right);
        }
    }

    public void postorder(AVLNode node) {
        if(node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.println(node.key + " ");
        }
    }
}
