// Importing required functions
import java.util.*;

class PrintTreePerimeter {
	// Function to print left tree perimeter
	public static void printLeftPerimeter(BinaryTreeNode root, StringBuilder result) {
		while (root != null) {
			int currVal = root.data;

			// Setting root such that left boundary nodes are printed from top to bottom
			if (root.left != null) {
				root = root.left;
			} else if (root.right != null) {
				root = root.right;
			} else {
				// Break loop on leaf node
				break;
			}

			// Append current node to perimeter result
			result.append(String.valueOf(currVal) + ", ");
		}
	}

	// Function to print right tree perimeter
	public static void printRightPerimeter(BinaryTreeNode root, StringBuilder result) {
		// stack for right side values.
		Stack<Integer> rValues = new Stack<Integer>();

		while (root != null) {
			int currVal = root.data;
			
			// Setting root such that right boundary nodes are stored in stack of right-side values from top to bottom
			if (root.right != null) {
				root = root.right;
			} else if (root.left != null) {
				root = root.left;
			} else {
				// Break loop on leaf node
				break;
			}
			rValues.push(currVal);
		}

		// Appending nodes in reverse order to perimeter result
		while (!rValues.isEmpty()) {
			result.append(String.valueOf(rValues.pop()) + ", ");
		}
	}

	// Function to print leaf nodes perimeter
	public static void printLeafNodes(BinaryTreeNode root, StringBuilder result) {
		if (root != null) {
			// Recursively traversing to leaf nodes
			printLeafNodes(root.left, result);
			printLeafNodes(root.right, result);

			// Append node to result if it's a leaf node
			if (root.left == null && root.right == null) {
				result.append(String.valueOf(root.data) + ", ");
			}
		}
	}

	public static void displayTreePerimeter(BinaryTreeNode root) {
		StringBuilder result = new StringBuilder();
		if (root != null) {
			// If the tree is not null , we immediately add root to our perimeter result
			result.append(String.valueOf(root.data) + ", ");

			// Calling function to print left boundary node
			printLeftPerimeter(root.left, result);

			// Calling function to print leaf nodes
			if (root.left != null || root.right != null) {
				// We don't need to print if root is also the leaf node.
				printLeafNodes(root, result);
			}

			// Calling function to print right boundary node
			printRightPerimeter(root.right, result);
		}
		// Removing trailing comma and space from our result
		if (result.length() > 2) {
			result.deleteCharAt(result.length() - 1);
			result.deleteCharAt(result.length() - 1);
		}

		// Printing result
		System.out.print(result.toString());
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
		input1.add(250);
		input1.add(750);
		input1.add(12);
		input1.add(35);
		input1.add(60);
		input1.add(80);
		input1.add(110);
		input1.add(150);
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
		tree2.insert(250);
		tree2.insert(750);
		tree2.insert(12);
		tree2.insert(35);
		tree2.insertBT(60);
		tree2.insertBT(80);
		tree2.insertBT(120);

		// Creating a binary tree with wrong node in right subtree
		BinaryTree tree3 = new BinaryTree(100);
		tree3.insert(50);
		tree3.insert(200);
		tree3.insert(25);
		tree3.insert(75);
		// Add a node at an incorrect position
		tree3.insertBT(90);
		tree3.insert(350);
		tree3.insert(250);
		tree3.insert(750);
		tree3.insert(12);
		tree3.insert(35);
		tree3.insertBT(60);
		tree3.insertBT(80);
		tree3.insertBT(110);

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
			System.out.println((i + 1) + ".\tBinary tree:");
			TreePrint.displayTree(testCaseRoots[i]);
			System.out.print("\n\tTree Perimeter:\n\t");
			displayTreePerimeter(testCaseRoots[i]);
			System.out.print(
					"\n----------------------------------------------------------------------------------------------------\n");
		}
	}
}
