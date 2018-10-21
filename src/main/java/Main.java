import java.util.Random;

public class Main {
    public static float notbalance;
    public static Random rnd = new Random();
    public static void main(String[] args) {

        Tree[] tree = new Tree[20];
        for (int i = 0; i < 20; i++) {
            tree[i] = addTree();
        }

        System.out.println((int)(notbalance/20*100) + "% несбалансированных деревьев");
    }

    private static Tree addTree(){
        Tree tree = new Tree();
        while (tree.leftLevel < 6 && tree.rightLevel < 6)
            tree.insert(rnd.nextInt(201) - 100);

        if(Math.abs(tree.rightLevel - tree.leftLevel) > 1)
            notbalance++;

        return tree;
    }
}
