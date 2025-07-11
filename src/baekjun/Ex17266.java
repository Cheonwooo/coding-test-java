package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex17266 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int max = Integer.MIN_VALUE;
		int[] arr = new int[m];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (i != 0) {//최대 차이 구하기
				int dist = arr[i] - arr[i-1];
				if (dist % 2 == 1) {
					max = Math.max((arr[i] - arr[i-1]) / 2 + 1, max);
				} else {
					max = Math.max((arr[i] - arr[i-1]) / 2, max);
				}
			}
		}
		max = Math.max(Math.max(max, arr[0]), n - arr[m-1]);
		
		System.out.println(max);
	}
}
//0 1 2 3 4 5 6 7 8
//x         x
