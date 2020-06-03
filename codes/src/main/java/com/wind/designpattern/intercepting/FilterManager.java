package com.wind.designpattern.intercepting;

public class FilterManager<T, R> {
    private final FilterChain<T, R> filterChain = new FilterChain<>();

    public FilterManager<T, R> addFilter(Filter<T, R> filter) { filterChain.addFilter(filter); return this; }

    public R filterRequest(T t) {
        return filterChain.execute(t);
    }
}
