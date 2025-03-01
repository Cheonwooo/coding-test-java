package programmers;

public class Ex150365 {
	private static int ln, lm, sx, sy, ex, ey, ck;
    private static int[] dx = {1, 0, 0, -1};
    private static int[] dy = {0, -1, 1, 0};
    private static String ans = null;
    private static String[] dir = {"d", "l", "r", "u"};
    
    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        sx = x-1;
        sy = y-1;
        ex = r-1;
        ey = c-1;
        ck = k;
        ln = n;
        lm = m;
        
        int dis = Math.abs(sx - ex) + Math.abs(sy - ey);
        if (dis % 2 != k%2) {
            return "impossible";
        }
        
        if (dis > k) {
            return "impossible";
        }
        
        dfs (sx, sy, new StringBuilder());
        
        return ans;
    }
    
    public static void dfs(int cx, int cy, StringBuilder sb) {
        if (ans != null) return;
        
        if (sb.length() == ck && cx == ex && cy == ey) {
            ans = sb.toString();
            return;
        } else if (sb.length() == ck) {
            return;
        }
        
        int dis = Math.abs(cx-ex) + Math.abs(cy-ey);
        if (ck - sb.length() < dis) return;
        
        for (int i = 0; i < 4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];
            
            if (nx < 0 || nx >= ln || ny < 0 || ny >= lm) continue;
            
            sb.append(dir[i]);
            
            dfs(nx, ny, sb);
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}
