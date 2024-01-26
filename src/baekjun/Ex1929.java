package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ���̵�� : ���Ʈ ������ Ǯ ��� �ð��ʰ�����. (n*(n+1))/2
 * Math.sqrt(n)�� �̿����� x
 * �ð����⵵�� O(n)�� ����� ��������.
 * 1~n���� �Ҽ��� ������� ��� �����ϴ� ���
 * 
 * �ð����⵵ : n
 * 
 * �ڷᱸ�� : boolean[]
 */

public class Ex1929 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean[] check = new boolean[m+1];
		
		check[0] = true;
		check[1] = true;
		
		for (int i = 2; i*i < m+1; i++) {
			if (!check[i]) {
				for (int j = i*i; j < m+1; j += i) {
					check[j] = true;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = n; i < m+1; i++) {
			if (!check[i]) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);
	}

}
