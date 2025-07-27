package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2816 {
	
	private static final String KBS1 = "KBS1";
	private static final String KBS2 = "KBS2";

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		String[] channels = new String[n];
		int cursor = 0;
		int kbs1= 0;
		int kbs2 = 1;
		
		for (int i = 0; i < n; i++) {
			channels[i] = br.readLine();
			if (channels[i].equals(KBS1)) {
				kbs1 = i;
			} else if (channels[i].equals(KBS2)) {
				kbs2 = i;
			}
		}
		
		while (!channels[cursor].equals(KBS1)) {
			sb.append(1);
			cursor += 1;
		}
		
		int count = cursor;
		for (int i = 0; i < count; i++) {
			sb.append(4);
			String temp = channels[cursor];
			channels[cursor] = channels[cursor - 1];
			channels[cursor - 1] = temp;
			cursor--;
		}
		
		while (!channels[cursor].equals(KBS2)) {
			sb.append(1);
			cursor += 1;
		}
		
		count = cursor;
		for (int i = 1; i < count; i++) {
			sb.append(4);
			String temp = channels[cursor];
			channels[cursor] = channels[cursor - 1];
			channels[cursor - 1] = temp;
			cursor--;
		}
		
		System.out.println(sb);
	}
}

/*
0
0
0
0
2
0
0
1

*/