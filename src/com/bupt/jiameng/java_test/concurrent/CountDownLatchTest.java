package com.bupt.jiameng.java_test.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: jiameng
 * Date: 15/9/8
 * Time: 下午6:54
 */
//CountDownLatch是一个同步辅助类，犹如倒计时计数器，创建对象时通过构造方法设置初始值，
// 调用CountDownLatch对象的await()方法则处于等待状态，调用countDown()方法就将计数器减1
// ，当计数到达0时，则所有等待者或单个等待者开始执行。

/**
 * 该程序用来模拟发送命令与执行命令，主线程代表指挥官，新建3个线程代表战士，战士一直等待着指挥官下达命令，
 * 若指挥官没有下达命令，则战士们都必须等待。一旦命令下达，战士们都去执行自己的任务，指挥官处于等待状态，战士们任务执行完毕则报告给
 * 指挥官，指挥官则结束等待。
 */
public class CountDownLatchTest {
  public static void main(String[] args) {
    ExecutorService exec = Executors.newCachedThreadPool();//创建一个线程池
    //指挥官的命令，设置为1，指挥官一下达命令，则cutDown,变为0，战士们执行任务
    final CountDownLatch command = new CountDownLatch(1);
    //因为有三个战士，所以初始值为3，每一个战士执行任务完毕则cutDown一次，当三个都执行完毕，变为0，则指挥官停止等待。
    final CountDownLatch soldier = new CountDownLatch(3);

    for (int i = 0; i < 3; i++) {
      Runnable r = new Runnable() {
        @Override
        public void run() {
          try {
            System.out.println("线程" + Thread.currentThread().getName() + "正准备接受命令");
            command.await();
            System.out.println("线程" + Thread.currentThread().getName() + "已接受命令");
            Thread.sleep((long) (Math.random() * 10000));
            System.out.println("线程" + Thread.currentThread().getName() + "回应命令处理结果");
            soldier.countDown(); //任务执行完毕，返回给指挥官，soldier减1。
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      };
      exec.execute(r);//为线程池添加任务
    }

    try {
      Thread.sleep((long) (Math.random() * 10000));
      System.out.println("线程" + Thread.currentThread().getName() + "即将发布命令");
      command.countDown();
      System.out.println("线程" + Thread.currentThread().getName() + "已发布命令，等待执行结果");
      soldier.await();
      System.out.println("线程" + Thread.currentThread().getName() + "已收到所有响应结果");

    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    exec.shutdown(); //任务结束，停止线程池的所有线程

  }

}
