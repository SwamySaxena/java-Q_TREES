// Importing required functions
import java.util.*;

class InorderIterative {
    // Function that prints the in-order traversal of the binary tree
    static void iterativeInorder(BinaryTreeNode root) {
        if (root == null) {
            // If the root is null, we simply print null
            System.out.print("null");
        } else {
            // Initializing the stack
            Stack<BinaryTreeNode> stk = new Stack<BinaryTreeNode>();

            // Initializing and pointing the current node pointer to root
            BinaryTreeNode currNode = root;

            // This loop will keep printing the tree node in "L N R" fashion
            // until the current node is null or the stack becomes empty
            while (!stk.empty() || currNode != null) {
                // If the current node is not null, we push it into the stack and point it
                // to its left child and skip to the next iteration
                if (currNode != null) {
                    stk.push(currNode);
                    currNode = currNode.left;
                    continue;
                }

                // Current node is null, meaning that it's time to print the nodes in the "L"
                // sub-tree
                // So, printing and popping the top-most element of the stack
                System.out.print(stk.peek().data);
                currNode = stk.pop().right;

                // Printing the proper comma separators between nodes
                if (!(stk.empty() && currNode == null)) {
                    System.out.print(", ");
                }
            }
        }
    }

    public static void main(String[] args) {
        // Creating a binary tree
        List<Integer> input1 = new ArrayList<Integer>();
        input1.add(100);
        input1.add(50);
        input1.add(200);
        input1.add(25);
        input1.add(75);
        input1.add(125);
        input1.add(300);
        input1.add(12);
        input1.add(35);
        input1.add(60);
        BinaryTree tree1 = new BinaryTree(input1);

        // Creating a right degenerate binary tree
        List<Integer> input2 = new ArrayList<Integer>();
        input2.add(100);
        input2.add(50);
        input2.add(200);
        input2.add(25);
        input2.add(75);
        input2.add(125);
        input2.add(300);
        input2.add(12);
        input2.add(35);
        input2.add(60);
        Collections.sort(input2);
        BinaryTree tree2 = new BinaryTree(input2);

        // Creating a left degenerate binary tree
        List<Integer> input3 = new ArrayList<Integer>();
        input3.add(100);
        input3.add(50);
        input3.add(200);
        input3.add(25);
        input3.add(75);
        input3.add(125);
        input3.add(300);
        input3.add(12);
        input3.add(35);
        input3.add(60);
        Collections.sort(input3, Collections.reverseOrder());
        BinaryTree tree3 = new BinaryTree(input3);

        // Creating a single node binary tree
        BinaryTree tree4 = new BinaryTree(100);


        BinaryTreeNode[] testCaseRoots = {tree1.root, tree2.root, tree3.root, tree4.root, null};
        String[] testCaseStatements = {"In-Order Traversal of a normal binary search tree: ",
                "In-Order Traversal of a right degenerate binary search tree: ",
                "In-Order Traversal of a left degenerate binary search tree: ",
                "In-Order Traversal of a single node binary tree: ",
                "In-Order Traversal of a null tree: "};

        for (int i = 0; i < testCaseRoots.length; i++) {
            if (i > 0) {
                System.out.print("\n");
            }
            System.out.println((i + 1) + ".\tBinary Tree:");
            TreePrint.displayTree(testCaseRoots[i]);;
            System.out.print("\n\t" + testCaseStatements[i] + "\n\t");

            // Printing the in-order list using the method we just implemented
            InorderIterative.iterativeInorder(testCaseRoots[i]);
            System.out.print(
                    "\n-------------------------------------------------------------------------------------------------------------------------------\n");
        }
    }
}
