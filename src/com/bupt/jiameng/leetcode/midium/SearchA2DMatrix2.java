package com.bupt.jiameng.leetcode.midium;

/**
 * User: jiameng
 * Date: 15/8/18
 * Time: 下午10:09
 */
//Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//
//    Integers in each row are sorted in ascending from left to right.
//    Integers in each column are sorted in ascending from top to bottom.
//    For example,
//
//    Consider the following matrix:
//
//    [
//    [1,   4,  7, 11, 15],
//    [2,   5,  8, 12, 19],
//    [3,   6,  9, 16, 22],
//    [10, 13, 14, 17, 24],
//    [18, 21, 23, 26, 30]
//    ]
//    Given target = 5, return true.
//
//    Given target = 20, return false.
public class SearchA2DMatrix2 {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length < 1 || matrix[0].length < 1)
      return false;
    boolean isFind = false;
    int row = 0;
    int col = matrix[0].length - 1;
    while (row < matrix.length && col > -1) {
      if (matrix[row][col] > target)
        col--;
      else if (matrix[row][col] < target)
        row++;
      else if (matrix[row][col] == target) {
        isFind = true;
        break;
      }
    }
    return isFind;
  }

  public static void main(String[] args) {
    SearchA2DMatrix2 s = new SearchA2DMatrix2();
    int[][] martrix = {
        {1, 4, 7, 11, 15},
        {2, 5, 8, 12, 19},
        {3, 6, 9, 16, 22},
        {10, 13, 14, 17, 24},
        {18, 21, 23, 26, 30}
    };
    System.out.println(s.searchMatrix(martrix,9));
  }
}
