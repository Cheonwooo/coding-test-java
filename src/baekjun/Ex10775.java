package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex10775 {
	
	private static int[] parent;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int g = Integer.parseInt(br.readLine());
		int p = Integer.parseInt(br.readLine());
		parent = new int[g+1];
		
		for (int i = 0; i < g+1; i++) {
			parent[i] = i;
		}
		
		int count = 0;
		for (int i = 0; i < p; i++) {
			int next = Integer.parseInt(br.readLine());
			
			if (findParent(next) == 0) break;
			
			count++;
			union(findParent(next), findParent(next) - 1);
		}
		
		System.out.println(count);
	}
	
	private static void union(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		
		if (a < b) parent[b] = a;
		else parent[a] = b;
	}
	
	private static int findParent(int a) {
		if (parent[a] == a) return a;
		else return parent[a] = findParent(parent[a]);
	}

}
// 1 2
// 1 
// 1 2 3 4
// 1 2 3 