package com.wind.designpattern.intercepting;

public abstract class AbstractFilter<T, R> implements Filter<T, R> {
    private Filter<T, R> next;

    public AbstractFilter() { }
    public AbstractFilter(Filter<T, R> next) {
        this.next = next;
    }

    @Override
    public void setNext(Filter<T, R> filter) {
        this.next = filter;
    }

    @Override
    public Filter<T, R> getNext() {
        return next;
    }

    @Override
    public Filter<T, R> getLast() {
        Filter<T, R> last = this;
        while (last.getNext() != null) { last = last.getNext(); }
        return last;
    }

    @Override
    public R execute(T t) {
        if (getNext() != null) { return getNext().execute(t); } else { return null; }
    }
}
