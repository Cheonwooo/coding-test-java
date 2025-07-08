package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex18125 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] rotate = new int[m][n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				rotate[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] temp = new int[m][n];
		for (int i = 0; i < m; i++) { 
			for (int j = 0 ; j < n; j++) {
				temp[i][j] = arr[n-1-j][i];
			}
		}
		
		for (int i = 0; i < m; i++) { 
			for (int j = 0 ; j < n; j++) {
				if (rotate[i][j] != temp[i][j]) {
					System.out.println("|>___/|     /}\n" +
			                "| O O |    / }\n" +
			                "( =0= )\"\"\"\"  \\\n" +
			                "| ^  ____    |\n" +
			                "|_|_/    ||__|");
					return;
				}
			}
		}
		System.out.println( "|>___/|        /}\n" +
                "| O < |       / }\n" +
                "(==0==)------/ }\n" +
                "| ^  _____    |\n" +
                "|_|_/     ||__|");
	}
}
