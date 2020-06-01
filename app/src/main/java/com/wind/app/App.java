package com.wind.app;

import com.wind.concurrent.CounterExecutor;

class App {
  public static void main(String[] args) throws Exception {
    // System.out.println(greetings());
      new CounterExecutor().start();
  }

  private static String greetings() {
    return "Hi";
  }
}
