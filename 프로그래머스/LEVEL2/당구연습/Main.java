import java.util.*;

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        for (int i = 0; i < balls.length; i++) {
            int endX = balls[i][0], endY = balls[i][1];
            long minDist = Long.MAX_VALUE;

            // 상단 벽
            if (!(startX == endX && endY > startY)) {
                long dx = endX - startX;
                long dy = 2L * n - endY - startY;
                minDist = Math.min(minDist, dx * dx + dy * dy);
            }

            // 하단 벽
            if (!(startX == endX && endY < startY)) {
                long dx = endX - startX;
                long dy = endY + startY;
                minDist = Math.min(minDist, dx * dx + dy * dy);
            }

            // 좌측 벽
            if (!(startY == endY && endX < startX)) {
                long dx = endX + startX;
                long dy = endY - startY;
                minDist = Math.min(minDist, dx * dx + dy * dy);
            }

            // 우측 벽 (여기서 dy 선언 누락이 원인!)
            if (!(startY == endY && endX > startX)) {
                long dx = 2L * m - endX - startX;
                long dy = endY - startY;
                minDist = Math.min(minDist, dx * dx + dy * dy);
            }

            answer[i] = (int)minDist;
        }
        return answer;
    }
}
