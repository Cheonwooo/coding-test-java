package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 아이디어 : 이중 포인터 방법으로 배열을 역순으로 정렬
 * 
 * 시간복잡도 : m * n
 * 
 * 자료구조 : int[]
 */

public class Ex10811_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] box = new int[n];
		
		for (int i = 0; i < n; i++) {
			box[i] = i+1;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int p = Integer.parseInt(st.nextToken())-1;
			int q = Integer.parseInt(st.nextToken())-1;
			
			box = swap(box, p, q);
		}
		
		for (int i = 0; i < n; i++) {
			System.out.print(box[i] + " ");
		}
	}
	
	private static int[] swap(int[] arr, int p, int q) {
		while (p<q) {
			int temp = arr[q];
			arr[q] = arr[p];
			arr[p] = temp;
			p++;
			q--;
		}
		return arr;
	}

}
