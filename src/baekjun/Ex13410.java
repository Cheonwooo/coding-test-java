package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex13410 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[k];
		
		for (int i = 0; i < k; i++) {
			arr[i] = (i+1)*n;
		}
		
		int[] newArr = new int[k];
		for (int i = 0; i < k; i++) {
			StringBuilder sb = new StringBuilder(String.valueOf(arr[i]));
			sb = sb.reverse();
			newArr[i] = Integer.parseInt(sb.toString());
		}
		
		Arrays.sort(newArr);
		System.out.println(newArr[k-1]);
	}

}
