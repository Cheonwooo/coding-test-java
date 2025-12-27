package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1100 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int answer = 0;
		for (int i = 0; i < 8; i++) {
			char[] chess = br.readLine().toCharArray();
			for (int j = 0; j < 8; j++) {
				if ((i % 2) == 0) {
					if ((j % 2) == 0) {
						if (chess[j] == 'F') {
							answer++;
						}
					}
				} else {
					if ((j % 2) != 0) {
						if (chess[j] == 'F') {
							answer++;
						}
					}
				}
			}
		}
		System.out.println(answer);
	}

}
