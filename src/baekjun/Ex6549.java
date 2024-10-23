package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//메모리 61480kb, 시간 540ms

public class Ex6549 {
	
	private static long answer;
	private static int n;
	private static int[] tree, arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			answer = 0;
			if (n == 0) break;
			
			arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			tree = new int[4 * n];
			makeTree(1, 0, n-1);
			System.out.println(Arrays.toString(tree));
			sb.append(getMax(1, 0, n-1) + "\n");
		}
		System.out.println(sb);
		
	}
	//최솟값을 가지는 인덱스를 저장하는 쿼리
	//구간에서 최댓값을 구하는 쿼리
	public static void makeTree(int node, int s, int e) {
		if (s == e) {
			tree[node] = s;
			return;
		}
		
		int mid = (s + e) / 2;
		
		makeTree(2 * node, s, mid);
		makeTree(2 * node + 1, mid + 1, e);
		
		if (arr[tree[2 * node]] < arr[tree[2 * node + 1]]) {
			tree[node] = tree[2 * node];
		} else {
			tree[node] = tree[2 * node + 1];
		}
	}
	
	
	public static int getMinIndex(int node, int s, int e, int ts, int te) {
		if (s > te || e < ts) return -1;
		else if (ts <= s && e <= te) {
			return tree[node];
		}
		
		int mid = (s + e) / 2;
		
		int left = getMinIndex(2 * node, s, mid, ts, te);
		int right = getMinIndex(2 * node + 1, mid + 1, e, ts, te);
		
		if (left == -1) return right;
		if (right == -1) return left;
		return (arr[left] <= arr[right]) ? left : right;
	}

	
	public static long getMax(int node, int s, int e) {
		int index = getMinIndex(1, 0, n-1, s, e);
		long area = (e - s + 1) * (long)arr[index];
		answer = Math.max(answer, area);
		if (index - 1 >= s) {
	        long temp = getMax(node, s, index - 1);
	        
	        area = Math.max(area, temp);
	    }
	    // 오른쪽 구간 탐색 (index + 1이 e보다 커지지 않도록)
	    if (index + 1 <= e) {
	    	long temp = getMax(node, index + 1, e);
	    	
	    	area = Math.max(area, temp);
	    }
	    
	    return area;

	}
}

