package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * ���̵�� : n�� �ִ� ũ�Ⱑ 1,000,000�̱� ������
 * �ð����⵵�� 1�� ����� ����ؾ���
 * �� ��� stack �Ǵ� queue�� ���
 * �Է°����� stack�� ��� ����
 * stack�� �����鼭 stack.peek�� ���� ���� ��
 * ���� ���� �� �۴ٸ� �ε��� �״�� count++;
 * ���� ���� �� ũ�ٸ� �ε������� count��ŭ List�� ����
 * 
 * �ð����⵵ : n * 2
 * 
 * �ڷᱸ�� : stack, List
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
