package AVL_Trees;

public class AVLTree {
    class Node {
        int key, height;
        Node left, right;

        Node(int d) {
            key = d;
            height = 1;
        }
    }

    Node root;

    // A utility function to get the height of the tree
    int height(Node N) {
        if (N == null)
            return 0;

        return N.height;
    }

    // A utility function to get maximum of two integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // A utility function to right rotate subtree rooted with y
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // A utility function to left rotate subtree rooted with x
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;


        // Return new root
        return y;
    }

    // Get Balance factor of node N
    int getBalance(Node N) {

        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }

    Node insert(Node node, int key) {
        int lstH, rstH;
        /* 1. Perform the normal BST insertion */
        if (node == null)
            return (new Node(key));

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else // Duplicate keys not allowed
            return node;

        /* 2. Update height of this ancestor node */

        lstH = height(node.left);
        rstH = height(node.right);


        node.height = 1 + max(lstH, rstH);
        // The function also prints height of every node
        System.out.println(" height " + node.height + " " + node.key + " " + rstH + "  " + lstH);
        /* 3. Get the balance factor of this ancestor node to check whether this node became unbalanced */
        int balance = getBalance(node);
        System.out.println(" " + balance + " " + node.key);
        // If this node becomes unbalanced, then there
        // are 4 cases Left-Left Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Right-Right Case

        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }

        // Left-Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right-Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        /* return the (unchanged) node pointer */
        return node;
    }

    //DELETION IN AVL TREE
    Node minValueNode(Node node) {
        Node temp;
        for (temp = node; temp.left != null; temp = temp.left) ;

        return temp;
    }

    Node deleteNode(Node root, int key) {
        if (root == null)
            return root;

        if (key < root.key)
            root.left = deleteNode(root.left, key);

        else if (key > root.key)
            root.right = deleteNode(root.right, key);

        else {

            if ((root.left == null) || (root.right == null)) {
                Node temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;

                if (temp == null) {
                    temp = root;
                    root = null;
                } else
                    root = temp;
            } else {

                Node temp = minValueNode(root.right);

                root.key = temp.key;

                root.right = deleteNode(root.right, temp.key);
            }
        }

        if (root == null)
            return root;

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        int balance = getBalance(root);

        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    //    TREE TRAVERSALS
    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    void inOrder(Node head) {
        if (head != null) {
            inOrder(head.left);
            System.out.print(head.key + " ");
            inOrder(head.right);
        }
    }

    void postOrder(Node head) {
        if (head != null) {
            postOrder(head.left);
            postOrder(head.right);
            System.out.print(head.key + " ");
        }
    }

    public int getTotalNumberOfNodes() {
        return getTotalNumberOfNodes(root);
    }

    private int getTotalNumberOfNodes(Node head) {
        if (head == null)
            return 0;
        else {
            int length = 1;
            length = length + getTotalNumberOfNodes(head.left);
            length = length + getTotalNumberOfNodes(head.right);
            return length;
        }
    }

    public boolean searchElement(int element) {
        return searchElement(root, element);
    }

    private boolean searchElement(Node head, int element) {
        boolean check = false;
        while ((head != null) && !check) {
            int headElement = head.key;
            if (element < headElement)
                head = head.left;
            else if (element > headElement)
                head = head.right;
            else {
                check = true;
                break;
            }
            check = searchElement(head, element);
        }
        return check;
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 45);

//        System.out.println("Preorder traversal of constructed tree is : ");
//        tree.preOrder(tree.root);
//        System.out.println();
//        System.out.println("Inorder traversal of constructed tree is : ");
//        tree.inOrder(tree.root);
//        System.out.println();
//        System.out.println("Postorder traversal of constructed tree is : ");
//        tree.postOrder(tree.root);
//        System.out.println();
//        System.out.println("the Total number of nodes are: " + tree.getTotalNumberOfNodes());

//        System.out.println(tree.searchElement(tree.root, 45));
//        System.out.println("Deleting the Node 35");
        tree.deleteNode(tree.root,30);
    }
}