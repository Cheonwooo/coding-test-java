package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex17353 {
	
	private static final int LEN = 1 << 17;
	private static final int SIZE = 1 << 18;
	
	private static int n;
	private static int[] arr;
	private static long[] sumTree, diff, lazy;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sumTree = new long[SIZE];
		diff = new long[SIZE];
		lazy = new long[SIZE];
		
		init(br);
		makeTree();
		
		int q = Integer.parseInt(br.readLine());
		for (int i = 0; i < q; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int query = Integer.parseInt(st.nextToken());
			if (query == 1) {
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				update(1, 0, LEN - 1, left - 1, right - 1, 1);
				update(1, 0, LEN - 1, right, right, -(right - left + 1));
			} else {
				int point = Integer.parseInt(st.nextToken());
				sb.append(getSum(1, 0, LEN - 1, 0, point - 1) + "\n");
			}
		}
		System.out.println(sb);
	}
	
	private static void init(BufferedReader br) throws IOException{
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		diff[0] = arr[0];
		for (int i = 1; i < n; i++) {
			diff[i] = arr[i] - arr[i - 1];
		}
	}

	private static void makeTree() {
		for (int i = 0; i < n; i++) {
			sumTree[LEN + i] = diff[i];
		}
		
		for (int i = LEN - 1; i >= 1; i--) {
			sumTree[i] = sumTree[i * 2] + sumTree[i * 2 + 1]; 
		}
	}
	
	private static void update(int idx, int s, int e, int ts, int te, int value) {
		propagate(idx, s, e);
		
		if (te < s || e < ts) return;
		else if (ts <= s && e <= te) {
			lazy[idx] += value;
			propagate(idx, s, e);
			return;
		}
		
		int mid = (s + e) / 2;
		
		update(idx * 2, s, mid, ts, te, value);
		update(idx * 2 + 1, mid + 1, e, ts, te, value);
		
		sumTree[idx] = sumTree[idx * 2] + sumTree[idx * 2 + 1];
	}
	
	private static void propagate(int idx, int s, int e) { 
		if (idx < LEN) {
			lazy[idx * 2] += lazy[idx];
			lazy[idx * 2 + 1] += lazy[idx];
		}
		sumTree[idx] += lazy[idx] * (e - s + 1);
		lazy[idx] = 0;
	}
	
	private static long getSum(int idx, int s, int e, int ts, int te) {
		propagate(idx, s, e);
		
		if (te < s || e < ts) return 0;
		if (ts <= s && e <= te) return sumTree[idx];
		
		int mid = (s + e) / 2;
		
		long left = getSum(idx * 2, s, mid, ts, te);
		long right = getSum(idx * 2 + 1, mid + 1, e, ts, te);
		
		return left + right;
	}
}
