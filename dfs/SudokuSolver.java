/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * Empty cells are indicated by the character '.'.
 *
 * You may assume that there will be only one unique solution.
 */
// Version 1: brute force, try every number for each empty cell.
public class Solution {
    public void solveSudoku(char[][] board){
        solve(board);
    }

    public boolean solve(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    continue;
                }
                for(int k = 1; k <= 9; k++){
                    board[i][j] = (char) (k + '0');
                    if (isValid(board, i, j) && solve(board)){
                        return true;
                    }
                }
                // point: set back if current solution could not fit
                board[i][j] = '.';
                return false;
            }
        }
        return true;
    }


     public boolean isValid(char[][] board, int i, int j){
         // check the row not contains the same item as board[i][j]
         for (int n = 0; n < 9; n++) {
             if (n != j && board[i][n] == board[i][j]) {
                 return false;
             }
         }

         // check the col not contains the same item as board[i][j]
         for (int n = 0; n < 9; n++) {
             if (n != i && board[n][j] == board[i][j]) {
                 return false;
             }
         }

         // check the current rect not contains the same item as board[i][j]
         for (int m = 0; m < 3; m++) {
            for (int n = 0; n < 3; n++){
                int x = (i / 3) * 3 + m, y = (j / 3) * 3 + n;
                if (x != i && y != j && board[x][y] == board[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}

// Version 2(incomplete): memo every empty cell's candidates,
// find the min number candidates
public class Solution {

    static class Pos {
        public int i;
        public int j;
        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public int hashCode() {
            return i * 33 + j;
        }

        @Override
        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }

            if (!(other instanceof Pos)) {
                return false;
            }
            Pos p = (Pos) other;
            return p.i == this.i && p.j == this.j;
        }
    }

    private int getBoxId(Pos p) {
        return (p.i / 3) * 3 + (p.j / 3);
    }

    public void solveSudoku(char[][] board) {
        // cell candidate char
        Map<Pos, Set<Character>> cells = new HashMap<Pos, Set<Character>>();
        // empty cell on this row
        Map<Integer, List<Set<Character>>> rows = new HashMap<Integer, List<Set<Character>>>();
        for (int i = 0; i < 9; i++) {
            rows.put(i, new ArrayList<Set<Character>>());
        }

        // empty cell on this col
        Map<Integer, List<Set<Character>>> cols = new HashMap<Integer, List<Set<Character>>>();
        for (int i = 0; i < 9; i++) {
            cols.put(i, new ArrayList<Set<Character>>());
        }

        // empty cell on this box
        Map<Integer, List<Set<Character>>> boxes = new HashMap<Integer, List<Set<Character>>>();
        for (int i = 0; i < 9; i++) {
            boxes.put(i, new ArrayList<Set<Character>>());
        }

        // init row
        for (int i = 0; i < 9; i++) {
            Set<Character> candidates = new HashSet<Character>();
            for (int n = 1; n <= 9; n++) {
                candidates.add((char)('0' + n));
            }
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    candidates.remove(board[i][j]);
                }
            }
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    Set<Character> c = new HashSet<Character>(candidates);
                    cells.put(new Pos(i, j), c);
                    rows.get(i).add(c);
                }
            }
        }

        // init col
        for (int j = 0; j < 9; j++) {
            Set<Character> candidates = new HashSet<Character>();
            for (int n = 1; n <= 9; n++) {
                candidates.add((char)('0' + n));
            }
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    candidates.remove(board[i][j]);
                }
            }
            for (int i = 0; i < 9; i++) {
                if (board[i][j] == '.') {
                    Set<Character> c = cells.get(new Pos(i, j));
                    Iterator<Character> iter = c.iterator();
                    while (iter.hasNext()) {
                        char cc = iter.next();
                        if (!candidates.contains(cc)) {
                            iter.remove();
                        }
                    }
                    cols.get(j).add(c);
                }
            }
        }

        // init boxes
        for (int n = 0; n < 9; n++) {
            Set<Character> candidates = new HashSet<Character>();
            for (int m = 1; m <= 9; m++) {
                candidates.add((char)('0' + m));
            }

            int i = n / 3;
            int j = n % 3;

            for (int k = i * 3; k < i * 3 + 3; k++) {
                for (int l = j * 3; j < j * 3 + 3; j++) {
                    if (board[k][l] != '.') {
                        candidates.remove(board[k][l]);
                    }
                }
            }

            for (int k = i * 3; k < i * 3 + 3; k++) {
                for (int l = j * 3; j < j * 3 + 3; j++) {
                    if (board[k][l] == '.') {
                        Set<Character> c = cells.get(new Pos(k, l));
                        Iterator<Character> iter = c.iterator();
                        while (iter.hasNext()) {
                            char cc = iter.next();
                            if (!candidates.contains(cc)) {
                                iter.remove();
                            }
                        }
                        boxes.get(n).add(c);
                    }
                }
            }
        }

        PriorityQueue<Pos> heap = new PriorityQueue<Pos>(81, new Comparator<Pos>() {
            public int compare(Pos p1, Pos p2) {
                return cells.get(p1).size() - cells.get(p2).size();
            }
        });


        while (!cells.isEmpty()) {
            for (Map.Entry<Pos, Set<Character>> entry : cells.entrySet()) {
                Pos p = entry.getKey();
                Set<Character> candidates = entry.getValue();
                if (candidates.size() == 1) {
                    Character[] cs = (Character[]) candidates.toArray();
                    char c = cs[0];
                    board[p.i][p.j] = c;

                    // remove c from all rows' cell, cols' cell and boxes' cell
                    // TODO: change Set<Character> to Cell { Pos, Set<Character> }

                    for (Set<Character> s : rows.get(p.i)) {
                        s.remove(c);
                        heap.remove()
                    }

                    for (Set<Character> s : cols.get(p.j)) {
                        s.remove(c);
                    }

                    for (Set<Character> s : boxes.get(getBoxId(p))) {
                        s.remove(c);
                    }

                }
            }
        }
    }
}



