package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex20040 {
	
	private static int[] parent;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			if (findParent(start) == findParent(end)) {
				System.out.println(i+1);
				return;
			} else {
				union(start, end);
			}
		}
		System.out.println(0);
	}
	
	private static int findParent(int a) {
		if (parent[a] == a) return a;
		return parent[a] = findParent(parent[a]);
	}
	
	private static void union(int a, int b) {
		int pa = findParent(a);
		int pb = findParent(b);
		
		if (pa < pb) parent[pb] = pa;
		else parent[pa] = pb;
	}
}
