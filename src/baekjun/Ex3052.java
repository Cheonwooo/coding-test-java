package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/*
 * 아이디어 : Set을 이용해서 나머지 저장 후 Set의 size 구하기
 * 
 * 시간복잡도 : 10
 * 
 * 자료구조 : Set
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
