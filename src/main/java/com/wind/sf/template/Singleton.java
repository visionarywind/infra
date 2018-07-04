package com.wind.sf.template;

/**
 * Created by shanfeng on 2018/7/4.
 */
public class Singleton {
    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static Singleton instance = new Singleton();
    }

    private Singleton() {}
}
