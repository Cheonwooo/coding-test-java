package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 아이디어 : 올라갈 때마다 V이상인지 확인
 * V보다 작다면 B만큼 내려가기
 * 
 * 시간복잡도 : 1
 * 
 * 자료구조 : x
 */

public class Ex2869 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		if ((v-a) % (a-b) == 0) {
			System.out.println((v-a) / (a-b) + 1);
		} else {
			System.out.println((v-a) / (a-b) + 2);
		}
	}

}
