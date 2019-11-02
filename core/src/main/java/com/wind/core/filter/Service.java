package com.wind.core.filter;

import java.util.concurrent.Future;

public interface Service<Req, Rep> {
	Future<Rep> apply(Req req);
}