package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ���̵�� 
 * ���չ���
 * 1���� n���� for�� ����
 * 1���� i�� �����ϰ� for�� �ѹ� �� ���� * m�� ����
 * 
 * �ð����⵵
 * n ^ m = 2^24
 * 
 * �ڷᱸ��
 * �Է°��� ���� �� int
 */

public class Ex15649 {
	private static int n, m;
	private static boolean[] check;
	private static int[] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		check = new boolean[n];
		arr = new int[m];
		
		comb(0);
	}
	
	private static void comb(int depth) {
		if (depth == m) {
			for (int num : arr) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!check[i]) {
				check[i] = true;
				arr[depth] = i + 1;
				comb(depth+1);
				check[i] = false;
			}
		}
	}

}
