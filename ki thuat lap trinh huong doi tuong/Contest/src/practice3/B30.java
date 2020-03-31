package practice3;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class B30 { // do sau cua cay
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
	B30() {
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

	private int MaxDepth(Node node) {
		if (node == null) {
			return 0;
		} else {
			int lDepth = MaxDepth(node.left);
			int rDepth = MaxDepth(node.right);
			if (lDepth > rDepth) {
				return (lDepth + 1);
			} else {
				return (rDepth + 1);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			B30 b30 = new B30();
			int n = sc.nextInt();
			for (int i = 0; i < n; i++)
				b30.insert(sc.nextInt());
			System.out.println(b30.MaxDepth(b30.root) - 1);
		}
	}
}
