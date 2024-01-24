package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * ���̵�� : 
 * <>�� ���� split�� �ϰ� �״��� " "�� split
 * 
 * �ð����⵵ : s
 * 
 * �ڷᱸ�� : String[]
 */

public class Ex17413 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		Stack<Character> stackLeft = new Stack<>();
		Stack<Character> stackRight = new Stack<>();
		
		boolean check = false;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '<') {
				check = true;
				if(stackRight.isEmpty()) {
					stackLeft.push(str.charAt(i));
				} else {
					while (!stackRight.isEmpty()) {
						stackLeft.push(stackRight.pop());
					}
					stackLeft.push(str.charAt(i));
				}
			} else if (str.charAt(i) == '>') {
				check = false;
				stackLeft.push(str.charAt(i));
			} else if (check) {
				stackLeft.push(str.charAt(i));
			} else if (str.charAt(i) == ' ' && !check){
				while (!stackRight.isEmpty()) {
					stackLeft.push(stackRight.pop());
				}
				stackLeft.push(str.charAt(i));
			} else if (!check){
				stackRight.push(str.charAt(i));
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while (!stackLeft.isEmpty()) {
			stackRight.push(stackLeft.pop());
		}
		
		while (!stackRight.isEmpty()) {
			sb.append(stackRight.pop());
		}
		System.out.println(sb);
	}

}
