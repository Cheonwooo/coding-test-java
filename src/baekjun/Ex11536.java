package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex11536 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] names = new String[n];
		String[] temp = new String[n];
		for (int i = 0; i < n; i++) {
			names[i] = br.readLine();
			temp[i] = names[i];
		}
		
		Arrays.sort(temp);
		boolean isIncreased = true;
		for (int i = 0; i < n; i++) {
			if (!names[i].equals(temp[i])) {
				isIncreased = false;
				break;
			}
		}
		
		boolean isDecreased = true;
		for (int i = 0; i < n; i++) {
			if (!names[i].equals(temp[n-1-i])) {
				isDecreased = false;
				break;
			}
		}
		
		if (isIncreased && !isDecreased) {
			System.out.println("INCREASING");
		} else if (!isIncreased && isDecreased) {
			System.out.println("DECREASING");
		} else {
			System.out.println("NEITHER");
		}
	}

}
