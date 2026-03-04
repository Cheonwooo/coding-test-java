package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Ex22232 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		String[][] files = new String[n][2];
		for (int i = 0; i < n; i++) {
			files[i] = br.readLine().split("\\.");
		}

		HashSet<String> extension = new HashSet<>();
		for (int i = 0; i < m; i++) {
			extension.add(br.readLine());
		}
		
		Arrays.sort(files, new Comparator<String[]>() {
			public int compare(String[] o1, String[] o2) {
				if(o1[0].equals(o2[0])) {
					if (extension.contains(o1[1]) && !extension.contains(o2[1])) {
						return -1;
					} else if (!extension.contains(o1[1]) && extension.contains(o2[1])) {
						return 1;
					} else {
						return o1[1].compareTo(o2[1]);
					}
				} else {
					return o1[0].compareTo(o2[0]);
				}
			}
		});
		
		for (int i = 0; i < n; i++) {
			System.out.println(files[i][0] + "." + files[i][1]);
		}
	}

}
