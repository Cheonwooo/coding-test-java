package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 아이디어 : 17298과 똑같은 문제
 * 단 수가 나타난 횟수로 결정하기 때문에 map을 사용하자.
 * n이 1,000,000이기 때문에 시간복잡도가 1인 자료구조를 사용해야함.
 * 
 * 시간복잡도 : n
 * 
 * 자료구조 : Map, Stack, int[]
 */

public class Ex17299 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		Map<Integer, Integer> map = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] =Integer.parseInt(st.nextToken());
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() &&
					map.get(arr[stack.peek()]) < map.get(arr[i])) {
				arr[stack.pop()] = arr[i];
			}
			stack.push(i);
		}
		
		while (!stack.isEmpty()) {
			arr[stack.pop()] = -1;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb);
	}

}
