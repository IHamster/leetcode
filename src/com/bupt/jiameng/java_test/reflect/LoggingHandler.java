package com.bupt.jiameng.java_test.reflect;

import com.bupt.jiameng.java_test.ExceptionTest;
import sun.rmi.runtime.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * User: jiameng
 * Date: 15/6/10
 * Time: 上午12:00
 */
public class LoggingHandler  implements InvocationHandler{
  private Object target;

  public Object bind(Object target){
    this.target = target;
    return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    Object result = null;
    try{
      log("start invoke");
      result = method.invoke(target,args);
      log("end invoke");
    }catch (Exception e){
      log(e.getMessage());
    }
    return result;
  }

  private void log(String message){
    Logger.getLogger(LoggingHandler.class.getName()).log(Level.INFO,message);
  }

  public static void main(String[] args){
    LoggingHandler log =  new LoggingHandler();
    System.out.println(System.getProperty("java.class.path"));

  }
}
