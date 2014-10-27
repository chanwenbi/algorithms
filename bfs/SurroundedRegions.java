/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 */
public class Solution {

    // Version 1: check the region adjacency with "outer" 'O'(recommanded)
    // O(n^2)
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 0; i < cols; i++) {
            enqueue(queue, board, 0, i);
            enqueue(queue, board, rows - 1, i);
        }

        for (int i = 0; i < rows; i++) {
            enqueue(queue, board, i, 0);
            enqueue(queue, board, i, cols - 1);
        }

        while (!queue.isEmpty()) {
            int pos = queue.poll();
            int i = pos / cols;
            int j = pos % cols;

            enqueue (queue, board, i + 1, j);
            enqueue (queue, board, i - 1, j);
            enqueue (queue, board, i, j + 1);
            enqueue (queue, board, i, j - 1);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void enqueue(Queue<Integer> queue, char[][] board, int i, int j) {
        int rows = board.length;
        int cols = board[0].length;

        if (i >= 0 && i < rows && j >= 0 && j < cols && board[i][j] == 'O') {
            queue.add(i * cols + j);
            board[i][j] = '#';
        }
    }

    // Version 2: check every 'O' find it's adjacency 'O' aside with checking it's
    // correctness
    private static class Point {
        int r;
        int c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private void flipping(char[][] board, List<Point> path) {
        for (Point p : path) {
            board[p.r][p.c] = 'X';
        }
    }

    // check and add non-visited 'O'
    private boolean checkAndAddO(char[][] board, boolean[][] visited,
            Queue<Point> points, List<Point> path, Point p) {
        if (p.r < 0 || p.c < 0 || p.r >= board.length
                || p.c >= board[0].length) {
            return false;
        }
        if (board[p.r][p.c] == 'O' && !visited[p.r][p.c]) {
            visited[p.r][p.c] = true;
            path.add(p);
            points.offer(p);
        }
        return true;
    }

    private void BFS(char[][] board, boolean[][] visited, Point p) {
        // BFS points
        Queue<Point> points = new LinkedList<Point>();
        List<Point> path = new ArrayList<Point>();
        visited[p.r][p.c] = true;
        points.offer(p);
        path.add(p);
        boolean capturable = true;
        while (!points.isEmpty()) {
            Point point = points.poll();
            capturable = checkAndAddO(board, visited, points, path,
                    new Point(point.r, point.c - 1)) && capturable;
            capturable = checkAndAddO(board, visited, points, path,
                    new Point(point.r, point.c + 1)) && capturable;
            capturable = checkAndAddO(board, visited, points, path,
                    new Point(point.r - 1, point.c)) && capturable;
            capturable = checkAndAddO(board, visited, points, path,
                    new Point(point.r + 1, point.c)) && capturable;
        }
        if (capturable) {
            flipping(board, path);
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length <= 2 || board[0].length <= 2) {
            return;
        }
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    BFS(board, visited, new Point(i, j));
                }
            }
        }
    }
}
