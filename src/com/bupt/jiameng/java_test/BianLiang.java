package com.bupt.jiameng.java_test;

/**
 * User: jiameng
 * Date: 15/4/6
 * Time: 下午10:49
 */
public class BianLiang{
  public int b;
  private final int a;
  public BianLiang(){
    a = 1;
  }
  public static void main(String[] args){
//    BianLiang b = new BianLiang();
//    System.out.println(b.b);
//    int a = -10>>1;
//    int c = -10>>>1;
//    System.out.println(Integer.toBinaryString(10));
//    System.out.println(Integer.toBinaryString(10>>1));
//    System.out.println(Integer.toBinaryString(10>>>1));
//    System.out.println(Integer.toBinaryString(-10));
//    System.out.println(Integer.toBinaryString(-10>>1));
//    System.out.println(Integer.toBinaryString(-10>>>1));
//    System.out.println(-2<<3);
//    System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
//    System.out.println(Integer.toBinaryString(Integer.MIN_VALUE-1));
//    System.out.println(Integer.MIN_VALUE-1);
//    System.out.println(c);
//
//    String d = "a" + "b";
//    String e = "a" + "b";

//    if(d == e)
//      System.out.println("is equal");

//    double a = 1/3;
//    double b = 1/3;
//    if(a==b)
//      System.out.println("equal");
//    else
//      System.out.println("false");
//int c = 9;
//    System.out.println(c>>1);
    int c = -2147483647;
        System.out.println(Integer.toBinaryString(c));
        System.out.println(Integer.toBinaryString(c<<1));
    System.out.println(c<<1);

    StringBuilder sb = new StringBuilder();
    String a = "";
  }
}
