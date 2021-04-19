public class Node {
    public int n;
    public int[] elements;
    public Node[] children;
    boolean isLeaf;

    public Node(int t) {
        this.isLeaf = true;
        this.elements = new int[2 * t - 1];
        this.children = new Node[2 * t];
    }

    public int find(int value) {
        for (int i = 0; i < this.n; i++) {
            if (this.elements[i] == value) {
                return i;
            }
        }
        return -1;
    }
}