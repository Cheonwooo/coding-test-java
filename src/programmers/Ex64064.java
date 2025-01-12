package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Ex64064 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] user1 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] ban1 = {"fr*d*", "abc1**"};
		
		String[] user2 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] ban2 = {"*rodo", "*rodo", "******"};
		
		String[] user3 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] ban3 = {"fr*d*", "*rodo", "******", "******"};
		
		solution(user1, ban1);
	}
	
	private static Set<String> answer = new HashSet<>();
	private static List<String>[] banIds;
	
	public static int solution(String[] user_id, String[] banned_id) {
        
        banIds = new List[banned_id.length];
        for (int i = 0; i < banned_id.length; i++) {
        	banIds[i] = new ArrayList<>();
        }
        
        makeBanIdsList(banned_id, user_id);
        
        Arrays.sort(banIds, Comparator.comparingInt(List::size));
        
        dfs(0, new ArrayList<String>());
//        for (List<String> ids : banIds) {
//        	for (String id : ids) {
//        		System.out.print(id + " ");
//        	}
//        	System.out.println();
//        }
//        for (String val : answer) {
//        	System.out.println(val);
//        }
        
        return answer.size();
    }
	
	public static void makeBanIdsList(String[] banned_id, String[] user_id) {
		for (int i = 0; i < banned_id.length; i++) {
			int banIdSize = banned_id[i].length();
			for (int j = 0; j < user_id.length; j++) {
				int userIdSize = user_id[j].length();
				
				if (banIdSize != userIdSize) continue;
				
				if (compare(banned_id[i], user_id[j], banIdSize)) {
					banIds[i].add(user_id[j]);
				}
			}
		}
	}
	
	public static boolean compare(String banId, String userId, int size) {
		for (int i = 0; i < size; i++) {
			if (banId.charAt(i) != '*' 
					&& banId.charAt(i) != userId.charAt(i)) return false;
		}
		return true;
	}
	
	public static void dfs(int listIdx, List<String> userIds) {
		if (listIdx == banIds.length) {
			Collections.sort(userIds);
			
			String str = userIds.stream().collect(Collectors.joining());
			
			answer.add(str);
			return;
		}
		
		for (int i = 0; i < banIds[listIdx].size(); i++) {
			if (userIds.contains(banIds[listIdx].get(i))) continue;
			
			List<String> tempUserIds = new ArrayList<>(userIds);
			tempUserIds.add(banIds[listIdx].get(i));
			dfs(listIdx+1, tempUserIds);
		}
	}
}
