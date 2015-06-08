package com.bupt.jiameng.java_test.reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * User: jiameng
 * Date: 15/6/9
 * Time: 上午12:18
 */
public class ConstructorDemo {
  public static void main(String[] args){
//    Array.newInstance()
    try {
      Class clz = Class.forName(args[0]);
      Constructor constructor = clz.getConstructor(Integer.class);
      constructor.newInstance(10);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }

  }
}
