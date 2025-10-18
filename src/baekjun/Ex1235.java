package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Ex1235 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] numbers = new String[n];
		
		for (int i = 0; i < n; i++) {
			numbers[i] = br.readLine();
		}
		
		while (true) {
			Set<String> set = new HashSet<>();
			for (int i = numbers[0].length()-1; i >= 0; i--) {
				boolean isDuplicate = false;
				for (int j = 0; j < n; j++) {
					if (set.contains(numbers[j].substring(i))) {
						isDuplicate = true;
						break;
					}
					set.add(numbers[j].substring(i));
				}
				if (!isDuplicate) {
					System.out.println(numbers[0].length() - i);
					return;
				}
			}
		}
	}

}
