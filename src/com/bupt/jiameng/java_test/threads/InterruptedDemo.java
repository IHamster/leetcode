package com.bupt.jiameng.java_test.threads;

/**
 * User: jiameng
 * Date: 15/5/26
 * Time: 上午12:09
 */
public class InterruptedDemo {
  public static void main(String[] args){
    Thread thread = new Thread(){
      @Override
      public void run() {
        while(true){
          System.out.println("laallalaa");
//          try {
////            Thread.sleep(10000);
//          } catch (InterruptedException e) {
//            System.out.println("i am aweak");
//            e.printStackTrace();
//          }
        }
      }
    };

    thread.start();
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    thread.stop();
  }
}
