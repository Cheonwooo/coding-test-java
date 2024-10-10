package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Ex1956 {
	
	private static final int INF = (int) 1e9;
	private static List<int[]>[] list = new List[401];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int[][] graph = new int[v+1][v+1];
		
		for (int i = 0; i < 401; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < v+1; i++) {
			Arrays.fill(graph[i], INF);
		}
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			
			graph[from][to] = dis;
		}
		
		for (int k = 1; k < v+1; k++) {
			for (int i = 1; i < v+1; i++) {
				for (int j = 1; j < v+1; j++) {
					if (i == j) continue;
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}
		
		
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < v+1; i++) {
			for (int j = 1; j < v+1; j++) {
				if (i == j) continue;
				if (graph[i][j] == INF || graph[j][i] == INF) continue;
				min = Math.min(min, graph[i][j] + graph[j][i]);
			}
		}
		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}
}
