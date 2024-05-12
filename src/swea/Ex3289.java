package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex3289 {
	private static int[] parent;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			parent = new int[n+1];
			
			for (int i = 1; i <= n; i++) {
				parent[i] = i;
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				
				int option = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				if (option == 0) {
					unionParent(x, y);
				} else {
					if (findParent(x) == findParent(y)) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void unionParent(int x, int y) {
		x = findParent(x);
		y = findParent(y);
		
		if (x < y) {
			parent[y] = x;
		} else {
			parent[x] = y;
		}
	}
	
	public static int findParent(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = findParent(parent[x]);
	}

}