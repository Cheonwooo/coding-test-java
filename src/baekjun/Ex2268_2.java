package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 메모리 320072kb, 시간 3508ms

public class Ex2268_2 {
	
	private static int n, m;
	private static int len = 1 << 20;//배열이 들어갈 리프 노드의 크기
	private static int size = 1 << 21;//전체 트리 크기
	private static int[] arr;
	private static long[] sumTree = new long[size];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		
		makeTree();
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int command  = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int end  = Integer.parseInt(st.nextToken());
			
			if (command == 0) {//sum
				if (start > end) {
					int temp = start;
					start = end;
					end = temp;
				}
				System.out.println(getSum(1, 0, len-1, start, end));
			} else {//modify
				update(start, end);
			}
		}
	}

	public static void makeTree() {
		for (int i = 0; i < n; i++) {
			sumTree[len+i] = arr[i];
		}
		
		for (int i = len-1; i >= 1; i--) {
			sumTree[i] = sumTree[2 * i] + sumTree[2 * i + 1];
		}
	}
	
	public static long getSum(int node, int nodeLeft, int nodeRight, int targetLeft, int targetRight) {
		if (targetRight < nodeLeft || nodeRight < targetLeft) return 0;
		else if (targetLeft <= nodeLeft && nodeRight <= targetRight) return sumTree[node];
		
		int mid = (nodeLeft + nodeRight) / 2;
		
		long left = getSum(2 * node, nodeLeft, mid, targetLeft, targetRight);
		long right = getSum(2 * node + 1, mid + 1, nodeRight, targetLeft, targetRight);
		
		return left + right;
	}
	
	public static void update(int index, int value) {
		index += len;
		sumTree[index] = value;
		index /= 2;
		
		while (index >= 1) {
			sumTree[index] = sumTree[2 * index] + sumTree[2 * index + 1];
			index /= 2;
		}
	}
}
