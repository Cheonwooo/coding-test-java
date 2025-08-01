package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex20920 {
	
	private static class Word implements Comparable<Word> {
		int count;
		int len;
		String word;

		public Word(int count, int len, String word) {
			this.count = count;
			this.len = len;
			this.word = word;
		}
		
		public int compareTo(Word o) {
			if (this.count == o.count && this.len == o.len) {
				return this.word.compareTo(o.word);
			} else if (this.count == o.count) {
				return o.len - this.len;
			}
			return o.count - this.count;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int len = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> docs = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String word = br.readLine();
			
			if (word.length() < len) continue;
			
			docs.put(word, docs.getOrDefault(word, 0) + 1);
		}
		
		PriorityQueue<Word> pq = new PriorityQueue<>();
		for (String word : docs.keySet()) {
			pq.offer(new Word(docs.get(word), word.length(), word));
		}
		
		while (!pq.isEmpty()) {
			sb.append(pq.poll().word + "\n");
		}
		System.out.println(sb);
	}

}
