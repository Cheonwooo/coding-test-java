package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ex2568 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
	
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (int[] o1, int[] o2) -> {
			return o1[0] - o2[0];
		});
		
		//[1]값 기준으로 LIS 시작
		
		int[] LIS = new int[n];
		int[] index = new int[n];
		
		LIS[0] = arr[0][1];
		int len = 1;
		
		for (int i = 1; i < n; i++) {
			int key = arr[i][1];
			
			if (LIS[len - 1] < key) {//끝값보다 key가 크다면
				len++;
				LIS[len - 1] = key;
				index[i] = len-1;//해당 key값은 LIS배열의 i번쨰 인덱스다.
			} else {
				int left = 0;
				int right = len - 1;
				
				while (left < right) {
					int mid = (left + right) / 2;
					
					if (LIS[mid] < key) {
						left = mid + 1;
					} else {
						right = mid;
					}
				}
				
				LIS[left] = key;
				index[i] = left;
			}
		}
		System.out.println(n - len);
		
		Stack<Integer> stack = new Stack<>();
		int idx = len - 1;
		for (int i = n-1; i >= 0; i--) {
			if (index[i] == idx) {
				idx--;
				stack.push(arr[i][0]);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			if (!stack.contains(arr[i][0])) {
				sb.append(arr[i][0] + "\n");
			}
		}
		System.out.println(sb);
	}
}
