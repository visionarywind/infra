package com.wind.designpattern.lambda;

@FunctionalInterface
public interface SampleFilter<Req, Rep> extends Filter<Req, Rep, Req, Rep> {
    Rep apply(Req req, Service<Req, Rep> service);
}
