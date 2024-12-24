package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 메모리 64116kb,, 시간 1288ms

public class Ex2357 {
	
	private static int n, m;
	private static int len = 1 << 17;
	private static int size = 1 << 18;
	private static int[] arr;
	private static int[] maxTree, minTree;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		maxTree = new int[size];
		minTree = new int[size];
		makeTree();
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			System.out.println(getMin(1, 0, len-1, start-1, end-1) + " " + getMax(1, 0, len-1, start-1, end-1));
		}
	}

	public static void makeTree() {
		for (int i = 0; i < n; i++) {
			maxTree[len+i] = arr[i];
			minTree[len+i] = arr[i];
		}
		
		for (int i = len-1; i >= 1; i--) {
			maxTree[i] = Math.max(maxTree[2*i], maxTree[2*i+1]);
			minTree[i] = Math.min(minTree[2*i], minTree[2*i+1]);
		}
	}
	
	public static int getMin(int node, int s, int e, int ts, int te) {
		if (te < s || e < ts) return 1 << 30;
		else if (ts <= s && e <= te) return minTree[node];
		
		int mid = (s + e) / 2;
		
		int left = getMin(2*node, s, mid, ts, te);
		int right = getMin(2*node + 1, mid + 1, e, ts, te);
		
		return Math.min(left, right);
	}
	
	public static int getMax(int node, int s, int e, int ts, int te) {
		if (te < s || e < ts) return -(1 << 30);
		else if (ts <= s && e <= te) return maxTree[node];
		
		int mid = (s + e) / 2;
		
		int left = getMax(2*node, s, mid, ts, te);
		int right = getMax(2*node + 1, mid + 1, e, ts, te);
		
		return Math.max(left, right);
	}
}
