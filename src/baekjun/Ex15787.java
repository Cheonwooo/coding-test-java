package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Ex15787 {
	
	private static ArrayList<Integer>[] subway;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		subway = new ArrayList[n+1];
		for (int i = 0; i < n + 1; i++) {
			subway[i] = new ArrayList<>();
			for (int j = 0; j < 20; j++) {
				subway[i].add(0);
			}
		}
		
		for (int i = 0; i < m; i++) {
			String[] cmd = br.readLine().split(" ");
			
			query(cmd);
		}
		
		Set<String> typeOfTrain = new HashSet<>();
		int answer = 0;
		for (int i = 1; i < n+1; i++) {
			String type = "";
			if (subway[i].size() < 20) {
				for (int j = 0; j < subway[i].size(); j++) {
					type += String.valueOf(subway[i].get(j));
				}
				
				for (int j = 0; j < 20 - type.length(); j++) {
					type += String.valueOf("0");
				}
			} else {
				for (int j = 0; j < 20; j++) {
					type += String.valueOf(subway[i].get(j));
				}
			}
			if (!typeOfTrain.contains(type)) {
				typeOfTrain.add(type);
				answer++;
			}
		}
		System.out.println(answer);
	}
	
	
	private static void query(String[] cmd) {
		int option = Integer.parseInt(cmd[0]);
		int subwaySeq = Integer.parseInt(cmd[1]);
		
		if (option == 1) {
			int seatSeq = Integer.parseInt(cmd[2]) - 1;
			
			if (subway[subwaySeq].get(seatSeq) == 0) {
				subway[subwaySeq].set(seatSeq, 1);
			}
		} else if (option == 2) {
			int seatSeq = Integer.parseInt(cmd[2]) - 1;
			
			if (subway[subwaySeq].get(seatSeq) == 1) {
				subway[subwaySeq].set(seatSeq, 0);
			}
		} else if (option == 3) {
			subway[subwaySeq].add(0, 0);
			subway[subwaySeq].remove(20);
		} else {
			subway[subwaySeq].remove(0);
			subway[subwaySeq].add(0);
		}
	}
}
