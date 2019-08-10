package com.wind.core.filter;

import org.junit.Test;

public class TestFilter {
	@Test
	public void testFilter() {
		Filter filter1 = new AbstractFilter() {
			@Override
			public String execute(Order order) {
				super.execute(order);
				System.out.println("filter1");
				return null;
			}
		};

		Filter filter2 = new AbstractFilter() {
			@Override
			public String execute(Order order) {
				super.execute(order);
				System.out.println("filter2");
				return null;
			}
		};

		FilterManager manager = new FilterManager();
		manager.addFilter(filter1);
		manager.addFilter(filter2);

		manager.filterRequest(null);
	}
}