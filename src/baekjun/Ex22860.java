package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Ex22860 {
	private static class Folder {
		List<String> folders;
		List<String> files;
		
		public Folder(List<String> folders, List<String> files) {
			this.folders = folders;
			this.files = files;
		}

		public void addFile(String file) {
			files.add(file);
		}
		
		public void addFolder(String folder) {
			folders.add(folder);
		}
	}
	
	private static List<String> allFiles;
	private static Set<String> typeOfFiles;
	private static Map<String, Integer> folderIndex = new HashMap<>();
	private static Folder[] folders;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		folders = new Folder[n+1];
		for (int i = 0; i < n+1; i++) {
			List<String> folderList = new ArrayList<>();
			List<String> fileList = new ArrayList<>();
			folders[i] = new Folder(folderList, fileList);
		}
		
		folderIndex.put("main", 0);
		
		int index = 1;
		for (int i = 0; i < n + m; i++) {
			st = new StringTokenizer(br.readLine());
			
			String p = st.nextToken();
			String f = st.nextToken();
			int c = Integer.parseInt(st.nextToken());
			
			if (c == 1) {//폴더라면
				//저장된 부모 폴더가 없다면 생성해주기
				//하위 폴더에 넣어주기.
				if (folderIndex.get(p) == null) {
					folderIndex.put(p, index++);
				}
				int indexOfParentFolder = folderIndex.get(p);
				folders[indexOfParentFolder].addFolder(f);
			} else {//파일이라면
				//저장된 부모 폴더가 없다면 생성해주기
				//그다음 파일 리스트에 넣기
				if (folderIndex.get(p) == null) {
					folderIndex.put(p, index++);
				}
				int indexOfParentFolder = folderIndex.get(p);
				folders[indexOfParentFolder].addFile(f);
			}
		}
		
		int q = Integer.parseInt(br.readLine());
		for (int i = 0; i < q; i++) {
			String[] route = br.readLine().split("/");
			
			allFiles = new ArrayList<>();
			typeOfFiles = new HashSet<>();
			
			if (folderIndex.get(route[route.length - 1]) == null) {
				System.out.println(0 + " " + 0);
				continue;
			}
			
			int indexOfFolder = folderIndex.get(route[route.length - 1]);
			List<String> fileList = folders[indexOfFolder].files;
			allFiles.addAll(fileList);
			typeOfFiles.addAll(fileList);
			
			dfs(indexOfFolder);
			
			System.out.println(typeOfFiles.size() + " " + allFiles.size());
		}
	}

	private static void dfs(int index) {
		List<String> folderList = folders[index].folders;
		
		for(String folder : folderList) {
			if (folderIndex.get(folder) == null) continue;
			int indexOfFolder = folderIndex.get(folder);
			
			List<String> fileList = folders[indexOfFolder].files;
			allFiles.addAll(fileList);
			typeOfFiles.addAll(fileList);
			
			dfs(indexOfFolder);
		}
	}
}
