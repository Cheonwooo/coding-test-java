package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Ex34033 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> regularPrice = new HashMap<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			String article = st.nextToken();
			int price = Integer.parseInt(st.nextToken());
			
			regularPrice.put(article, price);
		}
		
		int answer = 0;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			String article = st.nextToken();
			int price = Integer.parseInt(st.nextToken());
			
			int rP = regularPrice.get(article);
			
			double totalPrice = rP * 1.05;
			
			if (price > totalPrice) answer++;
		}
		
		System.out.println(answer);
	}

}
