package com.bupt.jiameng.java_test.threads;

/**
 * User: jiameng
 * Date: 15/5/25
 * Time: 下午11:21
 */
public class TortoiseHareRace {
  public static void main(String[] args) throws InterruptedException {
    boolean[] flag = {true, false};
    int totalStep = 10;
    int tortoiseStep = 0;
    int hareStep = 0;
    System.out.println("龟兔赛跑开始……");
    while(tortoiseStep<totalStep && hareStep<totalStep){
      Thread.sleep(1000);
      tortoiseStep++;
      System.out.println("乌龟跑了"+tortoiseStep+"步");
      boolean isHareSleep = flag[((int)(Math.random()*10))%2];
      if(isHareSleep){
        System.out.println("兔子睡着了……");
      }else{
        hareStep = hareStep+2;
        System.out.println("兔子跑了"+hareStep+"步");
      }
    }
  }
}
