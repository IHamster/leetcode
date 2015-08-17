package com.bupt.jiameng.leetcode.midium;

/**
 * User: jiameng
 * Date: 15/8/17
 * Time: 上午11:45
 */
//Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//
//    If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
//
//    The replacement must be in-place, do not allocate extra memory.
//
//    Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
//    1,2,3 → 1,3,2
//    3,2,1 → 1,2,3
//    1,1,5 → 1,5,1
//对当前排列从后向前扫描，找到一对为升序的相邻元素，记为i和j（i < j）。
//    如果不存在这样一对为升序的相邻元素，则所有排列均已找到，算法结束；
//    否则，重新对当前排列从后向前扫描，找到第一个大于i的元素k，交换i和k，然后对从j开始到结束的子序列反转，则此时得到的新排列就为下一个字典序排列。
//    这种方式实现得到的所有排列是按字典序有序的，这也是C++ STL算法next_permutation的思想。
public class NextPermutation {
  public void nextPermutation(int[] nums) {
    if (nums == null || nums.length < 1) return;

    int pos = -1;
    for (int i = nums.length - 1; i >= 1; i--) {
      if (nums[i] > nums[i - 1]) {
        pos = i - 1;
        break;
      }
    }

    if (pos == -1)
      reverse(nums, 0, nums.length - 1);
    else {
      for (int j = nums.length - 1; j >= 0; j--) {
        if (nums[pos] < nums[j]) {
          int tmp = nums[pos];
          nums[pos] = nums[j];
          nums[j] = tmp;
          break;
        }
      }
      reverse(nums, pos + 1, nums.length - 1);
    }
  }

  private void reverse(int[] nums, int start, int end) {
    if (nums == null || nums.length <= 1) return;
    while (start < end) {
      int tmp = nums[start];
      nums[start] = nums[end];
      nums[end] = tmp;
      start++;
      end--;
    }
  }

  public static void main(String[] args) {
    NextPermutation n = new NextPermutation();
    int[] nums = {3,2,1};
    n.nextPermutation(nums);
    for (int i : nums)
      System.out.print(i + "->");
  }
}
