package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex10384 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			sb.append("Case " + (t+1) + ": ");
			char[] input = br.readLine().replaceAll("[^a-zA-Z]", "").toCharArray();
			
			int[] arr = new int[26];
			for (int i = 0; i < input.length; i++) {
				if (Character.isUpperCase(input[i])) {
					char text = Character.toLowerCase(input[i]);
					arr[text - 'a']++;
				} else {
					arr[input[i] - 'a']++;
				}
			}
			
			boolean one = true;
			boolean two = true;
			boolean three = true;
			
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] < 3) three = false;
				if (arr[i] < 2) two = false;
				if (arr[i] < 1) one = false;
			}
			
			if (three) {
				sb.append("Triple pangram!!!");
			} else if (two) {
				sb.append("Double pangram!!");
			} else if (one) {
				sb.append("Pangram!");
			} else {
				sb.append("Not a pangram");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
