package com.searchtrees;

public class AVLTreeNode {
	int     data;
	AVLTreeNode left;
	AVLTreeNode right;
	int     h; // height difference between left subtree and right subtree
	
	public AVLTreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right= null;
	}
}
