import com.sun.deploy.util.OrderedHashSet;


import java.util.*;

public class OrderedTree {
    private TreeNode root;
    private List subtrees;
    private int size;

    public OrderedTree() {

    }

    public OrderedTree(TreeNode root) {
        this.root = root;
        subtrees = new LinkedList();
        size = 1;
    }

    public ArrayList<ArrayList<Integer>> levelOrderprint() {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root==null) return result;
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        while(!list.isEmpty()) {
            ArrayList<TreeNode> Tplist= new ArrayList<TreeNode>();
            ArrayList<Integer> level = new ArrayList<Integer>();
            while(!list.isEmpty()) {
                TreeNode node = list.remove(0);
                level.add(node.data);
                if(node.left != null) Tplist.add(node.left);
                if(node.right != null) Tplist.add(node.right);
            }
            result.add(level);
            list = Tplist;
        }
        return result;
    }
}
