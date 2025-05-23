package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2920 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int first = Integer.parseInt(st.nextToken());
		int second = Integer.parseInt(st.nextToken());
		boolean sign = false;//오름차순: false, 내림차순: true
		boolean over = false;
		
		if ((first - second) > 0) sign = true;//내림차순인 경우
		for (int i = 2; i < 8; i++) {
			int next = Integer.parseInt(st.nextToken());
			if (((second - next) > 0) != sign) {
				System.out.println("mixed");
				over = true;
				break;
			}
			second = next;
		}
		
		if (!over) {
			if (sign) System.out.println("descending");
			else System.out.println("ascending");
		}
	}

}
