package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1027 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		for (int i = 0; i < n; i++) {
			int count = 0;
			double min = 1_000_000_001;
			//왼쪽
			for (int j = i-1; j >= 0; j--) {
				double incline = getIncline(i, j, arr[i], arr[j]);
				if (incline < min) {
					min = incline;
					count++;
				}
			}
			
			double max = -1_000_000_001;
			//오른쪽
			for (int j = i+1; j < n; j++) {
				double incline = getIncline(i, j, arr[i], arr[j]);
				if (incline > max) {
					max = incline;
					count++;
				}
			}
			answer = Math.max(answer, count);
		}
		System.out.println(answer);
	}
	
	private static double getIncline(int x, int y, int hegihtX, int heightY) {
		return (double)(hegihtX - heightY) / (x - y);
	}
}
