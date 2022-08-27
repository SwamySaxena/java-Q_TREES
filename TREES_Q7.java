// Importing required functions
import java.util.*;

class IsBST {
    // Function to call the recursive BST checker function
    private static boolean isBstRec(BinaryTreeNode root, int min_value, int max_value) {
        // A null value is considered an empty but valid BST so we
        // return true
        if (root == null) {
            return true;
        }

        // Comparing minimum and maximum subtree values with the current
        // node's value
        if (root.data < min_value || root.data > max_value) {
            return false;
        }

        // Checking BST validity in both left and right subtrees
        return isBstRec(root.left, min_value, root.data)
                && isBstRec(root.right, root.data, max_value);
    }

    // Function to call the recursive BST checker function
    public static boolean isBst(BinaryTreeNode root) {
        return isBstRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] argv) {
        // Creating a binary search tree
        List<Integer> input1 = new ArrayList<Integer>();
        input1.add(100);
        input1.add(50);
        input1.add(200);
        input1.add(25);
        input1.add(75);
        input1.add(125);
        input1.add(350);
        BinaryTree tree1 = new BinaryTree(input1);

        // Creating a binary tree with wrong node in left subtree
        BinaryTree tree2 = new BinaryTree(100);
        tree2.insert(50);
        tree2.insert(200);
        tree2.insert(25);
        // Add a node at an incorrect position
        tree2.insertBT(110);
        tree2.insert(125);
        tree2.insert(350);

        // Creating a binary tree with wrong node in right subtree
        BinaryTree tree3 = new BinaryTree(100);
        tree3.insert(50);
        tree3.insert(200);
        tree3.insert(25);
        tree3.insert(75);
        // Add a node at an incorrect position
        tree3.insertBT(90);
        tree3.insert(350);

        // Creating a right degenerate binary search tree
        List<Integer> input4 = new ArrayList<Integer>();
        input4.add(100);
        input4.add(50);
        input4.add(200);
        input4.add(25);
        input4.add(75);
        input4.add(125);
        input4.add(350);
        Collections.sort(input4);
        BinaryTree tree4 = new BinaryTree(input4);

        // Creating a left degenerate binary search tree
        List<Integer> input5 = new ArrayList<Integer>();
        input5.add(100);
        input5.add(50);
        input5.add(200);
        input5.add(25);
        input5.add(75);
        input5.add(125);
        input5.add(350);
        Collections.sort(input5, Collections.reverseOrder());
        BinaryTree tree5 = new BinaryTree(input5);

        // Creating a single node binary search tree
        BinaryTree tree6 = new BinaryTree(100);

        // Defining test cases
        BinaryTreeNode[] testCaseRoots =
                {tree1.root, tree2.root, tree3.root, tree4.root, tree5.root, tree6.root, null};

        for (int i = 0; i < testCaseRoots.length; i++) {
            if (i > 0) {
                System.out.print("\n");
            }
            System.out.println((i + 1) + ".\tBinary tree: ");
            TreePrint.displayTree(testCaseRoots[i]);
            String isBstStr = (isBst(testCaseRoots[i])) ? "Yes" : "No";
            System.out.print("\n\tIs it a binary search tree: " + isBstStr);
            System.out.print(
                    "\n----------------------------------------------------------------------------------------------------\n");
        }
    }
}
