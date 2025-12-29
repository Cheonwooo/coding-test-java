package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Ex2121 {
	
	private static class Point implements Comparable<Point> {
		int y;
		int x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
		
		public int compareTo(Point other) {
			if (this.y == other.y) {
				return this.x - other.x;
			}
			return this.y - other.y;
		}
	}
	
	private static int n;
	private static List<Point> points;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		points = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			points.add(new Point(y, x));
		}
		
		Collections.sort(points);
		
		int answer = 0;
		for (Point p : points) {
			Point b = new Point(p.y + B, p.x);
			Point c = new Point(p.y, p.x + A);
			Point d = new Point(p.y + B, p.x + A);
			
			if (binarySearch(b) && binarySearch(c) && binarySearch(d)) {
				answer++;
			}
		}
		System.out.println(answer);
	}
	
	private static boolean binarySearch(Point p) {
		int left = 0;
		int right = n;
		
		while (left + 1 < right) {
			int mid = (left + right) / 2;
			Point cur = points.get(mid);
			
			//x값 오름차순으로 정렬됨.
			//x가 같다면 y 오름차순.
			//y가 크다면 right 줄이기
			//y가 작다면 left 늘리기
			//y가 같으면 x값 비교해서 x가 작다면 left 늘리기
			//y가 같으면 x값 비교해서 x가 크다면 right 줄이기
			if (p.y < cur.y || (p.y == cur.y && p.x < cur.x)) {
				right = mid;
			} else {
				left = mid;
			}
		}
		
		if (points.get(left).x == p.x && points.get(left).y == p.y) {
			return true;
		}
		return false;
	}
}

/*
 * 해당 문제는 어떻게 풀어야할까?
 * 점들을 하나씩 돌면서? -> 시간초과.
 * x,y는 음수가 될 수도 있기 때문에 변의 길이 구할 땐 Math.abs 사용
 * x축, y축과 평행한 직사각형이기 때문에 x좌표 혹은 y좌표가 같은 점이 있음.
 * x 혹은 y좌표로 정렬?
 * 0 0
 * 0 3
 * 2 0
 * 2 3
 * 4 0
 * 4 3
 * */