package com.wind.core.filter;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class PlainFuture<E> implements Future<E> {
	private E value;

	public static <E> PlainFuture valueOf(E value) {
		return new PlainFuture<>(value);
	}

	private PlainFuture(E value) {
		this.value = value;
	}

	@Override
	public boolean cancel(boolean mayInterruptIfRunning) {
		return false;
	}

	@Override
	public boolean isCancelled() {
		return false;
	}

	@Override
	public boolean isDone() {
		return true;
	}

	@Override
	public E get() {
		return value;
	}

	@Override
	public E get(long timeout, TimeUnit unit) {
		return value;
	}
}
