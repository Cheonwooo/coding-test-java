package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex1043 {
	
	private static int[] parent;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parent = new int[n+1];
		for (int i = 0; i < n+1; i++) {
			parent[i] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		int person = Integer.parseInt(st.nextToken());
		for (int i = 0; i < person; i++) {
			parent[Integer.parseInt(st.nextToken())] = 0;
		}
		
		List[] list = new List[m];
		for (int i = 0; i < m; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			person = Integer.parseInt(st.nextToken());
			
			int pre = Integer.parseInt(st.nextToken());
			list[i].add(pre);
			for (int j = 0; j < person-1; j++) {
				int next = Integer.parseInt(st.nextToken());
				list[i].add(next);
				union(pre, next);
				pre = next;
			}
		}
		
		int answer = 0;
		for (int i = 0; i < m; i++) {
			boolean check = false;
			for (int j = 0; j < list[i].size(); j++) {
				if (findParent((int)list[i].get(j)) == 0) {
					check = true;
					break;
				}
			}
			if (!check) answer++;
		}
		System.out.println(answer);
	}
	
	private static int findParent(int a) {
		if (parent[a] == a) return a;
		else if (parent[a] == 0) return 0;
		else return parent[a] = findParent(parent[a]);
	}
	
	private static void union(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		
		if (a < b) parent[b] = a;
		else parent[a] = b;
	}

}
