package com.wind.designpattern.chained;

public interface InterceptorChain<Req, Rep> {
    void addInterceptor(Interceptor<Req, Rep> interceptor);
}
