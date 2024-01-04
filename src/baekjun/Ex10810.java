package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 아이디어 : 1~n까지의 배열에서 반복문을 통해 (i-1)번째~ (j-1)번째 박스까지
 * k번 번호가 적힌 공을 넣는다. 만약 공을 넣으려는 박스에 다른 번호의 공이 있어도 
 * 무시하고 넣자
 * 
 * 시간복잡도 : n * m
 * 
 * 자료구조 : int[]
 */

public class Ex10810 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] box = new int[n];
		
		for (int t = 0; t < m; t++) {
			st = new StringTokenizer(br.readLine());
			
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			for (int p = i-1; p <= j-1; p++) {
				box[p] = k;
			}
		}
		
		for (int ball : box) {
			System.out.print(ball + " ");
		}
	}

}
