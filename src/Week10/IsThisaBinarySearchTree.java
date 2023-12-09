package Week10;

/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
   boolean checkBST(Node root) {
           return checkBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
           }

private boolean checkBSTUtil(Node node, int minValue, int maxValue) {
        if (node == null) {
        return true;
        }

        if (node.data <= minValue || node.data >= maxValue) {
        return false;
        }

        return checkBSTUtil(node.left, minValue, node.data) && checkBSTUtil(node.right, node.data, maxValue);
        }

