package com.agupta.questions;

/**
 * Implementation of Binary Search Tree
 * 
 * @author agupta
 *
 */
public class BinarySearchTree {
	
	static class Node {
		int val;
		Node left;
		Node right;
		
		Node(int val) {
			this.val = val;
		}
		public boolean equals(Node node) {
			if(this.val == node.val) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	private static Node root;
	
	static void BST_create(int val) {
		Node obj = new Node(val);
		Node parent = null, current = root;
		while (current != null) {
			parent = current;
			if (current.val < val) {
				current = current.right;
			} else {
				current = current.left;
			}
		}
		
		if(root == null) {
			root = obj;
		} else if(parent.val > val) {
			parent.left = obj;
		} else {
			parent.right = obj;
		}
		
	}
	
	static void BST_print(Node root) {
		if(root == null) {
			return;
		}
		
		BST_print(root.left);
		System.out.print(root.val + " ");
		BST_print(root.right);
	}
	
	/**
	 * Returns the least common ancestor for two values
	 * Assumption : both values exist in tree
	 * 
	 * @param root Root of the tree
	 * @param n1 First value
	 * @param n2 Second Value
	 * @return LCA of two values
	 */
	static Node BST_LCA(Node root, int n1, int n2) {
		if(root.val > n1 && root.val > n2) {
			return BST_LCA(root.left,n1,n2);
		} else if (root.val < n1 && root.val < n2)
			return BST_LCA(root.right,n1,n2);
		return root;
	}
	
	public static void main(String args[]) {
		BST_create(5);
		BST_create(1);
		BST_create(2);
		BST_create(6);
		BST_create(9);
		BST_create(0);
		BST_print(root);
		System.out.println("\nLCA of 0 & 1 is : " + BST_LCA(root, 0, 1).val);
		
		Node t1 = new Node(2);
		Node t2 = new Node(2);
		if(t1.equals(t2)) {
			System.out.println("1");
		}
	}

}
