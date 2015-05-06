package com.bupt.jiameng.java_test;

/**
 * User: jiameng
 * Date: 15/5/4
 * Time: 下午8:33
 */
public class Test_Finaly {
  public int test(){
    int x = 1;
    try{
      return x;
    }finally {
      ++x;
      System.out.println("123="+x);
//      return x;
    }
  }

  public static void main(String[] arg){
    Test_Finaly t = new Test_Finaly();
//    int a = t.test();
    System.out.println(t.test());
  }
}
