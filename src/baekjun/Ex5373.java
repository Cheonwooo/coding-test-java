package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex5373 {
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[][] dice = new String[12][9];
		makeDice(dice);
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String[][] copyDice = new String[12][9];
			copy(dice, copyDice);
			
			int turnCount = Integer.parseInt(br.readLine());
			String[] commands = new String[turnCount];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < turnCount; j++) {
				commands[j] = st.nextToken();
			}
			
			inputCommand(copyDice, commands);
			printTop(copyDice);
		}
		System.out.println(sb);
	}
	public static void makeDice(String[][] dice) {
		String color = "";
		for (int i = 0; i < 4; i++) {
			if (i == 0) color = "o";
			else if (i == 1) color = "w";
			else if (i == 2) color = "r";
			else color = "y";
			
			for (int j = 3; j < 6; j++) {				
				for (int k = 0; k < 3; k++) {
					dice[3*i + k][j] = color;
				}
			}
		}
		
		for (int i = 3; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				dice[i][j] = "g";
			}
			
			for (int j = 6; j < 9; j++) {
				dice[i][j] = "b";
			}
		}
	}

	public static void copy(String[][] dice, String[][] copyDice) {
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 9; j++) {
				copyDice[i][j] = dice[i][j];
			}
		}
	}
	
	public static void inputCommand(String[][] copyDice, String[] commands) {
		for (int i = 0; i < commands.length; i++) {
			String[] command = commands[i].split("");
			String pos = command[0];
			String dir = command[1];
			
			turnFace(copyDice, pos, dir);
			turnDice(copyDice, pos, dir);
		}
	}
	
	public static void turnFace(String[][] dice, String pos, String dir) {
		for (int i = 0; i < 2; i++) {
			if (pos.equals("L") && dir.equals("+")) {
				String temp = dice[3][0];
				dice[3][0] = dice[4][0];
				dice[4][0] = dice[5][0];
				dice[5][0] = dice[5][1];
				dice[5][1] = dice[5][2];
				dice[5][2] = dice[4][2];
				dice[4][2] = dice[3][2];
				dice[3][2] = dice[3][1];
				dice[3][1] = temp;
			} else if (pos.equals("L") && dir.equals("-")) {
				String temp = dice[3][0];
				dice[3][0] = dice[3][1];
				dice[3][1] = dice[3][2];
				dice[3][2] = dice[4][2];
				dice[4][2] = dice[5][2];
				dice[5][2] = dice[5][1];
				dice[5][1] = dice[5][0];
				dice[5][0] = dice[4][0];
				dice[4][0] = temp;
			} else if (pos.equals("R") && dir.equals("+")) {
				String temp = dice[3][6];
				dice[3][6] = dice[4][6];
				dice[4][6] = dice[5][6];
				dice[5][6] = dice[5][7];
				dice[5][7] = dice[5][8];
				dice[5][8] = dice[4][8];
				dice[4][8] = dice[3][8];
				dice[3][8] = dice[3][7];
				dice[3][7] = temp;
			} else if (pos.equals("R") && dir.equals("-")) {
				String temp = dice[3][6];
				dice[3][6] = dice[3][7];
				dice[3][7] = dice[3][8];
				dice[3][8] = dice[4][8];
				dice[4][8] = dice[5][8];
				dice[5][8] = dice[5][7];
				dice[5][7] = dice[5][6];
				dice[5][6] = dice[4][6];
				dice[4][6] = temp;
			} else if (pos.equals("U") && dir.equals("+")) {
				String temp = dice[3][3];
				dice[3][3] = dice[4][3];
				dice[4][3] = dice[5][3];
				dice[5][3] = dice[5][4];
				dice[5][4] = dice[5][5];
				dice[5][5] = dice[4][5];
				dice[4][5] = dice[3][5];
				dice[3][5] = dice[3][4];
				dice[3][4] = temp;
			} else if (pos.equals("U") && dir.equals("-")) {
				String temp = dice[3][3];
				dice[3][3] = dice[3][4];
				dice[3][4] = dice[3][5];
				dice[3][5] = dice[4][5];
				dice[4][5] = dice[5][5];
				dice[5][5] = dice[5][4];
				dice[5][4] = dice[5][3];
				dice[5][3] = dice[4][3];
				dice[4][3] = temp;
			} else if (pos.equals("D") && dir.equals("+")) {
				String temp = dice[9][3];
				dice[9][3] = dice[10][3];
				dice[10][3] = dice[11][3];
				dice[11][3] = dice[11][4];
				dice[11][4] = dice[11][5];
				dice[11][5] = dice[10][5];
				dice[10][5] = dice[9][5];
				dice[9][5] = dice[9][4];
				dice[9][4] = temp;
			} else if (pos.equals("D") && dir.equals("-")) {
				String temp = dice[9][3];
				dice[9][3] = dice[9][4];
				dice[9][4] = dice[9][5];
				dice[9][5] = dice[10][5];
				dice[10][5] = dice[11][5];
				dice[11][5] = dice[11][4];
				dice[11][4] = dice[11][3];
				dice[11][3] = dice[10][3];
				dice[10][3] = temp;
			} else if (pos.equals("F") && dir.equals("+")) {
				String temp = dice[6][3];
				dice[6][3] = dice[7][3];
				dice[7][3] = dice[8][3];
				dice[8][3] = dice[8][4];
				dice[8][4] = dice[8][5];
				dice[8][5] = dice[7][5];
				dice[7][5] = dice[6][5];
				dice[6][5] = dice[6][4];
				dice[6][4] = temp;
			} else if (pos.equals("F") && dir.equals("-")) {
				String temp = dice[6][3];
				dice[6][3] = dice[6][4];
				dice[6][4] = dice[6][5];
				dice[6][5] = dice[7][5];
				dice[7][5] = dice[8][5];
				dice[8][5] = dice[8][4];
				dice[8][4] = dice[8][3];
				dice[8][3] = dice[7][3];
				dice[7][3] = temp;
			} else if (pos.equals("B") && dir.equals("+")) {
				String temp = dice[0][3];
				dice[0][3] = dice[1][3];
				dice[1][3] = dice[2][3];
				dice[2][3] = dice[2][4];
				dice[2][4] = dice[2][5];
				dice[2][5] = dice[1][5];
				dice[1][5] = dice[0][5];
				dice[0][5] = dice[0][4];
				dice[0][4] = temp;
			} else if (pos.equals("B") && dir.equals("-")) {
				String temp = dice[0][3];
				dice[0][3] = dice[0][4];
				dice[0][4] = dice[0][5];
				dice[0][5] = dice[1][5];
				dice[1][5] = dice[2][5];
				dice[2][5] = dice[2][4];
				dice[2][4] = dice[2][3];
				dice[2][3] = dice[1][3];
				dice[1][3] = temp;
			}
		}
	}

	public static void turnDice(String[][] dice, String pos, String dir) {
		if (pos.equals("L") && dir.equals("+")) {
			for (int i = 0; i < 3; i++) {
				String temp = dice[11][3];
				for (int j = 11; j > 0; j--) {
					dice[j][3] = dice[j-1][3];
				}
				dice[0][3] = temp;
			}
		} else if (pos.equals("L") && dir.equals("-")) {
			for (int i = 0; i < 3; i++) {
				String temp = dice[0][3];
				for (int j = 0; j < 11; j++) {
					dice[j][3] = dice[j+1][3];
				}
				dice[11][3] = temp;
			}
		} else if (pos.equals("R") && dir.equals("+")) {
			for (int i = 0; i < 3; i++) {
				String temp = dice[0][5];
				for (int j = 0; j < 11; j++) {
					dice[j][5] = dice[j+1][5];
				}
				dice[11][5] = temp;
			}
		} else if (pos.equals("R") && dir.equals("-")) {
			for (int i = 0; i < 3; i++) {
				String temp = dice[11][5];
				for (int j = 11; j > 0; j--) {
					dice[j][5] = dice[j-1][5];
				}
				dice[0][5] = temp;
			}
		} else if (pos.equals("U") && dir.equals("+")) {
			for (int i = 0; i < 3; i++) {
				String temp = dice[5-i][2];
				dice[5-i][2] = dice[6][5-i];
				dice[6][5-i] = dice[3+i][6];
				dice[3+i][6] = dice[2][3+i];
				dice[2][3+i] = temp;
			}
		} else if (pos.equals("U") && dir.equals("-")) {
			for (int i = 0; i < 3; i++) {
				String temp = dice[5-i][2];
				dice[5-i][2] = dice[2][3+i];
				dice[2][3+i] = dice[3+i][6];
				dice[3+i][6] = dice[6][5-i];
				dice[6][5-i] = temp;
			}
		} else if (pos.equals("D") && dir.equals("+")) {
			for (int i = 0; i < 3; i++) {
				String temp = dice[3+i][0];
				dice[3+i][0] = dice[0][5-i];
				dice[0][5-i] = dice[5-i][8];
				dice[5-i][8] = dice[8][3+i];
				dice[8][3+i] = temp;
			}
		} else if (pos.equals("D") && dir.equals("-")) {
			for (int i = 0; i < 3; i++) {
				String temp = dice[3+i][0];
				dice[3+i][0] = dice[8][3+i];
				dice[8][3+i] = dice[5-i][8];
				dice[5-i][8] = dice[0][5-i];
				dice[0][5-i] = temp;
			}
		} else if (pos.equals("F") && dir.equals("+")) {
			for (int i = 0; i < 3; i++) {
				String temp = dice[5][8];
				for (int j = 8; j > 0; j--) {
					dice[5][j] = dice[5][j-1];
				}
				dice[5][0] = dice[9][3];
				dice[9][3] = dice[9][4];
				dice[9][4] = dice[9][5];
				dice[9][5] = temp;
			}
		} else if (pos.equals("F") && dir.equals("-")) {
			for (int i = 0; i < 3; i++) {
				String temp = dice[5][0];
				for (int j = 0; j < 8; j++) {
					dice[5][j] = dice[5][j+1];
				}
				dice[5][8] = dice[9][5];
				dice[9][5] = dice[9][4];
				dice[9][4] = dice[9][3];
				dice[9][3] = temp;
			}
		} else if (pos.equals("B") && dir.equals("+")) {
			for (int i = 0; i < 3; i++) {
				String temp = dice[3][0];
				for (int j = 0; j < 8; j++) {
					dice[3][j] = dice[3][j+1];
				}
				dice[3][8] = dice[11][5];
				dice[11][5] = dice[11][4];
				dice[11][4] = dice[11][3];
				dice[11][3] = temp;
			}
		} else if (pos.equals("B") && dir.equals("-")) {
			for (int i = 0; i < 3; i++) {
				String temp = dice[3][8];
				for (int j = 8; j > 0; j--) {
					dice[3][j] = dice[3][j-1];
				}
				dice[3][0] = dice[11][3];
				dice[11][3] = dice[11][4];
				dice[11][4] = dice[11][5];
				dice[11][5] = temp;
			}
		}
//		System.out.println(pos + " " + dir);
//		for (int j = 0 ; j < 12; j++) {
//			for (int k = 0; k < 9; k++) {
//				if (dice[j][k] == null) {
//					System.out.print("x");
//				} else {
//					System.out.print(dice[j][k]);
//				}
//			}
//			System.out.println();
//		}
//		System.out.println();
	}
	
	public static void printTop(String[][] dice) {
		for (int i = 3; i < 6; i++) {
			for (int j = 3; j < 6; j++) {
				sb.append(dice[i][j]);
			}
			sb.append("\n");
		}
	}
}
