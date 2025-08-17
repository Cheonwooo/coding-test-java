package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Ex1283 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] options = new String[n];
		Map<Character, Boolean> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			options[i] = br.readLine();
			
			String[] words = options[i].split(" ");
			boolean check = false;
			for (int j = 0; j < words.length; j++) {
				if (map.get(Character.toLowerCase(words[j].charAt(0))) == null) {//아직 등록되지 않은 것
					map.put(Character.toLowerCase(words[j].charAt(0)), true);
					
					String[] word = words[j].split("");
					word[0] = "[" + word[0] + "]";
					words[j] = String.join("", word);
					options[i] = String.join(" ", words);
					check = true;
					break;
				}
			}
			
			if (!check) {
				for (int j = 0; j < words.length; j++) {
					for (int k = 0; k < words[j].length(); k++) {
						if (map.get(Character.toLowerCase(words[j].charAt(k))) == null) {//아직 등록되지 않은 것
							map.put(Character.toLowerCase(words[j].charAt(k)), true);
							
							String[] word = words[j].split("");
							word[k] = "[" + word[k] + "]";
							words[j] = String.join("", word);
							options[i] = String.join(" ", words);
							check = true;
							break;
						}
					}
					if (check) break;
				}
			}
		}
		
		for (String word : options) {
			System.out.println(word);
		}
	}

}
