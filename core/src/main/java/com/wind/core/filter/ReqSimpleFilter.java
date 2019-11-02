package com.wind.core.filter;

import java.util.concurrent.Future;

/*
* ReqSimpleFilter只关心输入参数，实现before方法就好，返回参数作为service的输入
* */
public abstract class ReqSimpleFilter<Req, Rep> extends SimpleFilter<Req, Rep> {
	public abstract Req before(Req req);

	public Future<Rep> apply(Req req, Service<Req, Rep> service) {
		return service.apply(before(req));
	}

}
