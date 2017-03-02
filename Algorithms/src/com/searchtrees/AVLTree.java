package com.searchtrees;

import java.util.Random;

public class AVLTree {

	private AVLTreeNode root;
	
	public AVLTree() {
		root = null;
	}
	
	public AVLTreeNode find(AVLTreeNode root2,int data) {
		if (root2 == null)
			return null;
		if (root2.data == data) {
			return root2;
		}
		else if(root2.data > data) {
			if(root2.left == null)
				return root2;
			return find(root2.left, data);
		} else {
			if(root2.right == null)
				return root2;
			return find(root2.right, data);
		}	
	}
	
	public AVLTreeNode find_getParent(AVLTreeNode root2,int data) {
		if (root2 == null)
			return null;
		else if (root2.right != null && root2.right.data == data)
			return root2;
		else if (root2.left != null && root2.left.data == data) 
			return root2;
		else if (data > root2.data){
			return find_getParent(root2.right, data);
		} else {
			return find_getParent(root2.left, data);
		}
	}
	
	public void delete(AVLTreeNode root2, int data) {
		if (root2 == null)
			System.out.println("cannot delete since the tree is empty");
		else {
			// find the node
			AVLTreeNode position = find(root2, data);
			// if node is not found, you cannot delete
			if (position.data != data) {
				System.out.println("node not present to delete");
				return;
			}
			// find the parent of the node 
			AVLTreeNode parent = find_getParent(root2, data);
			
			if (parent == null) {
				System.out.println("I am deleting the root node!");
				if (position.left == null) {
 					AVLTreeNode replace = getSmallest(position.right);
					root2.data       = replace.data;
					delete(position.right, replace.data);
				} else {
					AVLTreeNode replace = getLargest(position.left);
					root2.data       = replace.data;
					delete(position.left, replace.data);
				}
			}
			// if the node to be deleted is leaf node
			else if (position.left == null && position.right == null) {
				// delete the leaf node
				if (position.data < parent.data) {
					parent.left = null;
				} else {
					parent.right = null;
				}
					
			}
			// if the node to be deleted is non-leaf
			// replace the parent's pointer to either smallest of right tree or largest of left tree
			else if (position.data < parent.data) {
				parent.left  = getLargest(parent.left);
			} else {
				parent.right = getSmallest(parent.right);
			}
		}
	}
	
	private AVLTreeNode getSmallest(AVLTreeNode right) {
		AVLTreeNode toReturn = null;
		while (right != null) {
			toReturn = right;
			right = right.left;
		}
		return toReturn;
	}

	private AVLTreeNode getLargest(AVLTreeNode left) {
		AVLTreeNode toReturn = null;
		while (left != null) {
			toReturn = left;
			left = left.right;
		}
		return toReturn;
	}

	public void inset(int data) {
		if (root == null) {
			root = new AVLTreeNode(data);
			root.h = 0;
		}
		else {
			AVLTreeNode position = find(root, data);
			if (position.data == data)
				return;
			else if (position.data < data) {
				position.right = new AVLTreeNode(data);
				
				if ( heightDiff(position.left, position.right) == 2 ) {
					
				}
			}
			else {
				position.left = new AVLTreeNode(data);
				//recomputeHeights(root);
			}
		}	
	}
	
	
	public int heightofTree(AVLTreeNode node) {
		if (node == null)
			return 0;
		return 1+max(heightofTree(node.right),heightofTree(node.left));
	}
	
	public int heightDiff(AVLTreeNode left, AVLTreeNode right) {
		return Math.abs(heightofTree(left) - heightofTree(right));
	}
	
	private int max(int a, int b) {
		return (a>b)?a:b;
	}

	// I/i for inorder, Pr/pr for preorder, Po/po display
	public void display(String order) {
		if (order.toLowerCase().equals("i")) {
			inorder_wrapper();
		} else if(order.toLowerCase().equals("pr")) {
			preorder_wrapper();
		} else {
			postorder_wrapper();
		}
	}
	
	private void postorder_wrapper() {
		postorder(root);
		
	}

	private void postorder(AVLTreeNode root2) {
		if (root2 == null)
			return;
		postorder(root2.left);
		postorder(root2.right);
		System.out.println(root2.data+" ");
	}

	private void preorder_wrapper() {
		preorder(root);
		
	}

	private void preorder(AVLTreeNode root2) {
		if (root2 == null)
			return;
		System.out.println(root2.data+" ");
		preorder(root2.left);
		preorder(root2.right);
	}

	private void inorder_wrapper() {
		inorder(root);
	}

	private void inorder(AVLTreeNode root2) {
		if (root2 == null)
			return;
		inorder(root2.left);
		System.out.println(root2.data+" AND HEIGHT  "+root2.h);
		inorder(root2.right);
		
	}
	
	

	public static void main(String[] args) {
		AVLTree bst = new AVLTree();
		Random r = new Random();
		int[] data = new int[6];
		for(int i=0;i<data.length;++i) {
			data[i] = r.nextInt(100);
			bst.inset(data[i]);
		}
		System.out.println("Data in the Array");
		for(int x:data)
			System.out.print(x+"  ");
		System.out.println("Data in the BST After insert is");
		bst.display("i");
		System.out.println("deleting the node "+data[0]);
		bst.delete(bst.root, data[0]);
		bst.display("i");
	}

}
