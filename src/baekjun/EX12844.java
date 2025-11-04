package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EX12844 {
	
	private static final int len = 1 << 19;
	private static final int SIZE = 1 << 20;
	
	private static int n;
	private static int[] arr;
	private static long[] sumTree, lazy;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		sumTree = new long[SIZE];
		lazy = new long[SIZE];
		makeTree();

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int option = Integer.parseInt(st.nextToken());
			if (option == 1) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				update(1, 0, len - 1, start, end, value);
			} else {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				sb.append(getSum(1, 0, len - 1, start, end) + "\n");
			}
		}
		System.out.println(sb);
	}
	
	private static void makeTree() {
		for (int i = 0; i < n; i++) {
			sumTree[len + i] = arr[i];
		}
		
		for (int i = len - 1; i >= 1; i--) {
			sumTree[i] = sumTree[i * 2] ^ sumTree[i * 2 + 1];
		}
	}
	
	private static void update(int idx, int s, int e, int ts, int te, int value) {
		propagate(idx, s, e);
		
		if (ts > e || te < s) return;
		else if (ts <= s && e <= te) {
			lazy[idx] ^= value;
			propagate(idx, s, e);
			return;
		}
		
		int mid = (s + e) / 2;
		
		update(idx * 2, s, mid, ts, te, value);
		update(idx * 2 + 1, mid + 1, e, ts, te, value);
		
		sumTree[idx] = sumTree[idx * 2] ^ sumTree[idx * 2 + 1];
	}
	
	private static long getSum(int idx, int s, int e, int ts, int te) {
		propagate(idx, s, e);
		
		if (ts > e || te < s) return 0;
		else if (ts <= s && e <= te) return sumTree[idx];
		
		int mid = (s + e) / 2;
		
		long left = getSum(idx * 2, s, mid, ts, te);
		long right = getSum(idx * 2 + 1, mid + 1, e, ts, te);
		
		return left ^ right;
	}
	
	private static void propagate(int idx, int s, int e) {
		if (idx < len) {
			lazy[2 * idx] ^= lazy[idx];
			lazy[2 * idx + 1] ^= lazy[idx];
		}
		if ((e - s + 1) % 2 == 1) { //k^k = 0일때,
			sumTree[idx] ^= lazy[idx];
		}
		lazy[idx] = 0;
	}
}
