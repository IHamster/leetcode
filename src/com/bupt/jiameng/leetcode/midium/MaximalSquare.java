package com.bupt.jiameng.leetcode.midium;

/**
 * User: jiameng
 * Date: 15/8/22
 * Time: 下午10:37
 */
//Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.
//
//    For example, given the following matrix:
//
//    1 0 1 0 0
//    1 0 1 1 1
//    1 1 1 1 1
//    1 0 0 1 0
//    Return 4.
public class MaximalSquare {
  public int maximalSquare(char[][] matrix) {
    if(matrix == null || matrix.length<1 || matrix[0].length<1) return 0;
    int[][] arr = new int[matrix.length][matrix[0].length];
    int maxArae = 0;
    for(int i = 0;i<matrix.length;i++){
      for(int j= 0;j<matrix[0].length;j++){
        if(i == 0 || j == 0){
          arr[i][j] = matrix[i][j]-'0';
        }else{
          if(matrix[i][j] == '1'){
            if((arr[i-1][j] == arr[i][j-1]) && arr[i][j-1]>=1){
              if(arr[i-1][j-1]>0)
                arr[i][j] = Math.min(arr[i-1][j],arr[i-1][j-1]) + 1;
              else
                arr[i][j] = 1;
            }else if((arr[i-1][j] != arr[i][j-1]) && arr[i-1][j]>0 && arr[i][j-1]>0 && arr[i-1][j-1]>0){
              arr[i][j] = Math.min(arr[i-1][j],arr[i][j-1])+1;
            }else{
              arr[i][j] = 1;
            }
          }else{
            arr[i][j] = 0;
          }
        }
        if(arr[i][j]>maxArae)
          maxArae = arr[i][j];
      }
    }
    return maxArae*maxArae;
  }

  public static void main(String[] args){
    MaximalSquare m = new MaximalSquare();
//    char[][] matrix = {
//        {'0','1','1','1','1'},
//        {'1','1','1','1','1'},
//        {'1','1','1','1','1'},
//        {'1','1','1','1','1'}
//    ["11100","11100","11111","01111","01111","01111"]
//    ["101001110","111000001","001100011","011001001","110110010","011111101","101110010","111010001","011110010","100111000"]
    char[][] matrix = {
        {'1','0','1','0','0','1','1','1','0'},
        {'1','1','1','0','0','0','0','0','1'},
        {'0','0','1','1','0','0','0','1','1'},
        {'0','1','1','0','0','1','0','0','1'},
        {'1','1','0','1','1','0','0','1','0'},
        {'0','1','1','1','1','1','1','0','1'},
        {'1','0','1','1','1','0','0','1','0'},
        {'1','1','1','0','1','0','0','0','1'},
        {'0','1','1','1','1','0','0','1','0'},
        {'1','0','0','1','1','1','0','0','0'},
    };
    System.out.println(m.maximalSquare(matrix));
  }
}
