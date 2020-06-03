package com.wind.designpattern.chained;

public interface Interceptor<Req, Rep> {
    Object round(Invocation<Req, Rep> inv, Chain chain);
}
