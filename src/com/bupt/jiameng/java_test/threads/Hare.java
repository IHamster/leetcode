package com.bupt.jiameng.java_test.threads;

/**
 * User: jiameng
 * Date: 15/5/25
 * Time: 下午11:40
 */
public class Hare implements Runnable {
  private int totalStep;
  private int step;
  boolean[] flag = {true, false};

  public Hare(int totalStep){
    this.totalStep = totalStep;
    this.step = 0;
  }

  @Override
  public void run(){
    while(step<totalStep){
      try{
        Thread.sleep(1000);
        boolean isHareSleep = flag[((int)(Math.random()*10))%2];
        if(isHareSleep){
          System.out.println("兔子睡着了……");
        }else{
          step = step+2;
          System.out.println("兔子跑了"+step+"步");
        }
      }catch (InterruptedException e){
        e.printStackTrace();
      }
    }
  }

}
