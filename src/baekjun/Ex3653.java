package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex3653 {
	
	private static final int SIZE = 1 << 19;
	private static final int LEN = 1 << 18;
	
	private static int n, m, nextIndex;
	private static int[] tree, indexArr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			tree = new int[SIZE];
			indexArr = new int[SIZE];
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			makeTreeIndex();
			
			nextIndex = n;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int next = Integer.parseInt(st.nextToken());
				
				int idx = indexArr[next];
				
				int movieCount = getSum(1, 0, LEN-1, idx + 1, n + m - 1);
				sb.append(movieCount + " ");
				update(idx, 0);
				indexArr[next] = nextIndex;
				update(nextIndex++, 1);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	private static void makeTreeIndex() {
		for (int i = 0; i < n; i++) {
			tree[LEN + i] = 1;
			indexArr[i] = n-i;
		}
		
		for (int i = LEN - 1; i >= 1; i--) {
			tree[i] = tree[i * 2] + tree[i * 2 + 1];
		}
	}
	
	private static void update(int index, int value) {
		index += LEN;
		tree[index] = value;
		index /= 2;
		
		while (index >= 1) {
			tree[index] = tree[index * 2] + tree[index * 2 + 1];
			index /= 2;
		}
	}
	
	private static int getSum(int node, int queryLeft, int queryRight, int nodeLeft, int nodeRight) {
		if (queryRight < nodeLeft || nodeRight < queryLeft) return 0;
		if (nodeLeft <= queryLeft && queryRight <= nodeRight) return tree[node];
		
		int mid = (queryLeft + queryRight) / 2;
		
		int left = getSum(2 * node, queryLeft, mid, nodeLeft, nodeRight);
		int right = getSum(2 * node + 1, mid + 1, queryRight, nodeLeft, nodeRight);
		
		return left + right;
		
	}
}
