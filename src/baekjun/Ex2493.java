package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ex2493 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		Stack<int[]> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			if (stack.isEmpty()) {
				sb.append(0 + " ");
				stack.push(new int[] {arr[i], i});
			} else {
				while (true) {
					if (stack.isEmpty()) {
						sb.append(0 + " ");
						stack.push(new int[] {arr[i], i});
						break;
					}
					if (stack.peek()[0] > arr[i]) {
						sb.append((stack.peek()[1] + 1) + " ");
						stack.push(new int[] {arr[i], i});
						break;
					}
					stack.pop();
					
				}
			}
		}
		System.out.println(sb);
	}

}

/*
 * 6 9 5 7 4 10 3 6 4
 * greedy? -> 안됨 시초
 * max저장? -> 안됨 반례가 많음
 * 본인보다 큰 첫번째 값을 찾아야함.
 * 어떻게 찾을까?
 */
