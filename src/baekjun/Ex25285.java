package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex25285 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			double height = Double.parseDouble(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			double bmi = (double)weight / Math.pow(height/100, 2);
			
			int grade = determineGrade(height, bmi);
			System.out.println(grade);
		}
	}

	private static int determineGrade(double height, double bmi) {
		if (height >= 204) {
			return 4;
		} else if (height >= 161 && height < 204) {
			if (bmi >= 20.0 && bmi < 25.0) return 1;
			else if (bmi >= 18.5 && bmi < 20.0) return 2;
			else if (bmi >= 25.0 && bmi < 30.0) return 2;
			else if (bmi >= 16.0 && bmi < 18.5) return 3;
			else if (bmi >= 30.0 && bmi < 35.0) return 3;
			else return 4;
		} else if (height >= 159 && height < 161) {
			if (bmi >= 16.0 && bmi < 35.0) return 3;
			else return 4;
		} else if (height >= 146 && height < 159) {
			return 4;
		} else if (height >= 140.1 && height < 146) {
			return 5;
		} else {
			return 6;
		}
	}
}
