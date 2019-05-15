import com.sun.deploy.util.OrderedHashSet;

import javax.swing.tree.TreeNode;
import java.util.*;

public class OrderedTree {
    private Object root, left, right;
    private List subtrees;
    private int size;

    public OrderedTree() {

    }

    public OrderedTree(Object root) {
        this.root = root;
        subtrees = new LinkedList();
        size = 1;
    }

}
