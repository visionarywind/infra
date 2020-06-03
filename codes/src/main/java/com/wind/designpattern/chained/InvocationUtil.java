package com.wind.designpattern.chained;

public class InvocationUtil {
    @SuppressWarnings("rawtypes")
    private static final ThreadLocal<Invocation> invocationThreadLocal = new ThreadLocal<>();

    @SuppressWarnings("unchecked")
    public static <T, R> Invocation<T, R> get() {
        return invocationThreadLocal.get();
    }

    public static <T, R> void set(Invocation<T, R> inv) {
        invocationThreadLocal.set(inv);
    }
}
