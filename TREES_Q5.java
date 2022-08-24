// Importing required functions
import java.util.*;

class InorderSuccessor {
    // Function to find the minimum value node in sub-tree
    static BinaryTreeNode treeMin(BinaryTreeNode root) {
        // Traversing to the left-most child node
        while (root.left != null) {
            root = root.left;
        }

        // Returns the left-most node of given tree
        return root;
    }

    // Function to find the successor in the parent stream
    static BinaryTreeNode parentStreamSuccessor(BinaryTreeNode node) {
        // Traversing upstream using parent pointers to find a parent with a left child
        // node in the same stream
        while (node.parent != null) {
            if (node.parent.left == node) {
                return node.parent;
            }
            node = node.parent;
        }

        // Return null if there's no in-order successor
        return null;
    }

    // Function to find the in-order successor
    static BinaryTreeNode findInorderSuccessorHelper(BinaryTreeNode node) {
        // Null check
        if (node == null) {
            return null;
        }

        // Find minimum node in subtree of the right node if it exists
        if (node.right != null) {
            return treeMin(node.right);
        }

        // Finding the successor in parent stream and returning the result
        return parentStreamSuccessor(node);
    }

    // Function to traverse to the node in question and find its in-order successor
    static BinaryTreeNode findInorderSuccessor(BinaryTreeNode root, int predecessorData) {
        // Traversing and finding the in-order successor
        while (root != null) {
            if (root.data < predecessorData) {
                root = root.right;
            } else if (root.data > predecessorData) {
                root = root.left;
            } else {
                return findInorderSuccessorHelper(root);
            }

            // If node is not found
            if (root == null) {
                BinaryTreeNode tmp = new BinaryTreeNode(-1);
                return tmp;
            }
        }

        // Return null if there's no in-order successor
        return null;
    }

    public static void main(String[] args) {
        // Declaring and creating List of Node values
        List<Integer> input = new ArrayList<Integer>();
        input.add(100);
        input.add(50);
        input.add(200);
        input.add(25);
        input.add(75);
        input.add(125);
        input.add(350);

        // Creating BST from List
        BinaryTree tree = new BinaryTree(input);

        // Populating parent nodes
        tree.populateParents();

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
