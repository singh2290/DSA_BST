/***Author Prateek Singh
 * 
 */

package com.gl.dsa.assignment.BST;

public class Driver {
	public Node node;
	public Node prevNode = null;
	public Node headNode = null;

	static class Node {
		int value;
		Node left, right;

		Node(int data) {
			value = data;
			left = right = null;
		}
	}

	public void createSkewedTree(Node root) {
		if (root == null) {
			return;
		}
		createSkewedTree(root.left);
		Node rightNode = root.right;
		if (headNode == null) {
			headNode = root;
			root.left = null;
			prevNode = root;
		} else {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}
		createSkewedTree(rightNode);
	}

	public void traverseRightSkewed(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.value + " -> ");
		traverseRightSkewed(root.right);
	}

	public static void main(String[] args) {
		Driver tree = new Driver();
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.right.left = new Node(55);

		tree.createSkewedTree(tree.node);
		System.out.print("Rightly Skewed Tree is as following: ");
		tree.traverseRightSkewed(tree.headNode);
	}
}
