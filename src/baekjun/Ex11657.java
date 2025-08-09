package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Ex11657 {
	private static class Node{
		int next;
		int cost;

		public Node(int next, int cost) {
			this.next = next;
			this.cost = cost;
		}
	}
	
	private static final long INF = Long.MAX_VALUE;
	private static long[] d;
	private static List<Node>[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		list = new List[n+1];
		for (int i = 0; i < n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		d = new long[n+1];
		Arrays.fill(d, INF);
		d[1] = 0;
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b, c));
			
		}
		
		//n-1번 반복 후 한번 더 반복 했을 때음수 사이클이 존재한다면 -1
		//INF라면 -1
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < n+1; j++) {
				for (int k = 0; k < list[j].size(); k++) {
					Node node = list[j].get(k);
					if (d[j] == Long.MAX_VALUE) continue;
					
					if (d[node.next] > node.cost + d[j]) {
						d[node.next] = node.cost + d[j];

						if (i == n) {
							System.out.println(-1);
							return;
						}
					}
				}
				
			}
		}
		
		for (int i = 2; i < n+1; i++) {
			if (d[i] == Long.MAX_VALUE) {
				System.out.println(-1);
			} else {
				System.out.println(d[i]);
			}
		}
	}

}
