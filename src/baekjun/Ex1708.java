package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ex1708 {
		
	public static class Point {
		long x;
		long y;

		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static Point root;
	private static List<Point> points = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points.add(new Point(x, y));
		}
		
		root = new Point(40001, 40001);
		
		for (int i = 0; i < points.size(); i++) {
			Point nowPoint = points.get(i);
			
			if (nowPoint.y < root.y) {
				root = nowPoint;
			} else if (nowPoint.y == root.y) {
				if (nowPoint.x < root.x) {
					root = nowPoint;
				}
			}
		}
		
		points.sort(new Comparator<Point>() {
			public int compare(Point p1, Point p2) {
				long result = ccw(root, p1, p2);
				if (result > 0) return -1;
				if (result < 0) return 1;
				if (result == 0) {
					long distAtoB = dist(root, p1);
					long distAtoC = dist(root, p2);
					if (distAtoB > distAtoC) {
						return 1;
					}
				}
				return -1;
			}
		});
		
		Stack<Point> stack = new Stack<>();
		stack.push(root);
		for (int i = 1; i < points.size(); i++) {
			while (stack.size() > 1 && ccw(stack.get(stack.size() - 2), stack.get(stack.size() - 1), points.get(i)) <= 0) {
				stack.pop();
			}
			stack.push(points.get(i));
		}
		System.out.println(stack.size());
	}
	
	private static long ccw(Point p1, Point p2, Point p3) {
		long result = (p1.x*p2.y + p2.x*p3.y + p3.x*p1.y) - (p1.y*p2.x + p2.y*p3.x + p3.y*p1.x);
		if (result > 0) return 1;//반시계방향
		if (result < 0) return -1;//시계방향
		return 0;//일직선
	}
	
	private static long dist(Point p1, Point p2) {
		long distance = (p2.x-p1.x)*(p2.x-p1.x) + (p2.y-p1.y)*(p2.y-p1.y);
		return distance;
	}
}
