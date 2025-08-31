package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2042 {
	
	private static final int size = 1 << 21;
	private static final int len = 1 << 20;
	private static int n;
	private static long[] arr;
	private static long[] sumTree;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		sumTree = new long[size];
		makeTree();
		
		for (int i = 0; i < m + k; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			
			if (a == 1) {//update
				int b = Integer.parseInt(st.nextToken());
				long c = Long.parseLong(st.nextToken());
				update(b-1, c);
			} else {//getsum
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				long sum = getSum(1, 0, len-1, b-1, c-1);
				System.out.println(sum);
			}
		}
	}

	private static void makeTree() {
		for (int i = 0; i < n; i++) {
			sumTree[len + i] = arr[i];
		}
		
		for (int i = len - 1; i >= 1; i--) {
			sumTree[i] = sumTree[i * 2] + sumTree[i * 2 + 1];
		}
	}
	
	private static void update(int index, long value) {
		index += len;
		sumTree[index] = value;
		index /= 2;
		
		while (index >= 1) {
			sumTree[index] = sumTree[index * 2] + sumTree[index * 2 + 1];
			index /= 2;
		}
	}
	
	private static long getSum(int node, int queryLeft, int queryRight, int nodeLeft, int nodeRight) {
		if (nodeLeft > queryRight || nodeRight < queryLeft) return 0;
		if (nodeLeft <= queryLeft && queryRight <= nodeRight) return sumTree[node];
		
		int mid = (queryLeft + queryRight) / 2;
		
		long left = getSum(2 * node, queryLeft, mid, nodeLeft, nodeRight);
		long right = getSum(2 * node + 1, mid + 1, queryRight, nodeLeft, nodeRight);
		
		return left + right;
	}
}
