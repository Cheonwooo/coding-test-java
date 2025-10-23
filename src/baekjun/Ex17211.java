package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex17211 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		double[] pro = new double[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			pro[i] = Double.parseDouble(st.nextToken());
		}
		
		double good = 0.0;
		double bad = 0.0;
		
		if (k == 0) {
			good = 1.0;
		} else {
			bad = 1.0;
		}

		for (int i = 0; i < n; i++) {
			double preGood = good;
			good = good * pro[0] + bad * pro[2];
			bad = preGood * pro[1] + bad * pro[3]; 
		}
		
		System.out.println((int)(good * 1000) );
		System.out.println((int)(bad * 1000) );
		
	}

}
