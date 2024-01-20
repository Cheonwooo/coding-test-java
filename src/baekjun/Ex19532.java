package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 아이디어 : x와 y의 값을 -999부터 999까지 구현
 * 방정식에 값을 대입했을 때 boolean 값을 리턴하는 함수 만들기
 * 
 * 시간복잡도 : x * y = 2000 * 2000
 * 
 * 자료구조 : x
 */

public class Ex19532 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		
		for (int i = -999; i <= 999; i++) {
			for (int j = -999; j <= 999; j++) {
				if (((a*i)+(b*j)) == c && ((d*i)+(e*j)) == f) {
					System.out.println(i + " " + j);
					break;
				}
			}
		}
	}

}
