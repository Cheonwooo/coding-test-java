package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Ex25757 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		String option = st.nextToken();
		
		int count = 0;
		if (option.equals("Y")) {
			count = 2;
		} else if (option.equals("F")) {
			count = 3;
		} else {
			count = 4;
		}
		
		Set<String> names = new HashSet<>();
		for (int i = 0; i < n; i++) {
			names.add(br.readLine());
		}
		
		System.out.println(names.size()/(count-1));
	}

}
