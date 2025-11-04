package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1395 {
	
	private static final int len = 1 << 17;
	private static final int SIZE = 1 << 18;
	
	private static int n, m;
	private static int[] tree, lazy;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		tree = new int[SIZE];
		lazy = new int[SIZE];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int option = Integer.parseInt(st.nextToken());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			if (option == 0) {
				update(1, 0, len - 1, left - 1, right - 1);
			} else {
				sb.append(getSum(1, 0, len - 1, left - 1, right - 1) + "\n");
			}
		}
		System.out.println(sb);
	}
	
	private static void propagate(int idx, int s, int e) {
		if (lazy[idx] % 2 == 1) {
			if (idx < len) {//리프노드가 아니라면
				lazy[2 * idx] += lazy[idx];
				lazy[2 * idx + 1] += lazy[idx];
			}
			tree[idx] = (e - s + 1) - tree[idx];
			lazy[idx] = 0;
		}
	}

	private static void update(int idx, int s, int e, int ts, int te) {
		propagate(idx, s, e);
		
		if (s > te || e < ts) return;
		else if (ts <= s && e <= te) {
			lazy[idx] = (lazy[idx] + 1) % 2;
			propagate(idx, s, e);
			return;
		}
		
		int mid = (s + e) / 2;
		
		update(2 * idx, s, mid, ts ,te);
		update(2 * idx + 1, mid + 1, e, ts, te);
		
		tree[idx] = tree[2 * idx] + tree[2 * idx + 1];
	}
	
	private static int getSum(int idx, int s, int e, int ts, int te) {
		propagate(idx, s, e);
		
		if (s > te || e < ts) return 0;
		else if (ts <= s && e <= te) return tree[idx];
		
		int mid = (s + e) / 2;
		
		int left = getSum(idx * 2, s, mid, ts, te);
		int right = getSum(idx * 2 + 1, mid + 1, e, ts ,te);
		
		return left + right;
	}
}
