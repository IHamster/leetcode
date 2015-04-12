package com.bupt.jiameng.offer;

/**
 * User: jiameng
 * Date: 15/4/9
 * Time: 下午8:27
 */
public class Question12 {
//  public void print1ToMaxOfNDigits(int n){
//    if(n < 1) return;
//
//    int[] numbers = new int[n+1];
//
//    plusOne(numbers);
//
//    while(numbers[0] != 1){
//      print(numbers);
//      plusOne(numbers);
//
//    }
//  }
//
//  public void plusOne(int[] numbers){
//    int cache = 0;//保存进位
//
//    for(int i = numbers.length-1;i>=0;i--){
//      int tmp = 0;
//      if(i == numbers.length-1){
//        tmp =  numbers[i]+1;
//      }else{
//        tmp = (numbers[i]+cache);
//      }
//      numbers[i] = tmp%10;
//        cache = tmp/10;
//    }
//  }

  public void print1ToMaxOfNDigits(int n){
    if(n<=0){
      return;
    }
    int[] numbers = new int[n];
    for(int i=0;i<10;i++){
      numbers[0]=i;
      print1ToMaxRecursion(numbers,n,0);
    }
  }

  public void print1ToMaxRecursion(int[] numbers,int length,int index){
    if(index ==length-1){//如果是数组的最后一个，即个位的时候，打印。
      print(numbers);
      return;
    }
    for(int i=0;i<10;i++){
      numbers[index+1]=i;
      print1ToMaxRecursion(numbers,length,index+1);
    }
  }

  public void print(int[] numbers){
    int i =0;
    while(i<numbers.length && numbers[i]==0)
      i++;
    if(i == numbers.length){
//      System.out.println(0);
      return;
    }
    while(i< numbers.length)
      System.out.print(numbers[i++]);
    System.out.println();
  }

  public static void main(String[] args){
    Question12 q = new Question12();
    q.print1ToMaxOfNDigits(0);
  }
}
