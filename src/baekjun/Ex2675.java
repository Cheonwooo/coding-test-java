package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 아이디어 : charAt()로 반복해서 출력하기
 * 
 * 시간복잡도 : T * S * R = 1000 * 20 * 8 = 160000
 * 
 * 자료구조 : x
 */

public class Ex2675 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) { 
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			
			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				
				for (int k = 0; k < r; k++) {
					System.out.print(c);
				}
			}
			System.out.println();
		}
	}
}
