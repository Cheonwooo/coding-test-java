package programmers;

public class Ex43163 {
	private static int answer;
	private static boolean[] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int solution(String begin, String target, String[] words) {
        
        boolean check = false;
        visited = new boolean[words.length];
		
		for (int i = 0; i < words.length; i++) {
			if (target.equals(words[i])) {
				check = true;
			}
		}
		
		if (!check) {
			answer = 0;
		} else {
			dfs(0, target, begin, words);
		}
        return answer;
    }
	
	public void dfs(int count, String target, String word, String[] words) {
		if (word.equals(target)) {
			answer = Math.min(answer, count);
			return;
		}
		
		for (int i = 0; i < words.length; i++) {
			if(visited[i]) continue;
			
			int num = calculateSameCharCount(word, words[i]);
			
			if (num == 1) {
				visited[i] = true;
				dfs(count+1, target, words[i], words);
				visited[i] = false;
			}
		}
	}
	
	public int calculateSameCharCount(String word1, String word2) {
		int count = 0;
		for (int i = 0; i < word1.length(); i++) {
			if (word1.charAt(i) != word2.charAt(i)) count++;
		}
		return count;
	}

}
