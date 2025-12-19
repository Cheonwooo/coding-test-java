package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex16917 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int sumA = a * x + b * y;
		int max = Math.max(x, y);
		int sumC = 2 * c * max;
		int min = Math.min(x, y);
		x -= min;
		y -= min;
		int sumB = 2 * c * min + a * x + b * y;
		
		System.out.println(Math.min(sumC, Math.min(sumA, sumB)));
	}

}
