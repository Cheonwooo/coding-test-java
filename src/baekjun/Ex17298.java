package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 아이디어 : n의 최대 크기가 1,000,000이기 때문에
 * 시간복잡도가 1인 방법을 사용해야함
 * 이 경우 stack 또는 queue를 사용
 * 입력값들을 stack에 모두 삽입
 * stack에 넣으면서 stack.peek와 다음 수를 비교
 * 다음 수가 더 작다면 인덱스 그대로 count++;
 * 다음 수가 더 크다면 인덱스부터 count만큼 List에 저장
 * 
 * 시간복잡도 : n * 2
 * 
 * 자료구조 : stack, List
 */

public class Ex17298 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		Stack<Integer> stack = new Stack<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				arr[stack.pop()] = arr[i];
			}
			stack.push(i);
		}
		
		while (!stack.isEmpty()) {
			arr[stack.pop()] = -1;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int number : arr) {
			sb.append(number).append(" ");
		}
		System.out.println(sb);
	}

}
