package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Ex22233 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Map<String, Integer> docs = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			String word = br.readLine();
			docs.put(word, docs.getOrDefault(word, 0) + 1);
		}
		
		for (int i = 0; i < m; i++) {
			String[] words = br.readLine().split(",");
			for (int j = 0; j < words.length; j++) {
				if (docs.get(words[j]) != null) {
					docs.remove(words[j]);
				}
			}
			System.out.println(docs.size());
		}
	}

}
