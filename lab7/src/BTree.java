
public class BTree {

    public int degree;



    public Node root;

    public BTree(int degree) {
        this.degree = degree;
        root = new Node(degree);
        root.n = 0;
        root.isLeaf = true;
    }

    public Node search(int value) {
        return this.searchNode(root, value);
    }

    private Node searchNode(Node node, int value) {
        int i = 0;
        if (node == null) {
            return null;
        }
        for (i = 0; i < node.n; i++) {
            if (value < node.elements[i]) {
                break;
            }
            if (value == node.elements[i]) {
                return node;
            }
        }
        if (node.isLeaf) {
            return null;
        } else {
            return searchNode(node.children[i], value);
        }
    }

    private void split(Node xNode, int position, Node yNode) {
        Node zNode = new Node(degree);
        zNode.isLeaf = yNode.isLeaf;
        zNode.n = degree - 1;
        if (degree - 1 >= 0) System.arraycopy(yNode.elements, degree, zNode.elements, 0, degree - 1);
        if (!yNode.isLeaf) {
            if (degree >= 0) System.arraycopy(yNode.children, degree, zNode.children, 0, degree);
        }
        yNode.n = degree - 1;
        if (xNode.n + 1 - (position + 1) >= 0) {
            System.arraycopy(xNode.children, position + 1, xNode.children, position + 1 + 1, xNode.n + 1 - (position + 1));
        }
        xNode.children[position + 1] = zNode;
        if (xNode.n - position >= 0) {
            System.arraycopy(xNode.elements, position, xNode.elements, position + 1, xNode.n - position);
        }
        xNode.elements[position] = yNode.elements[degree -1];
        xNode.n = xNode.n + 1;
    }

    public void add(final int value) {
        Node current = root;
        if (current.n == 2 * degree - 1) {
            Node s = new Node(degree);
            root = s;
            s.isLeaf = false;
            s.n = 0;
            s.children[0] = current;
            split(s, 0, current);
            insert(s, value);
        } else {
            insert(current, value);
        }
    }

    private void insert(Node node, int value) {
        if (node.isLeaf) {
            int i = 0;
            for (i = node.n - 1; i >= 0 && value < node.elements[i]; i--) {
                node.elements[i + 1] = node.elements[i];
            }
            node.elements[i + 1] = value;
            node.n = node.n + 1;
        } else {
            int i = 0;
            i++;
            Node tmp = node.children[i];
            if (tmp.n == 2 * degree - 1) {
                split(node, i, tmp);
                if (value > node.elements[i]) {
                    i++;
                }
            }
            insert(node.children[i], value);
        }
    }

    public void delete(int value) {
        Node node = searchNode(root, value);
        if (node != null) {
            deleteNode(root, value);
        }
    }

    private void deleteNode(Node node, int value) {
        if (node != null) {
            int position = node.find(value);
            if (position != -1) {
                if (node.isLeaf) {
                    int i = 0;
                    while (i < node.n && node.elements[i] != value) {
                        i++;
                    }
                    for (; i < node.n; i++) {
                        if (i != 2 * degree - 2) {
                            node.elements[i] = node.elements[i + 1];
                        }
                    }
                    node.n--;
                    return;
                }
                Node predecessor = node.children[position];
                int predecessorValue;
                if (predecessor.n >= degree) {
                    for (; ; ) {
                        if (predecessor.isLeaf) {
                            predecessorValue = predecessor.elements[predecessor.n - 1];
                            break;
                        } else {
                            predecessor = predecessor.children[predecessor.n];
                        }
                    }
                    deleteNode(predecessor, predecessorValue);
                    node.elements[position] = predecessorValue;
                    return;
                }
                Node nextNode = node.children[position + 1];
                if (nextNode.n >= degree) {
                    int nextValue = nextNode.elements[0];
                    if (!nextNode.isLeaf) {
                        nextNode = nextNode.children[0];
                        for (; ; ) {
                            if (nextNode.isLeaf) {
                                nextValue = nextNode.elements[nextNode.n - 1];
                                break;
                            } else {
                                nextNode = nextNode.children[nextNode.n];
                            }
                        }
                    }
                    deleteNode(nextNode, nextValue);
                    node.elements[position] = nextValue;
                    return;
                }
                int temp = predecessor.n + 1;
                predecessor.elements[predecessor.n++] = node.elements[position];
                for (int i = 0, j = predecessor.n; i < nextNode.n; i++) {
                    predecessor.elements[j++] = nextNode.elements[i];
                    predecessor.n++;
                }
                for (int i = 0; i < nextNode.n + 1; i++) {
                    predecessor.children[temp++] = nextNode.children[i];
                }

                node.children[position] = predecessor;
                for (int i = position; i < node.n; i++) {
                    if (i != 2 * degree - 2) {
                        node.elements[i] = node.elements[i + 1];
                    }
                }
                for (int i = position + 1; i < node.n + 1; i++) {
                    if (i != 2 * degree - 1) {
                        node.children[i] = node.children[i + 1];
                    }
                }
                node.n--;
                if (node.n == 0) {
                    if (node == root) {
                        root = node.children[0];
                    }
                    node = node.children[0];
                }
                deleteNode(predecessor, value);
            } else {
                for (position = 0; position < node.n; position++) {
                    if (node.elements[position] > value) {
                        break;
                    }
                }
                Node temp = node.children[position];
                if (temp.n >= degree) {
                    deleteNode(temp, value);
                    return;
                }
                temp = balance(node, position);
                deleteNode(temp, value);
            }
        }
    }

    private Node balance(Node node, int value) {
        int position = node.find(value);
        if (position != -1) {
            Node temp = node.children[position];
            if (position != node.n && node.children[position + 1].n >= degree) {
                return rotateRight(node, position);
            } else if (position != 0 && node.children[position - 1].n >= degree) {
                return rotateLeft(node, position);
            } else {
                return balanceMerging(node, position);
            }
        } else return null;
    }

    public void balance(int value) {
        balance(root, value);
    }

    private Node rotateRight(Node node, int position) {
        Node temp = node.children[position];
        int divider = node.elements[position];
        Node current = node.children[position + 1];
        node.elements[position] = current.elements[0];
        temp.elements[temp.n++] = divider;
        temp.children[temp.n] = current.children[0];
        if (current.n - 1 >= 0) System.arraycopy(current.elements, 1, current.elements, 0, current.n - 1);
        if (current.n >= 0) System.arraycopy(current.children, 1, current.children, 0, current.n);
        current.n--;
        return temp;
    }

    private Node rotateLeft(Node node, int position) {
        Node temp = node.children[position];
        int divider = node.elements[position - 1];
        Node current = node.children[position - 1];
        node.elements[position - 1] = current.elements[current.n - 1];
        Node child = current.children[current.n];
        current.n--;
        if (temp.n >= 0) System.arraycopy(temp.elements, 0, temp.elements, 1, temp.n);
        temp.elements[0] = divider;
        if (temp.n + 1 >= 0) System.arraycopy(temp.children, 0, temp.children, 1, temp.n + 1);
        temp.children[0] = child;
        temp.n++;
        return temp;
    }

    private Node balanceMerging(Node node, int position) {
        Node left;
        Node right;
        int divider = -1;
        if (position != node.n) {
            divider = node.elements[position];
            left = node.children[position];
            right = node.children[position + 1];
        } else {
            divider = node.elements[position - 1];
            right = node.children[position];
            left = node.children[position - 1];
            position--;
        }
        if (node.n - 1 - position >= 0)
            System.arraycopy(node.elements, position + 1, node.elements, position, node.n - 1 - position);
        if (node.n - (position + 1) >= 0)
            System.arraycopy(node.children, position + 1 + 1, node.children, position + 1, node.n - (position + 1));
        node.n--;
        left.n++;
        left.elements[left.n] = divider;

        for (int i = 0, j = left.n; i < right.n + 1; i++, j++) {
            if (i < right.n) {
                left.elements[j] = right.elements[i];
            }
            left.children[j] = right.children[i];
        }
        left.n += right.n;
        if (node.n == 0) {
            if (node == root) {
                root = node.children[0];
            }
            node = node.children[0];
        }
        return left;
    }

}
