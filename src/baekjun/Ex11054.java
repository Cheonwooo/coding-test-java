package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ���̵��
 * �����ϴ� ���� + �����ϴ� ����
 * �����ϴ� ������ dp�� ���ϱ�
 * ���� for�� 1~n����, i-1���� 1���� ��<��
 * �����ϴ� ������ ���س��� dp���� ���ϱ�
 * ���� for�� 1~n����, i-1���� 1���� ��>��
 * 
 * �ð����⵵
 * n * n *2
 * 
 * �ڷᱸ��
 * dp�� ������ int[]
 * �Է°� ������ int[]
 * ������ ������ int
 */

public class Ex11054 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] input = new int[n+1];
		int[] dpUp = new int[n+1];
		int[] dpDown = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		//�����ϴ� ���� ���
		dpUp[1] = 1;
		for (int i = 2; i < n+1; i++) {
			for (int j = i-1; j >= 0; j--) {
				if (input[i] > input[j]) {
					dpUp[i] = Math.max(dpUp[i], dpUp[j] + 1);
				}
			}
		}
		
		//�����ϴ� ���� ���
		dpDown[n] = 0;
		for (int i = n-1; i >= 0; i--) {
			for (int j = i+1; j < n+1; j++) {
				if (input[i] > input[j]) {
					dpDown[i] = Math.max(dpDown[i], dpDown[j] + 1);
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < n+1; i++) {
			int sum = dpUp[i] + dpDown[i];
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
}
