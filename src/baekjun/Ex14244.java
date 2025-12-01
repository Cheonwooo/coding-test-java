package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex14244 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int count = 0;
		if (m == 2) {
			count = 1;
		}
		
		int leaf = 0;
		
		for (int i = 1; i < n; i++) {
			if (m > count) {
				System.out.println(0 + " " + i);
				count++;
			} else {
				System.out.println(leaf + " " + i);
			}
			leaf = i;
		}
	}

}
