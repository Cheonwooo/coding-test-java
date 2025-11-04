package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex10419 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int time = Integer.parseInt(br.readLine());
			
			int max = 0;
			for (int j = 1; j < 101;j ++) {
				if ((j + Math.pow(j, 2)) <= time) {
					max = j;
				} else {
					break;
				}
			}
			sb.append(max + "\n");
		}
		System.out.println(sb);
		
	}

}
