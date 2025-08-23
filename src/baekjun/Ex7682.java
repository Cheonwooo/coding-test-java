package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex7682 {
	
	private static String[][] map = new String[3][3];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			String tik = br.readLine();
			
			if (tik.equals("end")) break;
			
			int xCount = 0;
			int oCount = 0;
			int index = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					map[i][j] = String.valueOf(tik.charAt(index++));
					if (map[i][j].equals("X")) {
						xCount++;
					} else if (map[i][j].equals("O")){
						oCount++;
					}
				}
			}
			
			if (xCount == oCount + 1) {//x가 이기는 경우
				if (xCount + oCount == 9 && !tiktakto("O")) {
					sb.append("valid\n");
				} else if (tiktakto("X") && !tiktakto("O")) {
					sb.append("valid\n");
				} else {
					sb.append("invalid\n");
				}
			} else if (xCount == oCount) {//o가 이기는 경우
				if (!tiktakto("X") && tiktakto("O")) {
					sb.append("valid\n");
				} else {
					sb.append("invalid\n");
				}
			} else {
				sb.append("invalid\n");
			}
		}
		System.out.println(sb);
	}
	
	private static boolean tiktakto(String horse) {
		//행
		for (int i = 0; i < 3; i++) {
			if (map[i][0].equals(horse) && map[i][1].equals(horse) && map[i][2].equals(horse)) {
				return true;
			}
		}
		
		//열
		for (int i = 0; i < 3; i++) {
			if (map[0][i].equals(horse) && map[1][i].equals(horse) && map[2][i].equals(horse)) {
				return true;
			}
		}
		
		//대각선
		if (map[0][0].equals(horse) && map[1][1].equals(horse) && map[2][2].equals(horse)) {
			return true;
		}
		
		if (map[0][2].equals(horse) && map[1][1].equals(horse) && map[2][0].equals(horse)) {
			return true;
		}
		return false;
	}
}
