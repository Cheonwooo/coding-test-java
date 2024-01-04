package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ���̵�� : 1~n������ �迭���� �ݺ����� ���� (i-1)��°~ (j-1)��° �ڽ�����
 * k�� ��ȣ�� ���� ���� �ִ´�. ���� ���� �������� �ڽ��� �ٸ� ��ȣ�� ���� �־ 
 * �����ϰ� ����
 * 
 * �ð����⵵ : n * m
 * 
 * �ڷᱸ�� : int[]
 */

public class Ex10810 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] box = new int[n];
		
		for (int t = 0; t < m; t++) {
			st = new StringTokenizer(br.readLine());
			
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			for (int p = i-1; p <= j-1; p++) {
				box[p] = k;
			}
		}
		
		for (int ball : box) {
			System.out.print(ball + " ");
		}
	}

}
