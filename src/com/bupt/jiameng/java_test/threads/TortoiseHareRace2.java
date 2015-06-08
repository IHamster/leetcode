package com.bupt.jiameng.java_test.threads;

/**
 * User: jiameng
 * Date: 15/5/25
 * Time: 下午11:44
 */
public class TortoiseHareRace2 {
  public static void main(String[] args){
    Thread tortoise = new Thread(new Tortoise(10));
    Thread hare = new Thread(new Hare(10));
    tortoise.start();
    hare.start();
  }
}
