package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex9229 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String next = br.readLine();
		boolean check = true;
		while (true) {
			String pre = next;
			next = br.readLine();
			if (next.equals("#")) {//한 타임이 끝났다면
				if (pre.equals("#")) break;//두번 연속 나오면 끝
				else {
					if (check) sb.append("Correct\n");
					else sb.append("Incorrect\n");
					check = true;
					continue;
				}
			}
			
			if (pre.equals("#")) continue;
			
			if (check) {
				if (pre.length() != next.length()) {
					check = false;
					continue;
				}
				
				int count = 0;
				for (int i = 0; i < pre.length(); i++) {
					if (pre.charAt(i) != next.charAt(i)) count++;
				}
				
				if (count != 1) {
					check = false;
				}
			}
		}
		System.out.println(sb);
	}

}
