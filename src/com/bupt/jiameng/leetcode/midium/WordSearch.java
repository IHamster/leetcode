package com.bupt.jiameng.leetcode.midium;

/**
 * User: jiameng
 * Date: 15/7/15
 * Time: 下午11:43
 */
//Given a 2D board and a word, find if the word exists in the grid.
//
//    The word can be constructed from letters of sequentially adjacent cell,
// where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
//
//    For example,
//    Given board =
//
//    [
//    ["ABCE"],
//    ["SFCS"],
//    ["ADEE"]
//    ]
//    word = "ABCCED", -> returns true,
//    word = "SEE", -> returns true,
//    word = "ABCB", -> returns false.
public class WordSearch {

  public boolean exist(char[][] board, String word) {
    if (board == null || board.length < 1 || board[0].length < 1 || word == null || word.length() < 1)
      return false;

    int[][] direct = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if(search(board, word, i, j, direct)) return true;
      }
    }
    return false;
  }

  private boolean search(char[][] board, String word, int x, int y, int[][] direct) {
    for (int i = 0; i < direct.length; i++) {
      if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == word.charAt(0)) {
        char tmp = board[x][y];
        board[x][y] = '*';
        if (word.length() == 1 || search(board, word.substring(1), x + direct[i][0], y + direct[i][1], direct))
          return true;
        board[x][y] = tmp;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    WordSearch ws = new WordSearch();
    char[][] board = {
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'},
    };
//    char[][] board = {{'a'}};
    System.out.println(ws.exist(board,"ABCB"));

  }
}
