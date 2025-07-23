package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Ex15723 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Character, Character> map = new HashMap<>();
		for (int i = 0; i < 26; i++) {
			map.put((char)(i + 'a'), ' ');
		}
		
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			char pre = st.nextToken().charAt(0);
			st.nextToken();
			char next = st.nextToken().charAt(0);
			
			map.put(pre, next);
		}
		
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			char pre = st.nextToken().charAt(0);
			st.nextToken();
			char next = st.nextToken().charAt(0);
			
			boolean check = false;
			while (true) {
				char key = map.get(pre);
				
				if (key == next) {
					check = true;
					break;
				}
				if (key == ' ') break;
				pre = key;
			}
			if (check) {
				System.out.println("T");
			} else {
				System.out.println("F");
			}
		}
	}

}
/*
* a - b
* b - c
* c - d
* 
* a - b - c - d
* a - b - c
* 
*/