package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Ex17471 {
	
	private static int n, min = Integer.MAX_VALUE;
	private static int[] arr;
	private static boolean[] check;
	private static List<Integer>[] graph;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		graph = new List[n+1];
		for (int i = 0; i < n+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		arr = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int count = Integer.parseInt(st.nextToken());
			for (int j = 0; j < count; j++) {
				int node = Integer.parseInt(st.nextToken());
				graph[i].add(node);
				graph[node].add(i);
			}
		}
		
		for (int i = 1; i < n/2 + 1; i++) {
			check = new boolean[n+1];
			makeGroup(0, 0, i);
		}
		System.out.println((min == Integer.MAX_VALUE) ? -1 : min);
	}

	private static void makeGroup(int depth, int start, int groupSizeA) {
		if (depth == groupSizeA) {
			int[] groupA = buildGroup(true, groupSizeA);
			int[] groupB = buildGroup(false, n - groupSizeA);
//			int groupAIndex = 0;
//			int groupBIndex = 0;
//			for (int i = 0; i < n; i++) {
//				if (check[i]) {
//					groupA[groupAIndex++] = i+1;
//				} else {
//					groupB[groupBIndex++] = i+1;
//				}
//			}
			
			if (isSameGroup(groupA) && isSameGroup(groupB)) {
				int sumGroupA = calculateSum(groupA);
				int sumGroupB = calculateSum(groupB);
				
				min = Math.min(Math.abs(sumGroupA - sumGroupB), min);
			}
			return;
		}
		
		for (int i = start; i < n; i++) {
			check[i] = true;
			makeGroup(depth + 1, i + 1, groupSizeA);
			check[i] = false;
		}
	}
	
	private static int[] buildGroup(boolean flag, int size) {
		int[] group = new int[n+1];
		int index = 0;
		
		for (int i = 1; i < n+1; i++) {
			if (check[i] == flag) group[index++] = i;
		}
		return group;
	}
	
	private static boolean isSameGroup(int[] group) {
		int startNode = group[0];
		
		boolean[] connected = new boolean[n+1];
		for (int i = 0; i < group.length; i++) {
			connected[group[i]] = true;
		}
		
		boolean[] visited = new boolean[n+1];
		bfs(startNode, connected, visited);
		
		for (int i = 1; i < n+1; i++) {
			if (connected[i] && !visited[i]) return false;
		}
		return true;
	}
	
	private static void bfs(int start, boolean[] connected, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = true;
		
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i = 0; i < graph[now].size(); i++) {
				int next = graph[now].get(i);
				if (connected[next] && !visited[next]) {//연결되어 있다면
					visited[next] = true;
					q.offer(next);
				}
			}
		}
	}
	
	private static int calculateSum(int[] group) {
		return IntStream.of(group).map(i -> arr[i]).sum();
	}
}
