package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex10999 {
	
	private static final int SIZE = 1 << 21;
	private static final int LEN = 1 << 20;
	
	private static int n;
	private static long[] arr;
	private static long[] sumTree = new long[SIZE];
	private static long[] lazy = new long[SIZE];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		sumTree = new long[SIZE];
		lazy = new long[SIZE];
		makeTree();
		
		for (int i = 0; i < m+k; i++) {
			st = new StringTokenizer(br.readLine());
			
			int command = Integer.parseInt(st.nextToken());
			if (command == 1) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				long value = Long.parseLong(st.nextToken());
				
				update(1, 0, LEN-1, start-1, end-1, value);
			} else {
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				
				long sum = getSum(1, 0, LEN-1, left-1, right-1);
				sb.append(sum + "\n");
			}
		}
		System.out.println(sb);
	}
	
	private static void makeTree() {
		for (int i = 0; i < n; i++) {
			sumTree[LEN + i] = arr[i];
		}
		
		for (int i = LEN - 1; i >= 1; i--) {
			sumTree[i] =  sumTree[2 * i] + sumTree[2 * i + 1];
		}
	}

	private static void update(int node, int s ,int e, int ts, int te, long value) {
		propagate(node, s, e);
		
		if (s > te || e < ts) return;
		if (ts <= s && e <= te) {
			lazy[node] = value;
			propagate(node, s, e);
			return;
		}
		
		int mid = (s + e) / 2;
		
		update(2 * node, s, mid, ts, te, value);
		update(2 * node + 1, mid + 1, e, ts, te, value);
		
		sumTree[node] = sumTree[2 * node] + sumTree[2 * node + 1];
		
	}
	
	private static void propagate(int node, int s, int e) { 
		if (node < LEN) {
			lazy[2 * node] += lazy[node];
			lazy[2 * node + 1] += lazy[node];
		}
		
		sumTree[node] += lazy[node] * (e - s + 1);
		lazy[node] = 0;
	}
	
	private static long getSum(int node, int s, int e, int ts, int te) {
		propagate(node, s, e);
	
		if (s > te || e < ts) return 0;
		if (ts <= s && e <= te) return sumTree[node];
		
		int mid = (s + e) / 2;
		
		long left = getSum(node * 2, s, mid, ts, te);
		long right = getSum(node * 2 + 1, mid + 1, e, ts, te);
		
		return left + right;
	}

}
