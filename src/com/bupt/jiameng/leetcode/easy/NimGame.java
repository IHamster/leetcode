package com.bupt.jiameng.leetcode.easy;

/**
 * User: jiameng
 * Date: 16/2/13
 * Time: 下午5:08
 */
//You are playing the following Nim Game with your friend:
// There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones.
// The one who removes the last stone will be the winner. You will take the first turn to remove the stones.
//
//    Both of you are very clever and have optimal strategies for the game.
// Write a function to determine whether you can win the game given the number of stones in the heap.
//
//    For example, if there are 4 stones in the heap, then you will never win the game:
// no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.
//

public class NimGame {
  public boolean canWinNim(int n) {
    if(n>=0 && n<=3) return true;
    if(((n-1)%4 != 0) && ((n-2)%4 != 0) && ((n-3)%4 != 0)) return false;

    return true;
  }

  public static void main(String[] args){
    NimGame n = new NimGame();
    System.out.println(n.canWinNim(6));
  }
}
