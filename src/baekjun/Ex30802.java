package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex30802 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[6];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < 6; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		int shirt = 0;
		int pen = 0;
		
		for (int i = 0; i < 6; i++) {
			shirt += arr[i]/ T;
			if (arr[i] % T != 0) shirt++;
		}
		
		System.out.println(shirt);
		System.out.println(N / P + " " + N % P);
	}

}
