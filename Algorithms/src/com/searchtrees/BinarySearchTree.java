package com.searchtrees;

import java.util.Random;

public class BinarySearchTree {

	private BSTNode root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public BSTNode find(BSTNode temp,int data) {
		if (temp == null)
			return null;
		if (temp.data == data) {
			return temp;
		}
		else if(temp.data > data) {
			if(temp.left == null)
				return temp;
			return find(temp.left, data);
		} else {
			if(temp.right == null)
				return temp;
			return find(temp.right, data);
		}	
	}
	
	public BSTNode find_getParent(BSTNode temp,int data) {
		if (temp == null)
			return null;
		else if (temp.right != null && temp.right.data == data)
			return temp;
		else if (temp.left != null && temp.left.data == data) 
			return temp;
		else if (data > temp.data){
			return find_getParent(temp.right, data);
		} else {
			return find_getParent(temp.left, data);
		}
	}
	
	public void delete(BSTNode root, int data) {
		if (root == null)
			System.out.println("cannot delete since the tree is empty");
		else {
			// find the node
			BSTNode position = find(root, data);
			// if node is not found, you cannot delete
			if (position.data != data) {
				System.out.println("node not present to delete");
				return;
			}
			// find the parent of the node 
			BSTNode parent = find_getParent(root, data);
			
			if (parent == null) {
				System.out.println("I am deleting the root node!");
				if (position.left == null) {
 					BSTNode replace = getSmallest(position.right);
					root.data       = replace.data;
					delete(position.right, replace.data);
				} else {
					BSTNode replace = getLargest(position.left);
					root.data       = replace.data;
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
	
	private BSTNode getSmallest(BSTNode temp) {
		BSTNode toReturn = null;
		while (temp != null) {
			toReturn = temp;
			temp = temp.left;
		}
		return toReturn;
	}

	private BSTNode getLargest(BSTNode temp) {
		BSTNode toReturn = null;
		while (temp != null) {
			toReturn = temp;
			temp = temp.right;
		}
		return toReturn;
	}

	public void inset(int data) {
		if (root == null)
			root = new BSTNode(data);
		else {
			BSTNode position = find(root, data);
			if (position.data == data)
				return;
			else if (position.data < data)
				position.right = new BSTNode(data);
			else
				position.left = new BSTNode(data);
		}	
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

	private void postorder(BSTNode temp) {
		if (temp == null)
			return;
		postorder(temp.left);
		postorder(temp.right);
		System.out.println(temp.data+" ");
	}

	private void preorder_wrapper() {
		preorder(root);
		
	}

	private void preorder(BSTNode temp) {
		if (temp == null)
			return;
		System.out.println(temp.data+" ");
		preorder(temp.left);
		preorder(temp.right);
	}

	private void inorder_wrapper() {
		inorder(root);
	}

	private void inorder(BSTNode temp) {
		if (temp == null)
			return;
		inorder(temp.left);
		System.out.println(temp.data+" ");
		inorder(temp.right);
		
	}
	
	

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
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
