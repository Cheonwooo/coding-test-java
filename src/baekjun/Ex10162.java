package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex10162 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		int[] time = new int[3];
		if ((t % 10) != 0) {
			System.out.println(-1);
		} else {
			if ((t / 300) != 0) {
				time[0] += t/300;
				t %= 300;
			}
			if ((t / 60) != 0) {
				time[1] += t/60;
				t %= 60;
			}
			if ((t / 10) != 0) {
				time[2] += t/10;
				t %= 10;
			}
			System.out.println(time[0] + " " + time[1] + " " + time[2]);
		}
	}

}
