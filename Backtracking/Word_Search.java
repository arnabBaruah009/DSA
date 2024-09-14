package Backtracking;

class Solution {
    public boolean exist(char[][] board, String word) {
        char ch = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == ch && solve(board, i, j, word, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean solve(char[][] board, int i, int j, String word, int index) {
        if (index == word.length())
            return true;
        if (i < 0 || j < 0 || i == board.length || j == board[0].length)
            return false;
        if (board[i][j] == '#' || board[i][j] != word.charAt(index))
            return false;

        char temp = board[i][j];
        board[i][j] = '#';
        boolean result = solve(board, i, j + 1, word, index + 1) || solve(board, i + 1, j, word, index + 1)
                || solve(board, i, j - 1, word, index + 1) || solve(board, i - 1, j, word, index + 1);
        board[i][j] = temp;
        return result;
    }
}
