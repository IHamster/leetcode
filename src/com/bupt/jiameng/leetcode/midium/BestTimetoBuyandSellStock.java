package com.bupt.jiameng.leetcode.midium;

/**
 * User: jiameng
 * Date: 15/5/10
 * Time: 上午12:34
 */
public class BestTimetoBuyandSellStock {

  //time limited
  public int maxProfit(int[] prices) {
    if(prices==null || prices.length<1) return 0;

    int max = 0;
    for(int i =0;i<prices.length;i++){
      int buy = prices[i];
      for(int j=i+1;j<prices.length;j++){
        if(max<(prices[j]-buy)){
          max = prices[j]-buy;
        }
      }
    }
    return max;
  }


  //dp
  public int maxProfit2(int[] prices) {
    if(prices==null || prices.length<1) return 0;

    int max = 0;
    int minPrice = prices[0];
    for(int i =1;i<prices.length;i++){
      if((prices[i]-minPrice)>max){
        max = prices[i]-minPrice;
      }
      if(prices[i]<minPrice)
        minPrice=prices[i];
    }
    return max;
  }

}
