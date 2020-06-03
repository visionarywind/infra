package com.wind.designpattern;

import java.lang.ref.Reference;

import com.wind.designpattern.chained.AbstractEngine;
import com.wind.designpattern.chained.AbstractEngineChain;
import com.wind.designpattern.chained.AbstractInterceptor;
import com.wind.designpattern.chained.Chain;
import com.wind.designpattern.chained.Engine;
import com.wind.designpattern.chained.EngineChain;
import com.wind.designpattern.chained.Interceptor;
import com.wind.designpattern.chained.Invocation;
import com.wind.designpattern.chained.InvocationUtil;
import com.wind.designpattern.intercepting.AbstractFilter;
import com.wind.designpattern.intercepting.Filter;
import com.wind.designpattern.intercepting.FilterManager;
import com.wind.designpattern.lambda.SampleFilter;
import com.wind.designpattern.lambda.Service;

public class InterceptingFilterExecutor {
    public void start() {
        // 初始输入 "init"
        // 1层 -> 输入加A，结果加Z
        // 2层 -> 输入加B，结果加Y
        // 3层 -> 输入加C，结果加X
        // 最终预期 -> CBAinitXYZ
        testLambda();
        testIntercepting();
        testChained();
    }

    private void testLambda() {
        System.out.println("---------- lambda testing ----------");
        SampleFilter<String, String> firstLevelFilter = (req, service) -> service.apply("A" + req) + "Z";
        SampleFilter<String, String> secondLevelFilter = (req, service) -> service.apply("B" + req) + "Y";
        SampleFilter<String, String> thirdLevelFilter = (req, service) -> service.apply("C" + req) + "X";
        Service<String, String> service = s -> s;

        Service<String, String> action = firstLevelFilter
            .then(secondLevelFilter)
            .then(thirdLevelFilter)
            .action(service);
        System.out.println(action.apply("init"));
    }

    private void testIntercepting() {
        System.out.println("---------- InterceptingFilter testing ----------");
        FilterManager<String, String> manager = new FilterManager<>();
        Filter<String, String> firstFilter = new com.wind.designpattern.intercepting.SampleFilter<String>() {
            @Override
            public String execute(String s) {
                return super.execute("A" + s) + "Z";
            }
        };
        Filter<String, String> secondFilter = new com.wind.designpattern.intercepting.SampleFilter<String>() {
            @Override
            public String execute(String s) {
                return super.execute("B" + s) + "Y";
            }
        };
        Filter<String, String> thirdFilter = new com.wind.designpattern.intercepting.SampleFilter<String>() {
            @Override
            public String execute(String s) {
                return super.execute("C" + s) + "X";
            }
        };
        manager.addFilter(firstFilter)
            .addFilter(secondFilter)
            .addFilter(thirdFilter);
        System.out.println(manager.filterRequest("init"));
    }

    private void testChained() {
        System.out.println("---------- Chained testing ----------");
        AbstractEngineChain realEngine = new AbstractEngineChain();
        Engine passEngine = chain -> {
            Invocation<StringBuilder, StringBuilder> inv = InvocationUtil.get();
            inv.getResponse().append(inv.getRequest());
            return chain.doNext();
        };
        AbstractEngine<StringBuilder, StringBuilder> abstractEngine = new AbstractEngine<>();
        Interceptor<StringBuilder, StringBuilder> firstInterceptor = new AbstractInterceptor<StringBuilder, StringBuilder>() {
            @Override
            protected Object before(Invocation<StringBuilder, StringBuilder> inv) {
                return inv.getResponse().insert(0, "A");
            }

            @Override
            protected Object after(Invocation<StringBuilder, StringBuilder> inv) {
                return inv.getResponse().append("Z");
            }
        };
        Interceptor<StringBuilder, StringBuilder> secondInterceptor = new AbstractInterceptor<StringBuilder, StringBuilder>() {
            @Override
            protected Object before(Invocation<StringBuilder, StringBuilder> inv) {
                return inv.getResponse().insert(0, "B");
            }

            @Override
            protected Object after(Invocation<StringBuilder, StringBuilder> inv) {
                return inv.getResponse().append("Y");
            }
        };
        Interceptor<StringBuilder, StringBuilder> thirdInterceptor = (inv, chain) -> {
            StringBuilder rep = inv.getResponse();
            rep.insert(0, "C").append("X");
            return chain.doNext();
        };

        realEngine.addEngine(abstractEngine);
        realEngine.addEngine(passEngine);
        abstractEngine.addInterceptor(firstInterceptor);
        abstractEngine.addInterceptor(secondInterceptor);
        abstractEngine.addInterceptor(thirdInterceptor);
        InvocationUtil.set(new Invocation<StringBuilder, StringBuilder>() {
            private final StringBuilder req = new StringBuilder("init");
            private final StringBuilder rep = new StringBuilder();
            @Override
            public StringBuilder getRequest() {
                return req;
            }
            @Override
            public StringBuilder getResponse() {
                return rep;
            }
        });
        realEngine.doNext();
        System.out.println(((StringBuilder)(InvocationUtil.get().getResponse())).toString());
    }
}
