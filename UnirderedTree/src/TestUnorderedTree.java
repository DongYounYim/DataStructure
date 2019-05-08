import java.util.HashSet;
import java.util.Set;

public class TestUnorderedTree {
    public TestUnorderedTree() {
        UnorderedTree treeA, treeB, treeD;
        UnorderedTree treeC = new UnorderedTree("C");
        UnorderedTree treeE = new UnorderedTree("E");
        UnorderedTree treeF = new UnorderedTree("F");
        UnorderedTree treeG = new UnorderedTree("G");

        Set subtreesOfB = new HashSet();
        subtreesOfB.add(treeE);
        subtreesOfB.add(treeF);
        treeB = new UnorderedTree("B", subtreesOfB);

        Set subtreesOfD = new HashSet();
        subtreesOfD.add(treeG);
        treeD = new UnorderedTree("D", subtreesOfD);

        Set subtreesOfA = new HashSet();
        subtreesOfA.add(treeB);
        subtreesOfA.add(treeC);
        subtreesOfA.add(treeD);
        treeA = new UnorderedTree("A", subtreesOfA);
        System.out.println("treeA.size():" + treeA.size());
    }

    public static void main(String args[]) {
        new TestUnorderedTree();
    }
}
