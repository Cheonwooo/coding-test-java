package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ex22866 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] cnt = new int[n];
		int[] nearTower = new int[n];
		Arrays.fill(nearTower, -100001);
		
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
				stack.pop();
			}
			cnt[i] = stack.size();
			if (cnt[i] > 0) nearTower[i] = stack.peek();
			stack.push(i);
		}
		
		stack = new Stack<>();
		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
				stack.pop();
			}
			int size = stack.size();
			cnt[i] += size;
			if (size > 0 && stack.peek() - i < i - nearTower[i]) {
				nearTower[i] = stack.peek();
			}
			stack.push(i);
		}
		
		for (int i = 0; i < n; i++) {
			if (cnt[i] == 0) {
				System.out.println(0);
			} else {
				System.out.println(cnt[i] + " " + (nearTower[i]+1));
			}
		}
	}

}