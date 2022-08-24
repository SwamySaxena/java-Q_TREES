// Importing required functions
import java.util.*;

class InorderSuccessor {
    // Function to find the minimum value node in sub-tree
    static BinaryTreeNode treeMin(BinaryTreeNode root) {
        // Traversing to the left-most child node
        while (root.left != null) {
            root = root.left;
        }

        // Returns the left-most node of sub-tree
        return root;
    }

    // Function to find the in-order successor
    static BinaryTreeNode findInorderSuccessor(BinaryTreeNode root, int nodeValue) {
        // Null check
        if (root == null) {
            return null;
        }

        // Initializing variable that will store any potential in-order successor
        // node in the parent chain
        BinaryTreeNode successor = null;

        // Loop to traverse to the node in question and find its in-order successor
        while (root != null) {
            // Move root pointer to right child if the nodeValue
            // is more than the current node data
            if (root.data < nodeValue) {
                root = root.right;
            } else if (root.data > nodeValue) {
                // If the nodeValue is less than the current root
                // node then point successor to the current root
                successor = root;
                // and point root pointer to left child
                root = root.left;
            } else {
                // Find min value node of
                // right child's subtree if it exists.
                if (root.right != null) {
                    successor = treeMin(root.right);
                }
                break;
            }

            // If node is not found
            if (root == null) {
                BinaryTreeNode tmp = new BinaryTreeNode(-1);
                return tmp;
            }
        }
        return successor;
    }

    public static void main(String[] args) {
        // Declaring and creating List of Node values
        ArrayList<Integer> input = new ArrayList<Integer>();
        input.add(100);
        input.add(50);
        input.add(200);
        input.add(25);
        input.add(75);
        input.add(125);
        input.add(350);

        // Creating BST from List
        BinaryTree tree = new BinaryTree(input);

        // Adding non-existing nodes to look for in BST
        input.add(10);
        input.add(150);
        input.add(400);

        // Sorting the input List as in-order using java's Collections.sort() function
        Collections.sort(input);

        // Displaying binary tree
        System.out.println("Binary tree:");
        TreePrint.displayTree(tree.root);
        System.out.println();

        int indexVal = 0;
        for (Integer nodeValue : input) {
            indexVal++;

            // Function call to get the in-order successor
            BinaryTreeNode successor = findInorderSuccessor(tree.root, nodeValue);
            System.out.print(indexVal + ".");
            System.out.print("\tNode Value: " + nodeValue + "\n\t");
            if (successor != null)
                System.out.print("Successor Node Value: " + successor.data);
            else
                System.out.print("Successor Node Value: " + "null");
            System.out.print(
                    "\n----------------------------------------------------------------------------------------------------\n\n");
        }
    }
}
