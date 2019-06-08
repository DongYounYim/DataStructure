public class BinarySearchTree {
    Node root;
    int FLAG = 0;

    public boolean isEmpty() {
        if(this.root == null) {
            return true;
        }
        return false;
    }

    public boolean contains(int value) {
        while(root != null) {
            if(root.key == value) {
                FLAG = 1;
                return true;
            }
            if(root.key < value) {
                if(root.left != null) {
                    if(root.left.key == value) {
                        FLAG = 0;
                        return true;
                    }
                    root = root.left;
                } else
                    return false;
            }
            if (root.key > value) {
                if(root.right != null) {
                    if(root.right.key == value) {
                        FLAG = 0;
                        return true;
                    }
                    root = root.right;
                }else
                    return false;
            }
        }
        return false;
    }

    public boolean insert(int value) {
        if(root == null) {
            root.key = value;
            return true;
        }
        while(root != null) {
            if(root.key > value) {
                if(root.right != null) {
                    root = root.right;
                } else {
                    root.right.key = value;
                    return true;
                }
            }
            if (root.key < value) {
                if(root.left != null) {
                    root = root.left;
                } else {
                    root.left.key = value;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean delete(int value) {
        if(contains(value) && FLAG == 0) {                                 //최상위 루트가 아닌 삭제할 값이
            if(root.left.left == null && root.left.right == null) {       //루트의 왼쪽에 contain되어 있고 서브트리 존재 x
                root.left = null;
                return true;
            }
            if(root.right.left != null && root.right.right == null) {       //루트의 오른쪽에 contain되어 있고 서브트리 존재 x
                root.right = null;
                return true;
            }
            if(root.left.left == null && root.left.right != null) {         //루트의 왼쪽에 contain되어 있고 오른쪽 서브트리만 존재
                root.left = root.left.right;
                return true;
            }
            if(root.left.left != null && root.left.right == null) {         //루트의 왼쪽에 contain되어 있고 왼쪽 서브트리만 존재
                root.left = root.left.left;
                return true;
            }
            if(root.right.left == null && root.right.right != null) {       //루트의 오른쪽에 contain되어 있고 오른쪽 서브트리만 존재
                root.right = root.right.right;
                return true;
            }
            if(root.right.left != null && root.right.right == null) {       //루트의 오른쪽에 contain되어 있고 왼쪽 서브트리만 존재
                root.right = root.right.left;
                return true;
            }
            if(root.left.left != null && root.left.right != null) {         //루트의 왼쪽에 contain되어 있고 양쪽 서브트리 존재
                Node p = root.left.right;
                while(p.left != null) {
                    p = p.left;
                }
                root.left = p;
                return true;
            }
            if(root.right.left != null && root.right.right != null) {       //루트의 오른쪽에 contain되어 있고 양쪽 서브트리 존재
                Node p = root.right.right;
                while(p.left != null) {
                    p = p.left;
                }
                root.left = p;
                return true;
            }
        }
        if(contains(value) && FLAG == 1) {                          //최상위 루트의 값을 삭제하고플때
            if(root.left == null && root.right == null) {           //루트 아래 서브트리가 존재하지않을 때
                root = null;
                return true;
            }
            if(root.left != null && root.right == null) {           //루트 아래 왼쪽 서브트리만 존재할 때
                root = root.left;
                return true;
            }
            if(root.left == null && root.right != null) {           //루트 아래 오른쪽 서브트리만 존재할 때
                root = root.right;
                return true;
            }
            if(root.left != null && root.right != null) {           //루트 아래 서브트리가 모두 존재할 때
                Node p = root.right;
                while(p.left != null) {
                    p = p.left;
                }
                root = p;
                return true;
            }
        }
        return false;
    }
}
