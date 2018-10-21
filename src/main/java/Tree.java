
class Tree {

    private Node root;
    public int leftLevel;
    public int rightLevel;

    public void insert(int arg) {
        Node node = new Node();
        node.number = arg;
        if (root == null) {
            root = node;
            leftLevel++;
            rightLevel++;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (arg < current.number) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = node;
                        leftLevel++;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = node;
                        rightLevel++;
                        return;
                    }
                }
            }
        }

    }

}