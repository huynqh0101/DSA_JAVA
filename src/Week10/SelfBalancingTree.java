package Week10;

	/* Class node is defined as :
    class Node
    	int val;	//Value
    	int ht;		//Height
    	Node left;	//Left child
    	Node right;	//Right child

	*/

static Node insert(Node root, int val) {
        if (root == null) {
        root = new Node();
        root.val = val;
        root.ht = setHeight(root);
        return root;
        }
        if (val <= root.val) {
        root.left = insert(root.left, val);
        } else if (val > root.val) {
        root.right = insert(root.right, val);
        }
        int b = height(root.left) - height(root.right);

        if (b > 1) {
        if (height(root.left.left) >= height(root.left.right)) {
        root = rightRotate(root);
        } else {
        root.left = leftRotate(root.left);
        root = rightRotate(root);
        }
        } else if (b < -1) {
        if (height(root.right.right) >= height(root.right.left)) {
        root = leftRotate(root);
        } else {
        root.right = rightRotate(root.right);
        root = leftRotate(root);
        }
        } else {
        root.ht = setHeight(root);
        }
        return root;
        }

private static Node rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        y.right = x;
        x.ht = setHeight(x);
        y.ht = setHeight(y);
        return y;
        }

private static Node leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        x.ht = setHeight(x);
        y.ht = setHeight(y);
        return y;
        }

private static int height(Node x) {
        return (x == null) ? -1 : x.ht;
        }

private static int setHeight(Node x) {
        return (x == null) ? -1 : 1 + Math.max(height(x.left), height(x.right));
        }

