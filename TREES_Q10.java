// Importing required functions
import java.util.*;

class ConnectSameLevelNodes {
	// Helper function to connect all children nodes at the next level
	private static BinaryTreeNode connectNextLevel(BinaryTreeNode head) {
		// Declaring the necessary pointers
		BinaryTreeNode current = head;
		BinaryTreeNode nextLevelHead = null;
		BinaryTreeNode prev = null;

		while (current != null) {
			if (current.left != null && current.right != null) {
				// If both current node children are not null
				// then connect them with each other and previous
				// nodes in the same level.
				if (nextLevelHead == null) {
					nextLevelHead = current.left;
				}
				current.left.next = current.right;

				if (prev != null) {
					prev.next = current.left;
				}
				prev = current.right;
			} else if (current.left != null) {
				// If only the left child node is not null
				// then only connect it with previous same level nodes
				if (nextLevelHead == null) {
					nextLevelHead = current.left;
				}
				if (prev != null) {
					prev.next = current.left;
				}
				prev = current.left;
			} else if (current.right != null) {
				// If only the right child node children is not null
				// then only connect it with previous same level nodes
				if (nextLevelHead == null) {
					nextLevelHead = current.right;
				}
				if (prev != null) {
					prev.next = current.right;
				}
				prev = current.right;
			}

			// Update current pointer
			current = current.next;
		}

		// Pointing the last node (right-most node) of the next level
		// to null
		if (prev != null) {
			prev.next = null;
		}

		// Return the head node (left-most node) of the next level
		return nextLevelHead;
	}

	// Function to populate same level pointers
	public static void populateNextPointers(BinaryTreeNode node) {
		if (node != null) {
			node.next = null;
			// While
			do {
				node = connectNextLevel(node);
			} while (node != null);
		}
	}

	// Function to find the given node and return its next node
	public static BinaryTreeNode getNextNode(BinaryTreeNode node, int nodeData) {
		// Performing Binary Search
		while (node != null && nodeData != node.data) {
			if (nodeData < node.data) {
				node = node.left;
			} else {
				node = node.right;
			}
		}

		// If node is not found return -1 else return its next node
		if (node == null) {
			BinaryTreeNode nonExistingNode = new BinaryTreeNode(-1);
			return nonExistingNode;
		} else {
			return node.next;
		}
	}

	public static void main(String[] args) {
		// Initializing the binary tree
		int[] inputs = {100, 50, 200, 25, 75, 300, 10, 350, 15};
		List<Integer> input = new ArrayList<Integer>();
		for (int i = 0; i < inputs.length; i++) {
			input.add(inputs[i]);
		}
		BinaryTree tree = new BinaryTree(input);

		// Function call to populate next pointers
		ConnectSameLevelNodes.populateNextPointers(tree.root);
		int indexVal = 0;
		System.out.println("Binary tree:");
		TreePrint.displayTree(tree.root);
		System.out.println();
		for (Integer nodeValue : input) {
			indexVal++;
			// Function call to find current node and get its next node using next pointer
			BinaryTreeNode tmp = ConnectSameLevelNodes.getNextNode(tree.root, nodeValue);
			String sibNode = "null";
			if (tmp != null) {
				sibNode = String.valueOf(tmp.data);
			}
			System.out.print(indexVal + ".");
			System.out.println("\tCurrent Node Value: " + nodeValue);
			System.out.println("\tNext Node Value: " + sibNode);
			System.out.print(
					"----------------------------------------------------------------------------------------------------\n\n");
		}
	}
}
