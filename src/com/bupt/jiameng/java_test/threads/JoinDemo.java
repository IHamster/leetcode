package com.bupt.jiameng.java_test.threads;

import com.bupt.jiameng.java_test.ExceptionTest;

/**
 * User: jiameng
 * Date: 15/5/28
 * Time: 上午12:31
 */
//当线程使用join加入至另一线程时，另一线程会等待被加入的线程工作完毕，然后再继续它的动作
//  join的意思表示将线程加入成为另一线程的流程中
public class JoinDemo {
  public static void main(String[] args){
    System.out.println("Main thread start^^^^^");
    Thread thread = new Thread(){
      @Override
      public void run() {
        try{
          System.out.println("Thread b start^^^^^^");
          for(int i = 0;i<5;i++){
            Thread.sleep(1000);
            System.out.println("Thread b run^^^^^^^");
          }
          System.out.println("Thread B will over");
        }catch (Exception e){
          e.printStackTrace();
        }
      }
    };

    thread.start();

//    try {
//      thread.join();
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
    System.out.println("Main thread will over");
  }
}
