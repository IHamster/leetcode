package com.bupt.jiameng.offer;

import java.util.Stack;

/**
 * User: jiameng
 * Date: 15/4/16
 * Time: 下午10:28
 */
//栈的压入、弹出序列
//  输入两个整数序列，第一个序列表示栈的压入顺序，判断第二个序列是不是栈的弹出顺序
//  eg：1，2，3，4，5
//      4，5，3，2，1
public class Question22 {
  public boolean isPopOrder(int[] push, int[] pop) {
    boolean isOrder = false;
    if (push == null || pop == null || push.length < 1 || push.length < 1)
      return isOrder;

    int index1 = 0;//push index
    int index2 = 0;// pop index
    int length = push.length;
    Stack<Integer> s = new Stack();
    while (index2 < pop.length) {
      if (index1 < length){//如果小于就push，否则就不再push
        s.push(push[index1]);
      }

      if(s.peek() == pop[index2]){
        s.pop();
        index2++;
      }else if(index1 == length){break;}
      index1++;
    }
    if(s.empty()) isOrder = true;
    return isOrder;
  }

  public static void main(String[] args){
    Question22 q = new Question22();
    int[] push = {1,2,3,4,5};
    int[] pop={6,6,6,6,6};
    System.out.println(q.isPopOrder(push,pop));
  }
}
