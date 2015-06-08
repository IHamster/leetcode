package com.bupt.jiameng.java_test.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * User: jiameng
 * Date: 15/6/6
 * Time: 下午11:59
 */
public class FutureCallableDemo2 {
  public static long fibonacci(long n){
    if(n<=1) return n;
    else
      return fibonacci(n-1)+fibonacci(n-2);
  }

  public static void main(String[] args){
    ExecutorService executorService = Executors.newCachedThreadPool();
    System.out.println("i want fib 30");
    Callable<Long> call = new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        return fibonacci(30);
      }
    };
    Future<Long> future = executorService.submit(call);
    System.out.println("i am busy");
    try {
      Thread.sleep(3000);
      System.out.println("the fib 30 is "+future.get());
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
