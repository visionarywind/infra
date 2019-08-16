package com.wind.core.filter;

import java.util.concurrent.Future;

public interface Filter<ReqIn, RepOut, ReqOut, RepIn> {
	Future<RepOut> apply(ReqIn req, Service<ReqOut, RepIn> service);

	default Service<ReqIn, RepOut> andThen(Service<ReqOut, RepIn> service) {
		return request -> apply(request, service);
	}

	default <Req, Rep> Filter<ReqIn, RepOut, Req, Rep> andThen(Filter<ReqOut, RepIn, Req, Rep> next) {
		return (request, service) -> apply(request, next.andThen(service));
	}
}
