package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex5073 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			int[] line = new int[3];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			line[0] = Integer.parseInt(st.nextToken());
			line[1] = Integer.parseInt(st.nextToken());
			line[2] = Integer.parseInt(st.nextToken());
			
			if (line[0] == 0 && line[1] == 0 && line[2] == 0) break;
			
			int max = 0;
			int maxIdx = 0;
			for (int i = 0; i < 3; i++) {
				if (max < line[i]) {
					max = line[i];
					maxIdx = i;
				}
			}
			
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				if (i == maxIdx) continue;
				sum += line[i];
			}
			
			if (max >= sum) {
				System.out.println("Invalid");
				continue;
			}
			
			if (line[0] == line[1] && line[1] == line[2] && line[2] == line[0]) {
				System.out.println("Equilateral");
			} else if (line[0] == line[1] || line[1] == line[2] || line[2] == line[0]) {
				System.out.println("Isosceles");
			} else if (line[0] != line[1] && line[1] != line[2] && line[2] != line[0]) {
				System.out.println("Scalene");
			}
		}
	}

}
