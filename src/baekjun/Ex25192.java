package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Ex25192 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int answer = 0;
		Set<String> users = new HashSet<>();
		for (int i = 0; i < n; i++) {
			String next = br.readLine();
			
			if (next.equals("ENTER")) {
				users.clear();
				continue;
			}
			
			if (users.contains(next)) continue;
			users.add(next);
			answer++;
		}
		
		System.out.println(answer);
	}

}
