package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex22858 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] s = new int[n];
		int[] d = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			s[i] = Integer.parseInt(st.nextToken())-1;
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(st.nextToken())-1;
		}
		
		int[] temp;
		for (int i = 0; i < k; i++) {
			temp = new int[n];
			for (int j = 0; j < n; j++) {
				temp[d[j]] = s[j];
			}
			s = temp;
		}
		
		for (int num : s) {
			System.out.print((num + 1) + " ");
		}
	}
}
