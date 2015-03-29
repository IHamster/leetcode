package com.bupt.jiameng.leetcode.easy;

/**
 * Created by jiameng on 15/3/29.
 */
public class ValidSudoku {
  public boolean isValidSu(char[][] board) {

    //整行整列扫描
    for (int i = 0; i < 9; i++) {
      int[] rowcount = new int[9];//存放按行扫描的结果
      int[] colcount = new int[9];//存放按列扫描的结果
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.') {
          int currow = board[i][j] - '1';
          rowcount[currow] += 1;
          if (rowcount[currow] > 1) {
            return false;
          }
        }
        if (board[j][i] != '.') {
          int curcol = board[j][i] - '1';
          colcount[curcol] += 1;
          if (colcount[curcol] > 1) {
            return false;
          }
        }

      }
    }

    //每个单独的数独扫描
    int rowstart = 0,colstart=0;//每个数独的起点
    for (int i = 0; i < 9; i++) {//共有3行小数独
      rowstart = i/3*3;
      colstart = i%3*3;
      int[] count = new int[9];
      for (int j = 0; j < 9; j++) {//每行有3个数独
        if (board[rowstart+j/3][colstart+j%3] != '.') {
          int cur = board[rowstart+j/3][colstart+j%3] - '1';
          count[cur] += 1;
          if (count[cur] > 1) {
            return false;
          }
        }
      }

    }
    return true;
  }

  public static void main(String[] args){
    char[][] shudu = {{'.','8','7','6','5','4','3','2','1'},
        {'2','.','.','.','.','.','.','.','.'},
        {'3','.','.','.','.','.','.','.','.'},
        {'4','.','.','.','.','.','.','.','.'},
        {'5','.','.','.','.','.','.','.','.'},
        {'6','.','.','.','.','.','.','.','.'},
        {'7','.','.','.','.','.','.','.','.'},
        {'8','.','.','.','.','.','.','.','.'},
        {'9','.','.','.','.','.','.','.','.'}};

    ValidSudoku v = new ValidSudoku();
    System.out.println(v.isValidSu(shudu));
  }
}
