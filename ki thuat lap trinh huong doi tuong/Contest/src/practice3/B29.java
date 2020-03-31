package practice3;

import java.util.Scanner;

public class B29 { // Node la
	class Node {

		int key;
		Node left, right;

		public Node(int item) {
			key = item;
			left = right = null;
		}
	}

	private Node root;

	// Hàm dựng
	B29() {
		root = null;
	}

	private void insert(int key) {
		root = insertRec(root, key);
	}

	private Node insertRec(Node root, int key) {
		if (root == null) {
			root = new Node(key);
			return root;
		}
		if (key < root.key) {
			root.left = insertRec(root.left, key);
		} else if (key > root.key) {
			root.right = insertRec(root.right, key);
		}
		return root;
	}

	private void duyetTruoc(Node root) {
		if (root != null) {
			if (root.left == null && root.right == null)
				System.out.print(root.key + " ");
			duyetTruoc(root.left);
			duyetTruoc(root.right);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			B29 b29 = new B29();
			int n = sc.nextInt();
			for (int i = 0; i < n; i++)
				b29.insert(sc.nextInt());
			b29.duyetTruoc(b29.root);
			System.out.println("");
		}
	}
}
