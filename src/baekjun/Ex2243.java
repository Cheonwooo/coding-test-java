package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2243 {
	
	private static final int SIZE = 1 << 21;
	private static final int LEN = 1 << 20;
	private static int[] countTree;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		countTree = new int[SIZE];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int option = Integer.parseInt(st.nextToken());
			
			if (option == 1) {
				int value = Integer.parseInt(st.nextToken());
				int rank = getCandy(1, 0, LEN-1, value);
				System.out.println(rank+1);
			} else {
				int index = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				update(index-1, value);
			}
		}
	}
	
	private static void update(int index, int value) {
		index += LEN;
		countTree[index] += value;
		index /= 2;
		
		while (index >= 1) {
			countTree[index] = countTree[index * 2] + countTree[index * 2 + 1];
			index /= 2;
		}
	}
	
	private static int getCandy(int node, int queryLeft, int queryRight, int value) {
		if (queryLeft == queryRight) {
			update(queryLeft, -1);
			return queryLeft;
		}
		
		int mid = (queryLeft + queryRight) / 2;
		
		if (countTree[node * 2] >= value) {
			return getCandy(node * 2, queryLeft, mid, value);
		} else {
			return getCandy(node * 2 + 1, mid + 1, queryRight, value - countTree[node * 2]);
		}
	}
}
