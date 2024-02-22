package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ���̵��
 * ���Ʈ ����
 * while������ x, y���� 1�� �����ϸ鼭 cnt ����
 * ���� x<m, y<n�� ������ ������ x=1, y=1�� �ʱ�ȭ
 * 
 * �ð����⵵
 * n
 * 
 * �ڷᱸ��
 * m,n,x,y,cnt���� ������ int
 * 
 */

public class Ex6064 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			boolean check = false;
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			
			for (int j = x; j < m*n ; j += m) {
				if (j % n == y) {
					sb.append(j + 1).append("\n");
					check = true;
					break;
				}
			}
			
			if (!check) {
				sb.append(-1).append("\n");
			}
		}
		System.out.println(sb);
	}

}
