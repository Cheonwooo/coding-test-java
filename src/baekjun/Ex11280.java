package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ex11280 {

	private static int n, seq = 1;
	private static int[] index;
	private static boolean[] visited;
	private static List<Integer>[] graph;
	private static Stack<Integer> stack = new Stack<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		index = new int[2*n + 1];
		visited = new boolean[2*n + 1];
		graph = new List[2*n + 1];
		for (int i = 0; i < 2*n + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[transNumber(-u)].add(transNumber(v));
			graph[transNumber(-v)].add(transNumber(u));
		}
		
		for (int i = 1; i < 2*n + 1; i++) {
			if (!visited[i]) {
				if (dfs(i) == -1) {
					System.out.println(0);
					return;
				}
			}
		}
		System.out.println(1);
	}
	
	private static int transNumber(int number) {
		if (0 < number && number <= n) return number;
		return -number + n;
	}
	
	private static int dfs(int now) {
		index[now] = seq++;
		stack.add(now);
		
		int parent = index[now];
		for (int i = 0; i < graph[now].size(); i++) {
			int next = graph[now].get(i);
			if (index[next] == 0) { //아직 방문하지 않았다면
				parent = Math.min(parent, dfs(next));
			} else {
				if (!visited[next]) {//방문은 했지만 scc에 포함되지 않았다면 사이클
					parent = Math.min(parent, index[next]);
				}
			}
		}
		
		if (parent == index[now]) {
			boolean[] check = new boolean[2*n + 1];
			while (true) {
				int next = stack.pop();
				int number = transNumber(next);
				
				if (number < 0) {
					number *= -1;
				}
				
				if (check[number]) {//-x와 x가 같은 사이클에 존재함 -> -1
					return -1;
				}
				
				check[number] = true;
				visited[next] = true;
				if (next == now) break;
			}
		}
		return parent;
	}
}
