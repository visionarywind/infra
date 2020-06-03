package com.wind.designpattern.chained;

public abstract class AbstractInterceptor<Req, Rep> implements Interceptor<Req, Rep> {
    protected Object before(Invocation<Req, Rep> inv) { return null; }
    protected Object after(Invocation<Req, Rep> inv) { return null; }

    @Override
    public Object round(Invocation<Req, Rep> inv, Chain chain) {
        before(inv);
        Object ret = chain.doNext();
        after(inv);
        return ret;
    }
}
