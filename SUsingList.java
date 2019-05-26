package TestProblems;

import java.util.Scanner;

public class SUsingList {
	
	Node top;
	
	class Node{
		Node next;
		char data;
		Node(char d){
			data=d;
		}
	}
	
	public boolean isEmpty() {
		if (top==null){
			return true;
		}
		return false;
	}
	
	public void add(char d) {
		Node newNode = new Node(d);
		if (top != null) {
			newNode.next = top;
		}
		top = newNode;
	}
	
	public char remove() {
		if (top==null){
			return '?';
		}
		char c = top.data;
		top = top.next;
		return c;
	}
	
	public void prin(){
		if (top==null){
			return;
		}
		Node temp = top;
		while (temp != null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	
	public boolean checkBal(char d, char c) {
		switch (d) {
		case '}':
			if (c != '{') {
				return false;
			}
			break;
		case ')':
			if (c != '(') {
				return false;
			}
			break;
		case ']':
			if (c != '[') {
				return false;
			}
			
		}
		return true;

	}
	
	public static void main(String args[]) {
		SUsingList q = new SUsingList();
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			String ans = "YES";
			String b = sc.next();
			for (int i = 0; i < b.length(); i++) {
				char d1 = b.charAt(i);
				if (d1 == '{' || d1 == '[' || d1 == '(') {
					q.add(d1);
				} else {
					if(q.isEmpty()){
						ans = "NO";
						break;
					}
					char c1 = q.remove();
					if (!q.checkBal(d1, c1) || c1 == '?' ) {
						ans = "NO";
						break;
					}
				}

			}
			if(!q.isEmpty()){
				ans = "NO";
			}
			System.out.println(ans);
		}
		
	}
}