package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1976 {
	
	private static int[] parents;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		parents = new int[n+1];
		for (int i = 1; i < n+1; i++) {
			parents[i] = i;
		}
		
		for (int i = 1; i < n+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < n+1; j++) {
				int next = Integer.parseInt(st.nextToken());
				
				if (next == 1) {
					union(i, j);
				}
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken());
		int p = findParent(first);
		for (int i = 1; i < m; i++) {
			int next = Integer.parseInt(st.nextToken());
			if (findParent(next) != p) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
	
	private static int findParent(int a) {
		if (parents[a] == a) return a;
		return parents[a] = findParent(parents[a]);
	}
	
	private static void union(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		
		if (a < b) parents[b] = a;
		else parents[a] = b;
	}
}
