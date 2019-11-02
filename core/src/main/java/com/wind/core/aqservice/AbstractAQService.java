package com.wind.core.aqservice;

public abstract class AbstractAQService implements AQService {
	protected AbstractAQService next;

	public void setNext(AbstractAQService next) {
		this.next = next;
	}
}
