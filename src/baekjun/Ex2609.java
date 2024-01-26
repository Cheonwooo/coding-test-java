package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
 * ���̵�� : 
 * �־��� ���� �μ����� �ϰ� ��� �������� ��,
 * �ִ����� : �� ���� ���Ե� ����� �ּ��� �� ã��
 * �ּҰ���� : �μ����� �� �� �߿� ������ �ִ��� ���� ã��
 */

public class Ex2609 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int[] arrA = new int[10001];
		int[] arrB = new int[10001];
		
		int index = 2;
		while (a != 1) {
			if (a % index == 0) {
				arrA[index]++;
				a /= index;
			} else {
				index++;
			}
		}
		
		Set<Integer> set = new HashSet<>();
		index = 2;
		while (b != 1) {
			if (b % index == 0) {
				arrB[index]++;
				b /= index;
			} else {
				index++;
			}
		}
		
		int answerMax = 1;
		int answerMin = 1;
		for (int i = 1; i < 10001; i++) {
			if (arrA[i] != 0 || arrB[i] != 0) {
				int max = Math.max(arrA[i], arrB[i]);
				answerMin *= Math.pow(i, max);
			}
			if (arrA[i] != 0 && arrB[i] != 0) {
				int min = Math.min(arrA[i], arrB[i]);
				answerMax *= Math.pow(i, min);
			}
		}
		
		System.out.println(answerMax);
		System.out.println(answerMin);
	}

}
