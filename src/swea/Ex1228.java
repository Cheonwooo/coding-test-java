package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex1228 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			sb.append("#" + t + " ");
			
			int n = Integer.parseInt(br.readLine());
			ArrayList<Integer> list = new ArrayList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			int commandCount = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < commandCount; i++) {
				String option = st.nextToken();
				int startIndex = Integer.parseInt(st.nextToken());
				int count = Integer.parseInt(st.nextToken());
				int[] addList = new int[count];
				
				for (int j = 0; j < count; j++) {
					addList[j] = Integer.parseInt(st.nextToken());
				}
				
				for (int j = count-1; j >= 0; j--) {
					list.add(startIndex, addList[j]);
				}
			}
			
			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i) + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
