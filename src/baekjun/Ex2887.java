package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Ex2887 {
	
	private static class Point {
		int x;
		int y;
		int z;
		int idx;

		public Point(int x, int y, int z, int idx) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.idx = idx;
		}
	}
	
	private static class Node implements Comparable<Node>{
		int pre;
		int next;
		int cost;

		public Node(int pre, int next, int cost) {
			this.pre = pre;
			this.next = next;
			this.cost = cost;
		}
		
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	private static int[] parents;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Point[] point = new Point[n];
		List<Node> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			point[i] = new Point(x, y, z, i);
		}
		
		//x좌표 기준 정렬
		Arrays.sort(point, (o1, o2) -> {
			return o1.x - o2.x;
		});
		
		for (int i = 0; i < n-1; i++) {
			list.add(new Node(point[i].idx, point[i+1].idx, Math.abs(point[i].x - point[i+1].x)));
		}
		
		//y좌표 기준 정렬
		Arrays.sort(point, (o1, o2) -> {
			return o1.y - o2.y;
		});
		
		for (int i = 0; i < n-1; i++) {
			list.add(new Node(point[i].idx, point[i+1].idx, Math.abs(point[i].y - point[i+1].y)));
		}
		
		//z좌표 기준 정렬
		Arrays.sort(point, (o1, o2) -> {
			return o1.z - o2.z;
		});
		
		for (int i = 0; i < n-1; i++) {
			list.add(new Node(point[i].idx, point[i+1].idx, Math.abs(point[i].z - point[i+1].z)));
		}
		
		Collections.sort(list);
		
		parents = new int[n];
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
		
		long sum = 0;
		for (Node node: list) {
			if (findParent(node.pre) != findParent(node.next)) {
				union(node.pre, node.next);
				sum += node.cost;
			}
		}
		
		System.out.println(sum);
	}
	
	private static int findParent(int a) {
		if (parents[a] == a) return a;
		else return parents[a] = findParent(parents[a]);
	}
	
	private static void union(int a, int b) {
		int pa = findParent(a);
		int pb = findParent(b);
		
		if (pa < pb) parents[pb] = pa;
		else parents[pa] = pb;
	}

}
