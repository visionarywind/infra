package com.wind.designpattern.chained;

import java.util.ArrayList;
import java.util.List;

public class AbstractEngine<Req, Rep> implements InterceptorChain<Req, Rep>, Engine {
    private final List<Interceptor<Req, Rep>> interceptors = new ArrayList<>();

    @Override
    public void addInterceptor(Interceptor<Req, Rep> interceptor) {
        interceptors.add(interceptor);
    }

    @Override
    public Object execute(EngineChain chain) {
        return new InvocationChain(chain).doNext();
    }

    private class InvocationChain implements Chain {
        private final EngineChain chain;
        private int index = -1;
        private InvocationChain(EngineChain chain) { this.chain = chain; }
        @Override
        public Object doNext() {
            if (++index < interceptors.size()) {
                Interceptor<Req, Rep> interceptor = interceptors.get(index);
                return interceptor.round(InvocationUtil.get(), this);
            } else if (index == interceptors.size()) {
                return null;
            }
            throw new IndexOutOfBoundsException();
        }
    }
}
