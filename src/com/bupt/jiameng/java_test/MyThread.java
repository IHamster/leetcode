package com.bupt.jiameng.java_test;

/**
 * User: jiameng
 * Date: 15/4/27
 * Time: 下午11:11
 */
public class MyThread {
  public static void main(String[] args){
    Runnable r1 = new Test1();
    Runnable r2 = new Test2();
    Thread t3 = new Test3();
//    Thread t1 = new Thread(r1);
//    Thread t2 = new Thread(r2);
//    t1.start();
//    t2.start();
    t3.start();
    r1.run();
    r2.run();
//    t3.start();
  }
}

class Test1 implements Runnable{
  @Override
  public void run() {
    for(int i = 0;i<10000;i++){
      System.out.println("Test1 :"+i);
    }
  }
}

class Test2 implements Runnable{
  @Override
  public void run() {
    for(int i = 0;i<10000;i++){
      System.out.println("Test2 :"+i);
    }
  }
}

class Test3 extends Thread{
  @Override
  public void run() {
    for(int i = 0;i<10000;i++){
      System.out.println("Test3 :"+i);
    }
  }
}
