package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Ex16499 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Set<String> answer = new HashSet<>();
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split("");
			Arrays.sort(input);
			String word = String.join("", input);
			answer.add(word);
		}
		System.out.println(answer.size());
	}

}
