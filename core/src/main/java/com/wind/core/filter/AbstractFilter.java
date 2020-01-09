package com.wind.core.filter;

/*
 * interface : Future<RepOut> apply(ReqIn request, Service<ReqOut, RepIn> service);
 */
public abstract class AbstractFilter<ReqIn, RepOut, ReqOut, RepIn> implements Filter<ReqIn, RepOut, ReqOut, RepIn> {
    // and method : and(filter) => filter
    //  ReqIn ( ReqOut, RepIn ) RepOut
    //  ReqOut (Req, Rep) RepIn
    public <Req, Rep>Filter<ReqIn, RepOut, Req, Rep> and(AbstractFilter<ReqOut, RepIn, Req, Rep> next) {
        return (req, service) -> apply(req, next.then(service));
    }

    // then method : then(service) => service
    public Service<ReqIn, RepOut> then(Service<ReqOut, RepIn> service) {
        return req -> apply(req, service);
    }
}
