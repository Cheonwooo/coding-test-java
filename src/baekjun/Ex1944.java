package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

// 메모리 50,500kb 시간 288ms

public class Ex1944 {
	private static class Node implements Comparable<Node> {
		int from;
		int to;
		int distance;

		public Node(int from, int to, int distance) {
			this.from = from;
			this.to = to;
			this.distance = distance;
		}
		
		public int compareTo(Node o) {
			return this.distance - o.distance;
		}
	}
	
	private static int n;
	private static int[] parent;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static List<Node> graph = new ArrayList<>();
	private static List<int[]> list = new ArrayList<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][n];
		
		int index = 1;
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				char c =str.charAt(j);
				if (c == 'S') {
					map[i][j] = 0;
					list.add(0, new int[] {0, i, j});
				} else if (c == 'K') {
					map[i][j] = 0;
					list.add(new int[] {index++, i, j});
				} else if (c == '1'){
					map[i][j] = -1;
				} else {
					map[i][j] = 0;
				}
			}
		}
		
		parent = new int[list.size()];
		for (int j = 0; j < list.size(); j++) {
			parent[j] = j;
		}
		
		for (int i = 0; i < list.size(); i++) {
			int[][] tempMap = new int[n][n];
			for (int j = 0; j < n; j++) {
				System.arraycopy(map[j], 0, tempMap[j], 0, n);
			}
			int[] p = list.get(i);
			bfs(tempMap, p[1], p[2]);
			
			for (int j = 0; j < list.size(); j++) {
				if (i == j) continue;
				int[] q = list.get(j);
				if (tempMap[q[1]][q[2]] == 0) continue;
				graph.add(new Node(p[0], q[0], tempMap[q[1]][q[2]]));
			}
		}
		
		Collections.sort(graph);
		
		int answer = 0;
		for (int i = 0; i < graph.size(); i++) {
			Node node = graph.get(i);
			
			int from = node.from;
			int to = node.to;
			int distance = node.distance;
			
			if (findParent(from) != findParent(to)) {
				unionParent(from, to);
				answer += distance;
			}
		}
		
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < parent.length; i++) {
			set.add(parent[i]);
		}
		
		if (set.size() > 1) answer = -1;
		System.out.println(answer);
	}
	

	public static void bfs(int[][] tempMap, int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][n];
		q.add(new int[] {x, y});
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			int[] p = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = p[0] + dx[i];
				int ny = p[1] + dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
				if (tempMap[nx][ny] == -1 || visited[nx][ny]) continue;
				tempMap[nx][ny] = tempMap[p[0]][p[1]] + 1;
				visited[nx][ny] = true;
				q.add(new int[] {nx, ny});
			}
		}
	}
	
	public static int findParent(int a) {
		if (parent[a] == a) return a;
		else return parent[a] = findParent(parent[a]);
	}
	
	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		
		if (a < b) parent[b] = a;
		else parent[a] = b;
	}
}
