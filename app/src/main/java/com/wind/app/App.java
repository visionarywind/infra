package com.wind.app;

import com.wind.concurrent.counter.CounterExecutor;
import com.wind.designpattern.InterceptingFilterExecutor;
import com.wind.reference.SoftReferenceInstance;

class App {
  public static void main(String[] args) throws Exception {
      // new CounterExecutor().start();
      // new InterceptingFilterExecutor().start();
      // new ThreadHappenBefore().start();
      new SoftReferenceInstance().start();
  }

  private static String greetings() {
    return "Hi";
  }
}
