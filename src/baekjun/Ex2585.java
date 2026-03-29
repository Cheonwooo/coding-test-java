package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex2585 {
	
	private static int n, k;
	private static boolean check;
	private static boolean[] visited;
	private static int[][] requiredFuel;
	private static List<int[]> points;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		points=  new ArrayList<>();
		points.add(new int[] {0, 0});
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			points.add(new int[] {x, y});
		}
		
		points.add(new int[] {10000, 10000});
		
		requiredFuel = new int[n+2][n+2];
		for (int i = 0; i < n+2; i++) {
			for (int j = 0; j < n+2; j++) {
				if (i == j) continue;
				requiredFuel[i][j] = calculateDist(i, j);
			}
		}
		
		int left = 0;
		int right = 40000;
		int answer = 100_000;
		while (left < right) {
			visited = new boolean[n+2];
			visited[0] = true;
			check = false;
			int mid = (left + right) / 2;
			
			start(mid, 0);
			if (check) {
				answer = Math.min(answer, mid);
				right = mid;
			} else {
				left = mid+1;
			}
		}
		System.out.println(answer);
	}
	
	private static int calculateDist(int x, int y) {
		int[] p1 = points.get(x);
		int[] p2 = points.get(y);
		
		double dist = Math.sqrt(Math.pow(Math.abs(p1[0] - p2[0]), 2) 
				+ Math.pow(Math.abs(p1[1] - p2[1]), 2));
		int fuel = (int)Math.ceil(dist);
		if (fuel % 10 != 0) {
			fuel = fuel / 10 + 1;
		} else {
			fuel = fuel / 10;
		}
		return fuel;
	}
	
	private static void start(int size, int seq) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(0);
		visited = new boolean[n+2];
		visited[seq] = true;
		int count = 0;
		
		while (!q.isEmpty() && count <= k) {
			int qSize = q.size();
			
			for (int i = 0; i < qSize; i++) {
				int now = q.poll();
				
				if (requiredFuel[now][n+1] <= size) {
					check = true;
					return;
				}
				
				for (int j = 1; j < n+2; j++) {
					if (!visited[j] && requiredFuel[now][j] <= size) {
						visited[j] = true;
						q.offer(j);
					}
				}
			}
			count++;
		}
	}
}
