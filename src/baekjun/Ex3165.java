package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//메모리 14,748kb 시간 120ms

public class Ex3165 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		n += 1;
		String[] number = String.valueOf(n).split("");
		int curIndex = number.length - 1;
		int maxIndex = number.length - 1;
		
		while (true) {
			int count = 0;
			for (int i = 0; i < number.length; i++) {
				if (number[i].equals("5")) count++;
			}
			
			if (count >= k) break;
			
			while (number[curIndex].equals("5") && curIndex > 0) {
				curIndex -= 1;
			}
				n = Long.parseLong(String.join("", number));
				
				if (curIndex < 0) { // n : 555, k : 4인 경우
					n += (int)Math.pow(10, maxIndex+1) * 5;
				} else {
					n += (long)Math.pow(10, maxIndex - curIndex);
					number = String.valueOf(n).split("");
					curIndex = number.length-1;
					maxIndex = number.length-1;
				}
		}
		
		System.out.println(String.join("", number));
	}

}
