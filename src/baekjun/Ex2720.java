package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/*
 * ���̵�� : List�� ����~��� ����
 * �ε��� ������ ���鼭 ���� �����ϱ�
 * 
 * �ð����⵵ : 1
 * 
 * �ڷᱸ�� : List, StringBuilder
 */

public class Ex2720 {
	private static StringBuilder sb = new StringBuilder();
	private static final List<Integer> changes = List.of(25, 10, 5, 1);

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			int change = Integer.parseInt(br.readLine());
			calculateChange(change);
		}
		System.out.println(sb);
	}
	
	private static void calculateChange(int change) {
		for (int i = 0; i < changes.size(); i++) {
			int changeCount = change / changes.get(i);
			sb.append(changeCount).append(" ");
			change -= changes.get(i)*changeCount;
		}
		sb.append("\n");
	}

}
