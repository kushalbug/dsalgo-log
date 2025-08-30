//day - 20
import java.util.*;
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 9 sets for rows, columns, and boxes
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue; // skip empty cells

                // find box index
                int boxIndex = (i / 3) * 3 + j / 3;

                if (rows[i].contains(c) || cols[j].contains(c) || boxes[boxIndex].contains(c)) {
                    return false;
                }

                rows[i].add(c);
                cols[j].add(c);
                boxes[boxIndex].add(c);
            }
        }

        return true;
    }
}
