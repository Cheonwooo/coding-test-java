package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex5639 {
	
	private static class Node {
		int node;
		Node left;
		Node right;
		
		public Node(int node) {
			this.node = node;
		}

		public Node(int node, Node left, Node right) {
			super();
			this.node = node;
			this.left = left;
			this.right = right;
		}
		
		public void insert(int n) {
			if (n < this.node) {
				if (this.left == null) {
					this.left = new Node(n);
				} else {
					this.left.insert(n);
				}
			} else {
				if (this.right == null) {
					this.right = new Node(n);
				} else {
					this.right.insert(n);;
				}
			}
		}
		
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Node root = new Node(Integer.parseInt(br.readLine()));
		while (true) {
			String str = br.readLine();
			
			if (str == null || str.equals("")) break;
			
			int number = Integer.parseInt(str);
			root.insert(number);
		}
		postOrder(root);
	}
	
	private static void postOrder (Node node) {
		if (node == null) return;
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.node);
	}

}
