package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex43164 {
	private static boolean[] visited;
	private static String[] arr;
	private static List<String[]> list = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String[] solution(String[][] tickets) {
        
        for (int i = 0; i < tickets.length; i++) {
			if (tickets[i][0].equals("ICN")) {
        		arr = new String[tickets.length+1];
                visited = new boolean[tickets.length];
                
                arr[0] = tickets[i][0];
                arr[1] = tickets[i][1];
                
                visited[i] = true;
                dfs(2, tickets[i][1], tickets);
        	}
		}
        
        Collections.sort(list, (o1, o2) -> {
            String s1 = String.join("", o1);
            String s2 = String.join("", o2);
            
            return s1.compareTo(s2);
        });
        
        return list.get(0);
    }
	
	public void dfs(int depth, String startAirLine, String[][] tickets) { 
		if (depth == tickets.length+1) {
			String[] copy = Arrays.copyOf(arr, arr.length);
			list.add(copy);
			return;
		}
		
		for (int i = 0; i < tickets.length; i++) {
			if (!visited[i] && startAirLine.equals(tickets[i][0])) {
				visited[i] = true;
				arr[depth] = tickets[i][1];
				dfs(depth+1, tickets[i][1], tickets);
				visited[i] = false;
			}
		}
	}
}
