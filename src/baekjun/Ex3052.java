package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/*
 * ���̵�� : Set�� �̿��ؼ� ������ ���� �� Set�� size ���ϱ�
 * 
 * �ð����⵵ : 10
 * 
 * �ڷᱸ�� : Set
 */

public class Ex3052 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<Integer> set = new HashSet<Integer>();
		
		for (int i = 0; i < 10; i++) {
			int number = Integer.parseInt(br.readLine());
			
			int mod = number % 42;
			set.add(mod);
		}
		
		System.out.println(set.size());
	}

}
