package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * ���̵�� : 17298�� �Ȱ��� ����
 * �� ���� ��Ÿ�� Ƚ���� �����ϱ� ������ map�� �������.
 * n�� 1,000,000�̱� ������ �ð����⵵�� 1�� �ڷᱸ���� ����ؾ���.
 * 
 * �ð����⵵ : n
 * 
 * �ڷᱸ�� : Map, Stack, int[]
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
