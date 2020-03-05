
public class BST {
    private class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int x) {
            value = x;
            left = null;
            right = null;
        }

        public int getValue() {
            return value;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }
    } // end class Node

    private Node root;

    public BST() {
        root = null;
    }

    private int counter = 0;

    public void emptyTree() {
        root = null;
    }

    public boolean isEmpty() {
        if (root == null)
            return true;
        else
            return false;
    }

    public int getRoot() {
        if (root == null)
            return 0;
        else
            return root.value;
    }

    public int getCount() {
        counter = 0;
        if (root == null) {
            return 0;
        }
        else
            return getCount(root);
    }

    private int getCount(Node n) {
        if (n == null)
            return 0;
        else {
            counter++;
            getCount(n.left);
            System.out.println(n.value);
            getCount(n.right);
        }
        return counter;
    }

    public boolean add(int x) {
        if (root == null) {
            root = new Node(x);
            return true;
        } else
            return add(root, x);
    }

    private boolean add(Node N, int x) {
        if (x == N.value) // can't add the same number in a binary search tree
            return false;

        else if (x < N.value) { // if it's less than, it will go on the left
            if (N.left == null) {
                N.left = new Node(x); //if there's initially nothing on the left side
                return true;
            } else {
                return add(N.left, x); // now N is N.left
            }
        } else { // if it's greater than, it will go on the right
            if (N.right == null) {
                N.right = new Node(x); // if there's initially nothing on the right side
                return true;
            } else {
                return add(N.right, x); // now N is N.right
            }
        }
    }

    public void print() {
        if (root == null) {
            System.out.println("Empty List");
        }
        else
            print(root);
    }

    private void print(Node n) { // traversal
        if (n == null)
            return;
        else {
            print(n.left);
            System.out.print(n.value + ", ");
            print(n.right);
        }
    }

    public int getHeight() {
        if (root == null) {
            return 0;
        }
        else {
            return getHeight(root);
        }
    }

    private int getHeight(Node N) {
        // to do
        // if root == null then return 0, if root.left/right == null, then return 1
        // if root.left.left/right.right == null, then return 2 etc.
        if (N == null) {
            return 0;
        }

        else {
            return 1 + (getHeight(N.left) > getHeight(N.right) ? getHeight(N.left) : getHeight(N.right));
        }
    }

    public boolean remove(int x) {
        // to do
        return remove(root, x);
    }

    private boolean remove(Node N, int key) {
        // 3 cases: 1. if Node has no children/ if it's a leaf note or it's a root
        //          2. if Node has one child
        //          3. if Node has two children

        // reference parent node of current node
        Node parent = null;

        // start with root Node
        Node curr = root;

        while (curr != null && curr.value != key) {
            parent = curr;
            if (key < curr.value)
                curr = curr.left;
            else
                curr = curr.right;
        }

        // return if key is not found in the tree
        if (curr == null) {
            return false;
        }

        if (curr.left == null && curr.right == null) {
            if (curr != root) {
                if (parent.left == curr) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }

            // if the tree has only one node (root)
            else {
                root = null;
            }
        } else if (curr.left != null && curr.right != null) {
            // find its in-order successor node
            Node successor = minimumKey(curr.right);

            // store successor value
            int val = successor.value;

            remove(root, successor.value);

            curr.value = val;
        } else {
            Node child = (curr.left != null) ? curr.left : curr.right;

            // if root to be deleted is not a root node,
            // then set its parent to its child;
            if (curr != root) {

                if (curr == parent.left) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
            } else {
                root = child;
            }
        }
        return true;
    }

    private Node minimumKey(Node curr) { // the left most in com.company.BST is the minimum value
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    public void display() {
        String[] A = new String[32];
        for (int i = 0; i < 32; i++)
            A[i] = " . ";
        String temp;
        if (root == null)
            temp = " . ";
        else
            temp = Integer.toString(root.value);
        A[1] = temp;

        buildArray(root, A, 1);

        System.out.println("                                                                                                    ");
        System.out.println("                                                "+A[1]+"                                            ");
        System.out.println("                                                 |                                                 ");
        System.out.println("                     " + A[2] + "-------------------------^-----------------------"+A[3]);
        System.out.println("                       |                                                  | ");
        System.out.println("         "+A[4]+"-----------^-----------"+A[5]+"                      "+A[6]+"-----------^-----------"+A[7]);
        System.out.println("          |                         |                         |                         |       ");
        System.out.println("   "+A[8]+"----^----"+A[9]+"           "+A[10]+"----^----"+A[11]+"           "+A[12]+"----^----"+A[13]+"           "+A[14]+"----^----"+A[15]);
        System.out.println("    |            |            |            |            |            |            |            |    ");
        System.out.println(A[16]+"-^-"+A[17]+"    "+A[18]+"-^-"+A[19]+"    "+A[20]+"-^-"+A[21]+"    "+A[22]+"-^-"+A[23]+"    "+A[24]+"-^-"+A[25]+"    "+A[26]+"-^-"+A[27]+"    "+A[28]+"-^-"+A[29]+"    "+A[30]+"-^-"+A[31]);
        System.out.println("                                                                                                    ");

    }

    private void buildArray(Node n, String[] strArray, int parentIndex) {
        if (parentIndex * 2 + 1 > strArray.length)
            return;
        if (n == null)
            return;
        else {
            String temp;
            if (n.left == null)
                temp = " . ";
            else
                temp = Integer.toString(n.left.value);

            strArray[parentIndex * 2] = String.format("%3s", temp);
            buildArray(n.left, strArray, parentIndex * 2);

            if (n.right == null)
                temp = " . ";
            else
                temp = Integer.toString(n.right.value);

            strArray[parentIndex * 2 + 1] = String.format("%3s", temp);
            buildArray(n.right, strArray, parentIndex * 2 + 1);

        }
    }
}
