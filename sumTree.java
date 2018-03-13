package contest;

import java.util.Scanner;

public class sumTree {

	Node root;
	class Node {
		int data;
		Node left,right;
		Node(int a){
			data = a;
			left = null;
			right = null;
		}
	}
	
	public Node insert(Node root,int d){
		if (root==null){
			return new Node(d);
		}
		if (d<root.data){
			root.left = insert(root.left,d);
		}
		else {
			root.right = insert(root.right,d);
		}
		return root;
	}
	
	public void print(Node root,int depth){
		if(root==null){
			return;
		}
		print(root.right,depth+1);
		for (int i=0;i<depth;i++){
			System.out.print("  ");
		}
		System.out.print(root.data+"\n");
		print(root.left,depth+1);
		
	}
	int total=0;
	public int sum(Node root){
		if (root==null){
			return total;
		}
		total = total+root.data;
		sum(root.left);
		sum(root.right);
		return total ;
		
	}
	
	public static void main (String args[]){
		sumTree t = new sumTree();
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter n -> ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int d = sc.nextInt();
			t.root = t.insert(t.root,d);
		}
		System.out.println("List\n");
		t.print(t.root,0);
		
		int lef = t.sum(t.root.left);
		System.out.println("sum left ->   "+lef);
		t.total = 0;
		int righ = t.sum(t.root.right);
		System.out.println("sum right ->   "+righ);
		
		if ((lef+righ)==t.root.data){
			System.out.println("Sum is equal to root node");
		}
		else{
			System.out.println("Sum is not equal to root node");
		}
		
	}
}
//7
//5 3 7 1 2 6 8
