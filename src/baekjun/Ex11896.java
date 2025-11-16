package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex11896 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		a = ((a + 1) / 2) * 2;
		b = (b / 2) * 2;
		
		if (b < a) {
			System.out.println(0);
			return;
		}
		
		if (a <= 2) {
			a = 4;
		}
		
		long sum = 0;
		sum = (b - a) / 2 + 1;
		sum *= (a + b) / 2;
		System.out.println(sum);
	}

}
