package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * ���̵�� : List �̿�
 * �� ó�� Ŀ���� ������ �ε���
 * B�� ��� �ε��� ��ġ�� ���� ����
 * P�� ��� �ε��� ��ġ�� ���� �߰�
 * 
 * �ð����⵵ : m
 * 
 * �ڷᱸ�� : List
 */

public class Ex1406 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<String> stackLeft = new Stack<>();
		Stack<String> stackRight = new Stack<>();
		
		String[] strings = br.readLine().split("");
		
		for (int i = 0; i < strings.length; i++) {
			stackLeft.push(strings[i]);
		}
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String[] command = br.readLine().split(" ");
			
			if (command[0].equals("P")) {
				stackLeft.push(command[1]);
			} else if (command[0].equals("B")) {
				if(!stackLeft.isEmpty()) {
					stackLeft.pop();
				}
			} else if (command[0].equals("L")) {
				if(!stackLeft.isEmpty()) {
					String moveRight = stackLeft.pop();
					stackRight.push(moveRight);
				}
			} else if (command[0].equals("D")) {
				if(!stackRight.isEmpty()) {
					String moveLeft = stackRight.pop();
					stackLeft.push(moveLeft);
				}
			}
		}
		
		while(!stackLeft.isEmpty()) {
			String s = stackLeft.pop();
			stackRight.push(s);
		}
		
		StringBuilder sb = new StringBuilder();
		while(!stackRight.isEmpty()) {
			sb.append(stackRight.pop());
		}
		System.out.println(sb);
	}

}
