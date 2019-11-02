package com.wind.core.util;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Futures {
	public static <T> T get(Future<T> future) {
		try {
			return future.get();
		} catch (InterruptedException | ExecutionException e) {
			throw new IllegalStateException("[Futures] get failed", e);
		}
	}
}
