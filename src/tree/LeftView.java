package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class LeftView {

	Node root;

	class Node {
		public int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = null;
			right = null;
		}
	}

	public Node insert(Node root, int x) {
		if (root == null) {
			Node newNode = new Node(x);
			root = newNode;
			return root;
		}
		if (x > root.data) {
			root.right = insert(root.right, x);
		} else {
			root.left = insert(root.left, x);
		}
		return root;
	}
	
	public void display(Node root, int depth) {
		if (root == null) {
			return;
		}
		display(root.right, depth + 1);
		for (int i = 0; i < depth; i++) {
			System.out.print("  ");
		}
		System.out.print(root.data);
		System.out.print("\n");
		display(root.left, depth + 1);
	}
	
	public static Map<Integer, Integer> leftView(Node root, Map<Integer, Integer> hp, int count) {
		if (root == null) {
			return hp;
		}
		if(!hp.containsKey(count)) {
		hp.put(count, root.data);
		}
		leftView(root.left, hp, count + 1);
		leftView(root.right, hp, count + 1);
		return hp;
	}
	
	public static Map<Integer, Integer> rightView(Node root, Map<Integer, Integer> hp, int count) {
		if (root == null) {
			return hp;
		}
		if(!hp.containsKey(count)) {
		hp.put(count, root.data);
		}
		rightView(root.right, hp, count + 1);
		rightView(root.left, hp, count + 1);
		return hp;
	}
	
	public static Map<Integer, Integer> topView(Node root, Map<Integer, Integer> hp, int count) {
		if (root == null) {
			return hp;
		}
		if(!hp.containsKey(count)) {
		hp.put(count, root.data);
		}
		topView(root.left, hp, count - 1);
		topView(root.right, hp, count + 1);
		return hp;
	}
	
	public static Map<Integer, Integer> bottomView(Node root, Map<Integer, Integer> hp, int count) {
		if (root == null) {
			return hp;
		}
		hp.put(count, root.data);
		bottomView(root.left, hp, count - 1);
		bottomView(root.right, hp, count + 1);
		return hp;
	}
	
	public static int height (Node root) {
		if (root == null) {
			return 0;
		}
		return 1+ Math.max (height (root.left),height (root.right));		
	}
	
	public static void printView(Map<Integer,Integer> hp) {
		for (Object value:hp.values()) {
			System.out.print(" " +value);
		}
		
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n -> ");
		LeftView treeObj = new LeftView();
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int data = sc.nextInt();
			treeObj.root = treeObj.insert(treeObj.root, data);
		}
		treeObj.display(treeObj.root, 0);
		Map<Integer,Integer> hp = new HashMap<Integer,Integer>();
		// Left View
		hp = leftView (treeObj.root,hp,0);
		System.out.println("\nLeftView -> ");
		printView(hp);
		
		// Right View
		hp=new HashMap<Integer,Integer>();
		hp = rightView (treeObj.root,hp,0);
		System.out.println("\nRightView -> ");
		printView(hp);
		
		// Top View
		hp=new HashMap<Integer,Integer>();
		hp = topView (treeObj.root,hp,0);
		System.out.println("\nTopView -> ");
		printView(hp);
		
		// Bottom View
		hp=new HashMap<Integer,Integer>();
		hp = bottomView (treeObj.root,hp,0);
		System.out.println("\nBottomView -> ");
		printView(hp);
	}
}
