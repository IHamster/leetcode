package com.bupt.jiameng.leetcode.easy;

/**
 * User: jiameng
 * Date: 15/4/11
 * Time: 下午8:49
 */
public class HouseRobber {

//  rob[N]：表示到第N家商户的最大化收益
//  notRob[N]：表示在不抢劫第N家商户的前提下的最大化收益。
//  继续…..
//  如果这条街道上只有一家商户，为了利益最大化，你决定抢，则为rob[0] = num.at(0)，但是你忽然发善心，不抢了，则notRob[0] = 0.
//  之后这条街道繁荣起来了，商户变多，假设有N家商户，此时你已经“处理（抢或者不抢巴拉巴拉）”了前N-1家商户，来到了第N家商户的门前。那么摆在你面前的选择题如下：
//      1、对第N家商户不抢，则你的最大化收益就是截止到第N-1商户的收益，即notRob[N] = r[N - 1];
//  rob[N] = rob[N - 1];
//  2、假设你要对第N家商户动手，那么有一个重要的前提就是：你没有抢劫第N-1家商户。则收益为
//  rob[N] = notRob[N - 1] + num.at(N) > rob[N] ? notRob[N - 1] + num.at(N) : rob[N];
//
//  按照这个规则你一直抢到最后一家商户，比较一下notRob[N]和rob[N]哪个比较大就ok了。
  public int rob(int[] num) {
    if(num == null || num.length<1) return 0;

    int length = num.length;
    int[] rob = new int[length];
    int[] nrob = new int[length];

    rob[0] = num[0];
    nrob[0] = 0;

    for(int i=1;i<length;i++){

      nrob[i] = rob[i-1];
      rob[i] = nrob[i-1]+num[i];

      if(rob[i-1]>rob[i])
        rob[i]=rob[i-1];
    }

    return rob[length-1]>nrob[length-1]?rob[length-1]:nrob[length-1];
  }

  public int rob2(int[] num){
    if(num == null || num.length<1) return 0;
    if(num.length ==1) return num[0];
    int length =num.length;
    int[] max = new int[length];
    max[0]=num[0];
    max[1]= Math.max(num[1],max[0]);
    for(int i=2;i<length;i++){
      max[i] = Math.max(max[i-2]+num[i],max[i-1]);
    }

    return max[length-1];
  }
}
