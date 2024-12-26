package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 메모리 71496kb, 시간 992ms

public class Ex12837 {

	private static final int LEN = 1 << 20;
	private static final int SIZE = 1 << 21;
	
	private static int n;
	private static long[] tree;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		tree = new long[SIZE];
		
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			
			int command = Integer.parseInt(st.nextToken());
			if (command == 1) {
				int index = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				update(index, value);
			} else {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				System.out.println(get(1, 0, LEN-1, from, to));
			}
		}
	}
	
	public static void update(int idx, int value) {
		idx += LEN;
		tree[idx] += value;
		idx /= 2;
		
		while (idx >= 1) {
			tree[idx] = tree[idx*2] + tree[idx*2+1];
			idx /= 2;
		}
	}
	
	public static long get(int node, int s, int e, int ts, int te) {
		if (e < ts || te < s) return 0;
		else if (ts <= s && e <= te) return tree[node];
		
		int mid = (s + e) / 2;
		
		long left = get(2 * node, s, mid, ts ,te);
		long right = get(2 * node + 1, mid + 1, e, ts, te);
		
		return left + right;
	}
}
