package com.wind.core.filter;

import java.util.concurrent.Future;

import com.wind.core.util.Futures;

/*
 * RepSimpleFilter只关心结果，after，返回参数作为service的输出
 * */
public abstract class RepSimpleFilter<Req, Rep> extends SimpleFilter<Req, Rep> {
	public abstract Rep after(Rep rep);

	public Future<Rep> apply(Req req, Service<Req, Rep> service) {
		Rep rep = Futures.get(service.apply(req));
		return PlainFuture.<Rep>valueOf(after(rep));
	}
}
