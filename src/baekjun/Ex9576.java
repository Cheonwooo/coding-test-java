package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Ex9576 {
	
	private static class Node implements Comparable<Node> {
		int a;
		int b;

		public Node(int a, int b) {
			this.a = a;
			this.b = b;
		}
		
		public int compareTo(Node other) {
			if (this.b == other.b) {
				return this.a - other.a;
			}
			return this.b - other.b;
		}
	}
	
	private static List<Node> list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			list = new ArrayList<>();
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				list.add(new Node (a, b));
			}
			Collections.sort(list);
			boolean[] check = new boolean[1001];
			int count = 0;
			for (int i = 0; i < list.size(); i++) {
				Node next = list.get(i);
				
				int a = next.a;
				int b = next.b;
				for (int j = a; j <= b; j++) {
					if (!check[j]) {
						check[j] = true;
						count++;
						break;
					}
				}
			}
			System.out.println(count);
		}
	}
}
