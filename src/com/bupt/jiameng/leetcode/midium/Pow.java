package com.bupt.jiameng.leetcode.midium;

/**
 * User: jiameng
 * Date: 15/4/9
 * Time: 下午5:30
 */
public class Pow {
  public double pow(double x, int n) {
    if(x ==0 && n<0)
      return  Double.POSITIVE_INFINITY;//返回正无穷
    if(x == 1.0)
      return x;

//    if(x == -1.0 && ((n & 0x1) == 1))
//      return x;
//
//    if(x == -1.0 && (n&0x1)==0)
//      return 1.0;

    if(n>=0){
      return doPowWithPositiveN(x, n);
    }else{
      return 1.0/doPowWithPositiveN(x,n*(-1));
    }
  }

  public double doPowWithPositiveN(double x, int n){
    if(n == 0)
      return 1;
    if(n==1)
      return x;
    double result = doPowWithPositiveN(x,n>>1);//除2
    if((n & 0x1) == 1)
      return result*result*x;
    return result*result;
  }

  //other people do
//  public double pow(double x, int n) {
//    if(n == 0) return 1;
//    if(n < 0){
//      x = 1 / x;
//      n = -n;
//    }
//    double res = pow(x, n/2);
//    if(n % 2 == 0) return res*res;
//    else return res*res*x;
//  }

//  public double pow(double x, int n){
//    if(n == 0) return 1.0;
//
//    if(n > 0)
//      return pow(x, n>>1)
//  }

  public static void main(String[] args){
    Pow p = new Pow();
    System.out.println(p.pow(0,-2147483648));
  }


}
