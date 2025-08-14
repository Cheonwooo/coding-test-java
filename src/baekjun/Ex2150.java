package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ex2150 {
	
	private static int seq = 1;
	private static int sccCount = 0;
	private static int[] index;
	private static boolean[] visited;
	private static List<Integer>[] graph;
	private static Stack<Integer> stack = new Stack<>();
	private static List<List<Integer>> result = new ArrayList<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		index = new int[v+1];
		visited = new boolean[v+1];
		graph = new List[v+1];
		for (int i = 0; i < v+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
		}
		
		for (int i = 1; i < v+1; i++) {
			if (!visited[i]) {
				dfs(i);
			}
		}
		
		System.out.println(sccCount);
		Collections.sort(result, (o1, o2) -> o1.get(0) - o2.get(0));
		for (List<Integer> list : result) {
			for (int node : list) {
				sb.append(node + " ");
			}
			sb.append(-1 + "\n");
		}
		System.out.println(sb);
	}
	
	private static int dfs(int now) {
		index[now] = seq++;
		stack.add(now);
		
		int parent = index[now];
		for (int i = 0; i < graph[now].size(); i++) {
			int next = graph[now].get(i);
			if (index[next] == 0) {
				parent = Math.min(parent, dfs(next));
			} else {
				if (!visited[next]) {//방문은 했지만 scc가 아니라면 싸이클임
					parent = Math.min(parent, index[next]);
				}
			}
		}
		
		if (parent == index[now]) {
			List<Integer> temp = new ArrayList<>();
			while (true) {
				int node = stack.pop();
				temp.add(node);
				visited[node] = true;
				if (node == now) break;
			}
			Collections.sort(temp);
			result.add(temp);
			sccCount++;
		}
		return parent;
	}

}
