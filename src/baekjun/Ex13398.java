package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ���̵��
 * ������ �ϳ��� �����ϸ鼭 ������1 ����ó�� Ǯ��
 * ������ ������ �ε����� List�� ����
 * Listũ�⸸ŭ for��
 * List�� �ε����� �ش��ϴ� ������ ������ dp�� ���ϰ� max�� ���ϱ�
 * 
 * �ð����⵵
 * n * n
 */

public class Ex13398 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] dpFront = new int[n+1];
		int[] dpBack = new int[n+1];
		int[] arr = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dpFront[1] = arr[1];
		int max = dpFront[1];
		
		for (int i = 2; i < n+1; i++) {
			dpFront[i] = Math.max(dpFront[i-1] + arr[i], arr[i]);
			max = Math.max(max, dpFront[i]);
		}
		
		dpBack[n] = arr[n];
		
		for (int i = n-1; i >= 1; i--) {
			dpBack[i] = Math.max(dpBack[i+1] + arr[i], arr[i]);
		}

		
		for (int i = 2; i < n; i++) {
			max = Math.max(max, dpFront[i-1] + dpBack[i+1]);
		}
		System.out.println(max);
	}
}
