package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex23971 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken())+1;
		int m = Integer.parseInt(st.nextToken())+1;
		
		int row = h / n;
		int col = w / m;
		
		if (h % n != 0) row++;
		if (w % m != 0) col++;
		System.out.println(row * col);
		
	}

}
//5 1 -> 3 , 4 1 -> 2
