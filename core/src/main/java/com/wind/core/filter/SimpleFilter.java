package com.wind.core.filter;

import java.util.concurrent.Future;

public abstract class SimpleFilter<Req, Rep> implements Filter<Req, Rep, Req, Rep> {
	public abstract Future<Rep> apply(Req req, Service<Req, Rep> service);
}
