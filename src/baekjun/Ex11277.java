package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ex11277 {
	
	private static int v, seq = 1, sccCnt;
	private static int[] index;
	private static boolean[] visited;
	private static List<Integer>[] graph;
	private static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		index = new int[2*v + 1];
		visited = new boolean[2*v + 1];
		graph = new List[2*v + 1];
		for (int i = 0; i < 2*v + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[transNum(-a)].add(transNum(b));
			graph[transNum(-b)].add(transNum(a));
		}
		
		for (int i = 1; i < 2*v + 1; i++) {
			if (!visited[i]) {
				if (scc(i) == -1) {
					System.out.println(0);
					return;
				}
			}
		}
		System.out.println(1);
	}
	
	private static int transNum(int n) {
		if (0 < n && n <= v) return n;
		return -n + v;
	}
	
	private static int scc(int now) {
		index[now] = seq++;
		stack.push(now);
		
		int parent = index[now];
		for (int i = 0; i < graph[now].size(); i++) {
			int next = graph[now].get(i);
			if (index[next] == 0) {
				parent = Math.min(parent, scc(next));
			} else {
				if (!visited[next]) {
					parent = Math.min(parent, index[next]);
				}
			}
		}
		
		if (parent == index[now]) {
			boolean[] check = new boolean[2*v + 1];
			while (!stack.isEmpty()) {
				int node = stack.pop();
				int number = transNum(node);
				
				if (number < 0) {
					number *= -1;
				}
				
				if (check[number]) {
					return -1;
				}
				
				check[number] = true;
				visited[node] = true;
				if (node == now) break;
			}
			sccCnt++;
		}
		return parent;
	}
}
