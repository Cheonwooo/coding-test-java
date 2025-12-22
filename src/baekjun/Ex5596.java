package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex5596 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sumS = 0;
		for (int i = 0; i < 4; i++) {
			sumS += Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		int sumT = 0;
		for (int i = 0; i < 4; i++) {
			sumT += Integer.parseInt(st.nextToken());
		}
		
		System.out.println(Math.max(sumS, sumT));
	}

}
