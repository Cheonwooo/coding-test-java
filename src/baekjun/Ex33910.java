package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex33910 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		long answer = 0;
		int index = n-1;
		long min = arr[index];
		for (int i = index; i >= 0; i--) {
			if (arr[i] < min) {
				answer += (min * (index - i));
				min = arr[i];
				index = i;
			}
		}
		if (index == 0) {//마지막 값 더해줘야함
			answer += min;
		} else {
			answer += (min * (index + 1));
		}
		System.out.println(answer);
	}

}
