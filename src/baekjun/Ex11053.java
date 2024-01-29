package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * ���̵��
 * n��° ������ �����ϴ� ������ ���� ������ ����
 * d[n] = 0~n-1���� n��° ������ ���� ���� ��� �߿� �ִ�
 * int[] �Է� ���� �� ����
 * 2�� for�� - int[] for��, d[n] = function(�ִ�) + 1
 * �迭�� ������������ ���� - List�������
 * List.get(0)���
 * 
 * �ð����⵵
 * n * n + nlogn
 * 
 * �ڷᱸ��
 * �Է°��� ������ int[]
 * dp���� ������ int[]
 * ���� ������ int
 * 
 */

public class Ex11053 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] input = new int[n];
		int[] dp = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = 0;
		for (int i = 1; i < n; i++) {
			for (int j = i-1; j >= 0; j--) {
				if (input[i] > input[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		
		Integer[] newDp = Arrays.stream(dp).boxed().toArray(Integer[]::new);
		
		Arrays.sort(newDp, Collections.reverseOrder());
		System.out.println(newDp[0]+1);
	}

}
