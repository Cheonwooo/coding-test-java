package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex16488 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long n = Integer.parseInt(st.nextToken());
		long k = Integer.parseInt(st.nextToken());
		
		long answer = k * n * n;
		System.out.println(answer);
	}

}
