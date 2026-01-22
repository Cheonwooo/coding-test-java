package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex14382 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			sb.append("Case #" + (t+1) + ": ");
			
			Long n = Long.parseLong(br.readLine());
			
			int count = 0;
			boolean[] check = new boolean[10];
			for (long i = 1; i < 1_000_000; i++) {
				long mul = n * i;
				
				String number = String.valueOf(mul);
				for (int j = 0; j < number.length(); j++) {
					if (!check[number.charAt(j)- '0']) {
						check[number.charAt(j)- '0'] = true;
						count++;
					}
				}
				if (count == 10) {
					sb.append(mul + "\n");
					break;
				}
			}
			if (count != 10) {
				sb.append("INSOMNIA" + "\n");
			}
		}
		System.out.println(sb);
	}

}
