package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ex11281 {

	private static int n, sccIdx, seq = 1;
	private static int[] index, answer;
	private static boolean[] visited;
	private static List<Integer>[] graph;
	private static Stack<Integer> stack = new Stack<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		answer = new int[2*n + 1];
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
			
			graph[transNum(-u)].add(transNum(v));
			graph[transNum(-v)].add(transNum(u));
		}
		
		for (int i = 1; i < 2*n + 1; i++) {
			if (!visited[i]) {
				scc(i);
			}
		}
		
		int[] result = new int[n+1];
		for (int i = 1; i < n+1; i++) {
			if (answer[i] == answer[i + n]) {
				System.out.println(0);
				return;
			}
			if (answer[i] < answer[i + n]) {
				result[i] = 1;
			}
		}
		
		System.out.println(1);
		for (int i = 1; i < n+1; i++) {
			System.out.print(result[i] + " ");
		}
	}
	
	private static int transNum(int number) {
		if (0 < number && number <= n) return number;
		return -number + n;
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
			while (true) {
				int node = stack.pop();
				answer[node] = sccIdx;
				visited[node] = true;
				if (node == now) break;
			}
			sccIdx++;
		}
		return parent;
	}
}
