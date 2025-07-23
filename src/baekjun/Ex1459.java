package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1459 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		long answer = 0L;
		if (w >= s) {
			if ((x+y) % 2 == 0) {
				answer += (long)Math.max(x, y)*s;
			} else {
				answer += (long)(Math.max(x, y) - 1) * s;
				answer += w;
			}
		} else if (w < s && (2 * w) > s) { 
			while (x != 0 && y != 0) {
				answer += s;
				x--;
				y--;
			}
			answer += (long)(x + y) * w;
		} else {
			//크로스로 가는게 직선 2개 길이보다 크다면 그냥 다 직선으로 이동
			answer += (long)(x + y) * w;
		}
		System.out.println(answer);
	}

}
