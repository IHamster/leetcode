package com.bupt.jiameng.java_test.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * User: jiameng
 * Date: 15/6/9
 * Time: 上午12:35
 */
public class StudentDemo {
  public static void main(String[] args){
//    try {
//      Class clz = Class.forName("com.bupt.jiameng.java_test.reflect.Student");
//      Constructor constructor = clz.getConstructor(String.class,Integer.TYPE);
//      Object obj = constructor.newInstance("jiameng",10);
//      Method getter = clz.getMethod("getName");
//      System.out.println(getter.invoke(obj));
//      Method setter = clz.getMethod("setName",String.class);
//      setter.invoke(obj,"yukun");
//      System.out.println(getter.invoke(obj));
//    } catch (ClassNotFoundException e) {
//      e.printStackTrace();
//    } catch (NoSuchMethodException e) {
//      e.printStackTrace();
//    } catch (InvocationTargetException e) {
//      e.printStackTrace();
//    } catch (InstantiationException e) {
//      e.printStackTrace();
//    } catch (IllegalAccessException e) {
//      e.printStackTrace();
//    }


    try {
      Class clz = Class.forName("com.bupt.jiameng.java_test.reflect.Student");
      Object obj = clz.newInstance();
      Field name = clz.getDeclaredField("name");
      name.setAccessible(true);
      System.out.println(name.get(obj));
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (NoSuchFieldException e) {
      e.printStackTrace();
    }

  }
}
