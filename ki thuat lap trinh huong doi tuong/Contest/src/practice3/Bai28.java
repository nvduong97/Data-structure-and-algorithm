package practice3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai28 {

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
	Bai28() {
		root = null;
	}

	private void deleteKey(int key) {
		root = deleteRec(root, key);
	}

	private Node deleteRec(Node root, int key) {
		if (root == null) {
			return root;
		}
		if (key < root.key) {
			root.left = deleteRec(root.left, key);
		} else if (key > root.key) {
			root.right = deleteRec(root.right, key);
		} else {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}
			root.key = minValue(root.right);
			root.right = deleteRec(root.right, root.key);
		}
		return root;
	}

	private int minValue(Node root) {
		int minv = root.key;
		while (root.left != null) {
			minv = root.left.key;
			root = root.left;
		}
		return minv;
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

	private Node search(Node root, int key) {
		if (root == null || root.key == key) {
			return root;
		}
		if (root.key > key) {
			return search(root.left, key);
		}
		return search(root.right, key);
	}

	private void duyetGiua(Node root) {
		if (root != null) {
			duyetGiua(root.left);
			System.out.print(root.key + " ");
			duyetGiua(root.right);
		}
	}

	private void duyetTruoc(Node root) {
		if (root != null) {
			System.out.print(root.key + " ");
			duyetTruoc(root.left);
			duyetTruoc(root.right);
		}
	}

	private void duyetSau(Node root) {
		if (root != null) {
			duyetSau(root.left);
			duyetSau(root.right);
			System.out.print(root.key + " ");
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai28 b29 = new Bai28();
		Scanner sc = new Scanner(System.in);
		int a;
		while (sc.hasNextInt()) {
			int t = sc.nextInt();
			switch (t) {
			case 1:
				a = sc.nextInt();
				b29.insert(a);
				break;
			case 2:
				a = sc.nextInt();
				b29.deleteKey(a);
				break;
			case 3:
				b29.duyetTruoc(b29.root);
				System.out.println("");
				break;
			case 4:
				b29.duyetGiua(b29.root);
				System.out.println("");
				break;
			case 5:
				b29.duyetSau(b29.root);
				System.out.println("");
				break;
			}
		}
	}
}
