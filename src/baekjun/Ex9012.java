package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * ���̵�� : Stack�� �̿��ؼ� '()'�� ��������� pop���� ������
 * stack�� ����ְ� ������ ���� )�� ��� �ٷ� NO ���
 * ������ ���� �ֱ� ���� �� ���� ���� (�� ��� pop�ϰ� �� ���� �ʱ�
 *
 * �ð����⵵ : 1
 * 
 * �ڷᱸ�� : Stack
 */

public class Ex9012 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String[] ps = br.readLine().split("");
			
			if(ps[0].equals(")")) {
				System.out.println("NO");
				continue;
			}
			
			Stack<String> stack = new Stack<>();
			stack.push(ps[0]);
			for (int j = 1; j < ps.length; j++) {
				if (stack.size() != 0 && ps[j].equals(")") && stack.peek().equals("(")) {
					stack.pop();
				} else {
					stack.push(ps[j]);
				}
			}
			
			if (stack.size() == 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

}
