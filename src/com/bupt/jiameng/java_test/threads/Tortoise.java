package com.bupt.jiameng.java_test.threads;

/**
 * User: jiameng
 * Date: 15/5/25
 * Time: 下午11:33
 */
public class Tortoise implements Runnable {
  private int totalStep;
  private int step;

  public Tortoise(int totalStep){
    this.totalStep = totalStep;
    step = 0;
  }


  @Override
  public void run() {
    try{
      while(step<totalStep){
        Thread.sleep(1000);
        step++;
        System.out.println("乌龟跑了"+step+"步");
      }
    }catch (InterruptedException e){
      e.printStackTrace();
    }

  }
}
