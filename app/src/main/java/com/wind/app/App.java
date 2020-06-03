package com.wind.app;

import com.wind.concurrent.CounterExecutor;
import com.wind.designpattern.InterceptingFilterExecutor;

class App {
  public static void main(String[] args) throws Exception {
    // System.out.println(greetings());
      // new CounterExecutor().start();
      new InterceptingFilterExecutor().start();
  }

  private static String greetings() {
    return "Hi";
  }
}
