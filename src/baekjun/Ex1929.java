package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 아이디어 : 브루트 포스로 풀 경우 시간초과나옴. (n*(n+1))/2
 * Math.sqrt(n)을 이용하자 x
 * 시간복잡도가 O(n)인 방법을 생각하자.
 * 1~n까지 소수의 배수들을 모두 삭제하는 방법
 * 
 * 시간복잡도 : n
 * 
 * 자료구조 : boolean[]
 */

public class Ex1929 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean[] check = new boolean[m+1];
		
		check[0] = true;
		check[1] = true;
		
		for (int i = 2; i*i < m+1; i++) {
			if (!check[i]) {
				for (int j = i*i; j < m+1; j += i) {
					check[j] = true;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = n; i < m+1; i++) {
			if (!check[i]) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);
	}

}
