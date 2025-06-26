package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex14647 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		String[][] arr = new String[n][m];
		int nineCount = 0;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				String number = st.nextToken();
				for (int k = 0; k < number.length(); k++) {
					if (number.charAt(k) == '9') nineCount++;
				}
				arr[i][j] = number;
			}
		}
		
		int row = 0;
		int rowMax = 0;
		//행 체크
		for (int i = 0; i < n; i++) {
			int count = 0;
			for (int j = 0 ; j < m; j++) {
				for (int k = 0; k < arr[i][j].length(); k++) {
					if (arr[i][j].charAt(k) == '9') count++; 
				}
			}
			if (rowMax < count) {//9의 개수가 더 많다면 
				rowMax = count;
				row = i;
			}
		}
		
		int col = 0;
		int colMax = 0;
		//행 체크
		for (int i = 0; i < m; i++) {
			int count = 0;
			for (int j = 0 ; j < n; j++) {
				for (int k = 0; k < arr[j][i].length(); k++) {
					if (arr[j][i].charAt(k) == '9') count++; 
				}
			}
			if (colMax < count) {//9의 개수가 더 많다면 
				colMax = count;
				col = i;
			}
		}
		
		if (rowMax > colMax) {
			System.out.println(nineCount - rowMax);
		} else {
			System.out.println(nineCount - colMax);
			
		}
		
	}

}
