// Importing required functions
import java.util.*;

class LevelOrderTraversal {
	public static void levelOrderTraversal(BinaryTreeNode root) {
		// We print null if the root is null
		if (root == null) {
			System.out.print("null");
		} else {
			// Initializing the current queue
			Queue<BinaryTreeNode> current_queue = new ArrayDeque<BinaryTreeNode>();

			// Initializing the dummy node
			BinaryTreeNode dummyNode = new BinaryTreeNode(0);

			// Enqueuing the root and dummy nodes into the current queue
			current_queue.add(root);
			current_queue.add(dummyNode);

			// Printing nodes in level-order until the current queue remains
			// empty
			while (!current_queue.isEmpty()) {
				// Dequeuing and printing the first element of queue
				BinaryTreeNode temp = current_queue.poll();
				System.out.print(temp.data);

				// Adding dequeued node's children to the next queue
				if (temp.left != null) {
					current_queue.add(temp.left);
				}
				if (temp.right != null) {
					current_queue.add(temp.right);
				}

				// When the dummyNode comes next in line, we print a new line and dequeue
				// it from the queue
				if (current_queue.peek() == dummyNode) {
					current_queue.remove();
					// If the queue is still not empty we add back the dummy node
					if (!current_queue.isEmpty()) {
						System.out.print(" : ");
						current_queue.add(dummyNode);
					}
				} else {
					System.out.print(", ");
				}
			}
		}
	}

	public static void main(String[] argv) {
		// Creating a binary tree
		List<Integer> input1 = new ArrayList<Integer>();
		input1.add(100);
		input1.add(50);
		input1.add(200);
		input1.add(25);
		input1.add(75);
		input1.add(350);
		BinaryTree tree1 = new BinaryTree(input1);

		// Creating a right degenerate binary tree
		List<Integer> input2 = new ArrayList<Integer>();
		input2.add(100);
		input2.add(50);
		input2.add(200);
		input2.add(25);
		input2.add(75);
		input2.add(350);
		Collections.sort(input2);
		BinaryTree tree2 = new BinaryTree(input2);

		// Creating a left degenerate binary tree
		List<Integer> input3 = new ArrayList<Integer>();
		input3.add(100);
		input3.add(50);
		input3.add(200);
		input3.add(25);
		input3.add(75);
		input3.add(350);
		Collections.sort(input3, Collections.reverseOrder());
		BinaryTree tree3 = new BinaryTree(input3);

		// Creating a single node binary tree
		BinaryTree tree4 = new BinaryTree(100);


		BinaryTreeNode[] testCaseRoots = {tree1.root, tree2.root, tree3.root, tree4.root, null};
        String[] testCaseStatements = {"Level-Order Traversal of a normal binary search tree: ",
                "Level-Order Traversal of a right degenerate binary search tree: ",
                "Level-Order Traversal of a left degenerate binary search tree: ",
                "Level-Order Traversal of a single node binary tree: ",
                "Level-Order Traversal of a null tree: "};

        for (int i = 0; i < testCaseRoots.length; i++) {
            if (i > 0) {
                System.out.print("\n");
            }
            System.out.println((i + 1) + ".\tBinary Tree:");
            TreePrint.displayTree(testCaseRoots[i]);;
            System.out.print("\n\t" + testCaseStatements[i] + "\n\t");

            // Printing the in-order list using the method we just implemented
            levelOrderTraversal(testCaseRoots[i]);
            System.out.print(
                    "\n-------------------------------------------------------------------------------------------------------------------------------\n");
        }
	}
}
