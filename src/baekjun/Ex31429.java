package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Ex31429 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<Integer, int[]> rank = new HashMap<>();
		
		rank.put(1, new int[] {12, 1600});
		rank.put(2, new int[] {11, 894});
		rank.put(3, new int[] {11, 1327});
		rank.put(4, new int[] {10, 1311});
		rank.put(5, new int[] {9, 1004});
		rank.put(6, new int[] {9, 1178});
		rank.put(7, new int[] {9, 1357});
		rank.put(8, new int[] {8, 837});
		rank.put(9, new int[] {7, 1055});
		rank.put(10, new int[] {6, 556});
		rank.put(11, new int[] {6, 773});
		
		int n = Integer.parseInt(br.readLine());
		int[] answer = rank.get(n);
		
		System.out.println(answer[0] + " " + answer[1]);
	}

}
