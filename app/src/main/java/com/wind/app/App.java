package com.wind.app;

import com.wind.concurrent.counter.CounterExecutor;
import com.wind.designpattern.InterceptingFilterExecutor;
import com.wind.reference.SoftReferenceInstance;
import com.wind.generic.Generic;

class App {
  public static void main(java.lang.String[] args) throws Exception {
      // new CounterExecutor().start();
      // new InterceptingFilterExecutor().start();
      // new ThreadHappenBefore().start();
      // new SoftReferenceInstance().start();
      new Generic().start();
  }

  private static java.lang.String greetings() {
    return "Hi";
  }
}
