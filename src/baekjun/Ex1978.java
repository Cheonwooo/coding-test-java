package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * ���̵�� : ����� ���ϰ� ����� ������ 2���� �Ҽ�
 * 
 * �ð����⵵ : n
 * 
 * �ڷᱸ�� : List
 */

public class Ex1978 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 0;
		for (int i = 0; i < n; i++) {
			int number = Integer.parseInt(st.nextToken());
			
			List<Integer> list = makeDivisor(number);
			
			if (list.size() == 2) {
				answer++;
			}
		}
		System.out.println(answer);
	}
	
	private static List<Integer> makeDivisor(int number) {
		List<Integer> divisors = new ArrayList<>();
		for (int i = 1; i <= number; i++) {
			if (number % i == 0) {
				divisors.add(i);
			}
		}
		return divisors;
	}

}
