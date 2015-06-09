package com.bupt.jiameng.java_test.reflect;

/**
 * User: jiameng
 * Date: 15/6/9
 * Time: 上午12:30
 */
public class Student {
  private String name;
  private int score;

  public Student(){}

  public Student(String name, int score){
    this.name =  name;
    this.score = score;
  }

  public void setName(String name){
    this.name = name;
  }

  public String getName(){
    return this.name;
  }

  public void setScore(int score){
    this.score = score;
  }

  public int getScore(){
    return this.score;
  }

  private void print(){
    System.out.println("hahahahaahah");
  }
}
