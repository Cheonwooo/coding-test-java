package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex84512 {
	private static String[] arr, words = {"A", "E", "I", "O", "U"};
	private static List<String> dictionary = new ArrayList<>();

	public static void main(String[] args) {
		String word = "EIO";
		System.out.println(solution(word));
	}
	
	public static int solution(String word) {
        
        for (int i = 1; i <= 5; i++) {
        	arr = new String[i];
        	comb(i, 0);
        }
        
        Collections.sort(dictionary);

        int index = dictionary.indexOf(word)+1;
        return index;
    }
	
	public static void comb(int r, int depth) {
		if (depth == r) {
			String word = "";
			for (String val : arr) {
				word += val;
			}
			dictionary.add(word);
			return;
		}
		
		for (int i = 0; i < words.length; i++) {
			arr[depth] = words[i];
			comb(r, depth+1);
		}
	}
}
