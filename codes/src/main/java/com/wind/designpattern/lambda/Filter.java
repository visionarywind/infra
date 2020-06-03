package com.wind.designpattern.lambda;

@FunctionalInterface
public interface Filter<ReqIn, RepOut, ReqOut, RepIn> {
    RepOut apply(ReqIn req, Service<ReqOut, RepIn> service);

    default <Req, Rep> Filter<ReqIn, RepOut, Req, Rep> then(Filter<ReqOut, RepIn, Req, Rep> next) {
        return (request, service) -> apply(request, next.action(service));
    }

    default Service<ReqIn, RepOut> action(Service<ReqOut, RepIn> service) {
        return request -> apply(request, service);
    }
}
