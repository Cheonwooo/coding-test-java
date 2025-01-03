package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

// 메모리 16168kb, 시간 160ms

public class Ex14725 {
	
	private static class Node{
		HashMap<String, Node> child;
		
		public Node() {
			child = new HashMap<>();
		}
	}
	
	private static int n;
	private static Node root = new Node();
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int m = Integer.parseInt(st.nextToken());
			Node cur = root;
			for (int j = 0; j < m; j++) {
				String key = st.nextToken();
				
				if (!cur.child.containsKey(key)) {
					cur.child.put(key, new Node());
				}
				cur = cur.child.get(key);
			}
		}
		
		print(root, "");
		System.out.println(sb);
	}

	public static void print(Node cur, String s) {
		ArrayList<String> list = new ArrayList<>(cur.child.keySet());
		Collections.sort(list);
		
		for (String str : list) {
			sb.append(s).append(str).append("\n");
			print(cur.child.get(str), s + "--");
		}
	}
}
