package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 아이디어
 * 장르별 플레이 수 Map 저장 - genrePlays
 *  -> 재생횟수 높은 순으로 저장
 * 장르/인덱스/플레이 수 를 저장해야함
 *  -> Map<String(장르), List<playSong(고유번호, 재생횟수)>> - totalPlays 
 *  -> List에 저장할 때 재생횟수가 높은 순으로 
 *  -> 재생횟수가 같다면 고유번호가 낮은 순으로 저장
 * genrePlays 순회 하면서 totalPlays에 Key값으로 value값 호출
 * value의 사이즈가 2이하인 경우 바로 출력, 2보다 큰 경우 맨 앞 2개만 출력
 *
 * 시간복잡도
 * 
 */

public class Ex42579 {
	
	public static class PlaySong implements Comparable<PlaySong> {
		int songId;
		int playCount;
		
		public PlaySong(int songId, int playCount) {
			this.songId = songId;
			this.playCount = playCount;
		}
		
		public int getSongId() {
			return songId;
		}
		
		public int getPlayCount() {
			return playCount;
		}
		
		public int compareTo(PlaySong other) {
			if (this.playCount == other.playCount) {
				return Integer.compare(this.songId, other.songId);
			}
			return Integer.compare(other.playCount, this.playCount);
		}
	}

	public static void main(String[] args) {
		String[] genres = {"K-pop", "classic", "pop", "classic", "classic", "pop"};
		int[] plays = {1600, 500, 600, 150, 800, 2500};
		
		List<Integer> list = solution(genres, plays);
		for (int val : list) {
			System.out.print(val + " ");
		}
	}
	
	public static List<Integer> solution(String[] genres, int[] plays) {
		Map<String, Integer> genrePlays = new HashMap<>();
		Map<String, List<PlaySong>> totalPlays = new HashMap<>();
		
		int size = genres.length;
		for (int i=0; i<size; i++) {
			//장르별 재생횟수 저장
			genrePlays.put(genres[i], genrePlays.getOrDefault(genres[i], 0)+plays[i]);
			
			//장르별 인덱스,재생횟수 저장
			PlaySong playSong = new PlaySong(i, plays[i]);
			
			List<PlaySong> playSongs = totalPlays.get(genres[i]);
			
			//아직 장르에 해당되는 키가 저장되지 않았다면
			if (playSongs == null) {
				playSongs = new ArrayList<>();
				totalPlays.put(genres[i], playSongs);
			}
			
			playSongs.add(playSong);
			totalPlays.put(genres[i], playSongs);
		}
		
		//genrePlays를 value값을 기준으로 내림차순 정렬
		List<String> keySet = new ArrayList<>(genrePlays.keySet());
		
		keySet.sort(new Comparator<String>() {
			public int compare(String o1, String o2) {
				return genrePlays.get(o2).compareTo(genrePlays.get(o1));
			}
		});
		
//		for (String key : keySet) {
//			System.out.println(key + " " + genrePlays.get(key));
//		}
//		
//		for (String key : totalPlays.keySet()) {
//			List<PlaySong> songs = totalPlays.get(key);
//			Collections.sort(songs);
//			for (PlaySong song : songs) {
//				System.out.println(song.getSongId() + " " + song.getPlayCount());
//			}
//		}
		
		List<Integer> answer = new ArrayList<>();
		
		for (String key : keySet) {
			List<PlaySong> playSongs = totalPlays.get(key);
			
			//playSongs의 사이즈가 1이라면 그 한곡의 인덱스만 출력
			//사이즈가 2이상이라면 정렬후 0,1번째 인덱스만 출력
			if (playSongs.size() == 1) {
				answer.add(playSongs.get(0).getSongId());
			} else {
				Collections.sort(playSongs);
				
				for (int i = 0; i < 2; i++) {
					answer.add(playSongs.get(i).getSongId());
				}
			}
		}
		
		return answer;
    }

}
