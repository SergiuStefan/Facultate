import java.util.ArrayList;
import java.util.List;

import javax.xml.soap.Node;

public class TreeFromInorderAndPreOrder {

	public static List<Integer> inOrder = new ArrayList<Integer>();
	public static List<Integer> preOrder = new ArrayList<Integer>();

	public static void main(String[] args) {

		Node root = new Node();
		root.createRoot(5);
		for (int i = 0; i < 9; i++) {
			if (i != 5) {
				root.insert(i);
			}
		}

		inOrder(root);
		preOrder(root);
		for (Integer temp : inOrder) {
			System.out.print(temp + " ");
		}

		System.out.println();
		for (Integer temp : preOrder) {
			System.out.print(temp + " ");
		}

		Node node1 = null;
		node1 = reConstructTree(root, (ArrayList<Integer>) inOrder, true);

		System.out.println();
		inOrder(node1);
		for (Integer temp : inOrder) {
			System.out.print(temp + " ");
		}

		System.out.println();

		for (Integer temp : preOrder) {
			System.out.print(temp + " ");
		}

	}

	public static void inOrder(Node node) {

		if (node != null) {
			inOrder(node.leftchild);
			inOrder.add(node.key);
			inOrder(node.rightChild);
		}

	}

	public static void preOrder(Node node) {

		if (node != null) {
			preOrder.add(node.key);
			preOrder(node.leftchild);
			preOrder(node.rightChild);
		}

	}

	public static Node reConstructTree(Node root, ArrayList<Integer> inOrder,
			boolean isLeft) {

		if (preOrder.size() != 0 && inOrder.size() != 0) {
			return null;
		}

		Node node = new Node();
		node.createRoot(preOrder.get(0));
		if (root != null && isLeft) {
			root.leftchild = node;
		} else if (root != null && !isLeft) {
			root.rightChild = node;
		}
		int indx = inOrder.get(preOrder.get(0));
		preOrder.remove(0);
		List<Integer> leftInorder = getSublist(0, indx);
		reConstructTree(node, (ArrayList<Integer>) leftInorder, true);
		List<Integer> rightInorder = getSublist(indx + 1, inOrder.size());
		reConstructTree(node, (ArrayList<Integer>) rightInorder, false);
		return node;

	}

	public static ArrayList<Integer> getSublist(int start, int end) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = start; i < end; i++) {
			list.add(inOrder.get(i));
		}

		return list;
	}
}