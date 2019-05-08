import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UnorderedTree {
    public Object root;
    private Set subtrees;
    public int size;
    public UnorderedTree() {

    }

    public UnorderedTree(Object root) {
        this.root = root;
        subtrees = new HashSet();
        size = 1;
    }

    public UnorderedTree(Object root, Set trees) {
        this(root);
        for(Iterator iterator = trees.iterator(); iterator.hasNext();) {
            Object object = iterator.next();
            if (object instanceof UnorderedTree) {
                UnorderedTree tree = (UnorderedTree) object;
                subtrees.add(tree);
                size += tree.size;
            }
        }
    }
    public int size() {
        return size;
    }

}
